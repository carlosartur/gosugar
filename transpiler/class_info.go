package transpiler

import "fmt"

type Field struct {
	Name string
	Type string
}

type ClassInfo struct {
	Name string
	Methods []Method
	Uses []ClassInfo
	Fields []Field
	MustInterfaceList []InterfaceInfo
}

func NewClassInfo(name string, methods []Method) *ClassInfo {
	return &ClassInfo{
		Name: name,
		Methods: methods,
	}
}

// AddMethod adds a method to the class info.
//
// The method is represented as a Method type.
func (c *ClassInfo) AddMethod(method Method) {
	c.Methods = append(c.Methods, method)
}

// AddUse adds a use to the class info.
//
// The use is represented as a ClassInfo type.
func (c *ClassInfo) AddUse(use ClassInfo) {
	c.Uses = append(c.Uses, use)
}

// AddMustInterfaceList adds an interface to the class info's must interface list.
//
// The must interface list contains all the interfaces that the class must implement.
func (c *ClassInfo) AddMustInterfaceList(mustInterface InterfaceInfo) {
	c.MustInterfaceList = append(c.MustInterfaceList, mustInterface)
}

// AddField adds a field to the class info.
//
// The field is represented as a Field type containing the name and type of the field.
func (c *ClassInfo) AddField(name string, typ string) {
	field := Field{
		Name: name,
		Type: typ,
	}

	c.Fields = append(c.Fields, field)
}

// HasConstructor returns whether the class has a constructor method named "Constructor" or not.
func (c *ClassInfo) HasConstructor() bool {
	for _, method := range c.Methods {
		if method.Name == "Constructor" {
			return true
		}
	}
	return false
}

// PrintClassInfo prints a formatted string representation of the class info to the console.
// It recursively prints the uses, fields, and methods of the class, as well as whether it has a
// constructor or not.
func (c *ClassInfo) PrintClassInfo() {
	fmt.Printf("Class: %s\n", c.Name)

	if len(c.Uses) > 0 {
		fmt.Println("\tUses:")
		for _, use := range c.Uses {
			use.PrintClassInfo()
		}
	}

	if len(c.MustInterfaceList) > 0 {
		fmt.Println("\tMust Implement:")
		for _, mustInterface := range c.MustInterfaceList {
			fmt.Printf("\t\t%s\n", mustInterface.Name)
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

// GetMethod finds and returns the method with the given name from the class info,
// first by iterating through the class's methods, and then by recursively searching
// through the methods of the classes the class uses. If no such method is found, it
// returns nil.
func (c *ClassInfo) GetMethod(name string) *Method {
	for _, method := range c.Methods {
		if method.Name == name {
			return &method
		}
	}

	for _, use := range c.Uses {
		method := use.GetMethod(name)
		if method != nil {
			return method
		}
	}

	return nil
}

func (c *ClassInfo) ImplementsAllInterfaces() bool {
	doImplementsAllInterfaces := true

	for _, _interface := range c.MustInterfaceList {
		for _, interfaceMethod := range _interface.Methods {
			classMethod := c.GetMethod(interfaceMethod.Name)

			if classMethod == nil {
				doImplementsAllInterfaces = false
				fmt.Printf("Method '%s' from interface '%s' not implemented in '%s'\n", interfaceMethod.Name, _interface.Name, c.Name)
				continue
			}

			if !classMethod.Compare(&interfaceMethod) {
				doImplementsAllInterfaces = false
				fmt.Printf("Method '%s' from interface '%s' not compatible with method '%s' in '%s'\n", interfaceMethod.Name, _interface.Name, interfaceMethod.Name, c.Name)
				fmt.Printf("\tOn '%s' interface, method looks like '%s'\n", _interface.Name, interfaceMethod.Signature())
				fmt.Printf("\tOn '%s' class, method looks like '%s'\n", c.Name, classMethod.Signature())
				continue
			}

			fmt.Printf(classMethod.Signature() + "\n" + interfaceMethod.Signature() + "\n")
		}
	}

	return doImplementsAllInterfaces
}