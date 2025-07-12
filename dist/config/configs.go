package config

import "strings"

type Configs map[string]string


func (Configs) NewConfigs(defaults map[string]string) Configs {
    configs := make(Configs)
    for key, value := range defaults {
        configs[key] = value
    }
    return configs

}

func (this *Configs) Get(key string) string {
    configs := *this
    return configs[key]

}

func (this *Configs) Set(key string, value string) {
    configs := *this
    configs[key] = value

}

func (this *Configs) SetEnvContent(envContent string) {
    lines := strings.Split(envContent,"\n")
    for _, line := range lines {
        line = strings.TrimSpace(line)
        if line==""||strings.HasPrefix(line,"#") {
            continue
        }
        parts := strings.SplitN(line,"=",2)
        if len(parts)!=2 {
            continue
        }
        key := strings.TrimSpace(parts[0])
        value := strings.TrimSpace(parts[1])
        if strings.HasPrefix(value,"\"")&&strings.HasSuffix(value,"\"") {
            value = strings.Trim(value,"\"")
        }
        this.Set(key, value)
    }

}

var CurrentConfigs Configs
func init() {
    var defaultConfigs map[string]string = map[string]string{"TRANSPILE_PATH":"dist",}
    CurrentConfigs = Configs{}.NewConfigs(defaultConfigs)

}

