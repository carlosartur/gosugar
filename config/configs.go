package config

import "strings"

type Configs map[string]string

var CurrentConfigs Configs

func init() {
	CurrentConfigs = NewConfigs(map[string]string{
		"TRANSPILE_PATH": "dist",
	})
}

func NewConfigs(defaults map[string]string) Configs {
	configs := make(Configs)
	for key, value := range defaults {
		configs[key] = value
	}
	return configs
}

func (c Configs) Get(key string) string {
	return c[key]
}

func (c Configs) Set(key string, value string) {
	c[key] = value
}

func (c Configs) SetEnvContent(envContent string) {
	lines := strings.Split(envContent, "\n")
	for _, line := range lines {
		line = strings.TrimSpace(line)
		if line == "" || strings.HasPrefix(line, "#") {
			continue
		}

		parts := strings.SplitN(line, "=", 2)
		if len(parts) != 2 {
			continue
		}

		key := strings.TrimSpace(parts[0])
		value := strings.TrimSpace(parts[1])

		if strings.HasPrefix(value, "\"") && strings.HasSuffix(value, "\"") {
			value = strings.Trim(value, "\"")
		}

		c.Set(key, value)
	}
}
