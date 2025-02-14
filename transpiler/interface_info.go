package transpiler

import "fmt"

type InterfaceInfo struct {
	Name string
	Methods []Method
}

func (i *InterfaceInfo) AddMethod(method Method) {
	i.Methods = append(i.Methods, method)
}

func (i *InterfaceInfo) PrintInterfaceInfo() {
	fmt.Printf("Interface: %s\n", i.Name)
	
	for _, method := range i.Methods {
		fmt.Printf("\tMethod: %s\n", method.Name)
		
		for _, arg := range method.Args {
			fmt.Printf("\t\tArg: %s %s\n", arg.Name, arg.Type)
		}

		for _, returnType := range method.ReturnType {
			fmt.Printf("\t\tReturnType: %s\n", returnType)
		}
	}
}