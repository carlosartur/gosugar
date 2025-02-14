package transpiler

import "fmt"

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

func (c *ClassInfo) PrintClassInfo() {
	fmt.Printf("Class: %s\n", c.Name)

	if len(c.Uses) > 0 {
		fmt.Println("\tUses:")
		for _, use := range c.Uses {
			fmt.Printf("\t\t%s\n", use)
		}
	}

	if len(c.Fields) > 0 {
		fmt.Println("\tFields:")
		for _, field := range c.Fields {
			fmt.Printf("\t\t%s %s\n", field.Name, field.Type)
		}
	}

	if len(c.Methods) > 0 {
		fmt.Println("\tMethods:")
		for _, method := range c.Methods {
			fmt.Printf("\t\tMethod: %s\n", method.Name)

			if len(method.Args) > 0 {
				fmt.Println("\t\t\tArguments:")
				for _, arg := range method.Args {
					fmt.Printf("\t\t\t\t%s %s\n", arg.Name, arg.Type)
				}
			}

			if len(method.ReturnType) > 0 {
				fmt.Println("\t\t\tReturn Types:")
				for _, returnType := range method.ReturnType {
					fmt.Printf("\t\t\t\t%s\n", returnType)
				}
			}
		}
	}

	if c.HasConstructor() {
		fmt.Println("\tThis class has a constructor.")
	} else {
		fmt.Println("\tThis class does not have a constructor.")
	}
}
