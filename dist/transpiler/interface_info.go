package transpiler

import "fmt"

type InterfaceInfo struct {
    Name string
    Methods []Method
}

func (InterfaceInfo) Constructor() *InterfaceInfo {
    this := new(InterfaceInfo)
    return this
}


func (this *InterfaceInfo) AddMethod(method Method) {
    this.Methods = append(this.Methods,method)

}

func (this *InterfaceInfo) PrintInterfaceInfo() {
    fmt.Printf("Interface: %s\n", this.Name)
    for _, method := range this.Methods {
        fmt.Printf("\tMethod: %s\n", method.Name)
        for _, arg := range method.Args {
            fmt.Printf("\t\tArg: %s %s\n", arg.Name, arg.Type)
        }
        for _, returnType := range method.ReturnType {
            fmt.Printf("\t\tReturnType: %s\n", returnType)
        }
    }

}

