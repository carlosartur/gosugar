package transpiler

type Field struct {
	Name string
	Type string
}

type ClassInfo struct {
	Name string
	Methods []Method
	Uses []string
	Fields []Field
}

func NewClassInfo(name string, methods []Method) *ClassInfo {
	return &ClassInfo{
		Name: name,
		Methods: methods,
	}
}

func (c *ClassInfo) AddMethod(method Method) {
	c.Methods = append(c.Methods, method)
}

func (c *ClassInfo) AddUse(use string) {
	c.Uses = append(c.Uses, use)
}

func (c *ClassInfo) AddField(name string, typ string) {
	field := Field{
		Name: name,
		Type: typ,
	}

	c.Fields = append(c.Fields, field)
}

func (c *ClassInfo) HasConstructor() bool {
	for _, method := range c.Methods {
		if method.Name == "Constructor" {
			return true
		}
	}
	return false
}