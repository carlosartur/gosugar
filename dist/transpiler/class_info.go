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
    Alias string
}


func (Field) Constructor(name string, typ string) *Field {
    this := new(Field)
    this.Name = name
    this.Type = typ
    return this

}

func (ClassInfo) Constructor(name string) *ClassInfo {
    this := new(ClassInfo)
    this.Name = name
    return this

}

func (this *ClassInfo) SetAlias(alias string) {
    this.Alias = alias

}

func (this *ClassInfo) AddMethod(method Method) {
    this.Methods = append(this.Methods,method)

}

func (this *ClassInfo) AddUse(used ClassInfo) {
    this.Uses = append(this.Uses,used)

}

func (this *ClassInfo) AddMustInterfaceList(mustInterface InterfaceInfo) {
    this.MustInterfaceList = append(this.MustInterfaceList,mustInterface)

}

func (this *ClassInfo) AddField(name string, typ string) {
    field := Field{}.Constructor(name, typ)    
    this.Fields = append(this.Fields,*field)

}

func (this *ClassInfo) HasConstructor() bool {
    for _, method := range this.Methods {
        if method.Name=="Constructor" {
            return true
        }
    }
    return false

}

func (this *ClassInfo) PrintClassInfo() {
    fmt.Printf("Class: %s\n", this.Name)
    if len(this.Uses)>0 {
        fmt.Println("\tUses:")
        for _, anUse := range this.Uses {
            anUse.PrintClassInfo()
        }
    }
    if len(this.MustInterfaceList)>0 {
        fmt.Println("\tMust Implement:")
        for _, mustInterface := range this.MustInterfaceList {
            fmt.Printf("\t\t%s\n", mustInterface.Name)
        }
    }
    if len(this.Fields)>0 {
        fmt.Println("\tFields:")
        for _, field := range this.Fields {
            fmt.Printf("\t\t%s %s\n", field.Name, field.Type)
        }
    }
    if len(this.Methods)>0 {
        fmt.Println("\tMethods:")
        for _, method := range this.Methods {
            fmt.Printf("\t\tMethod: %s\n", method.Name)
            if len(method.Args)>0 {
                fmt.Println("\t\t\tArguments:")
                for _, arg := range method.Args {
                    fmt.Printf("\t\t\t\t%s %s\n", arg.Name, arg.Type)
                }
            }
            if len(method.ReturnType)>0 {
                fmt.Println("\t\t\tReturn Types:")
                for _, returnType := range method.ReturnType {
                    fmt.Printf("\t\t\t\t%s\n", returnType)
                }
            }
        }
    }
    if this.HasConstructor() {
        fmt.Println("\tThis class has a constructor.")
    } else {
        fmt.Println("\tThis class does not have a constructor.")
    }

}

func (this *ClassInfo) GetMethod(name string) *Method {
    for _, method := range this.Methods {
        if method.Name==name {
            return &method
        }
    }
    for _, uses := range this.Uses {
        method := uses.GetMethod(name)
        if method!=nil {
            return method
        }
    }
    return nil

}

func (this *ClassInfo) ImplementsAllInterfaces() bool {
    doImplementsAllInterfaces := true
    for _, itf := range this.MustInterfaceList {
        for _, interfaceMethod := range itf.Methods {
            classMethod := this.GetMethod(interfaceMethod.Name)
            if classMethod==nil {
                doImplementsAllInterfaces = false
                fmt.Printf("Method '%s' from interface '%s' not implemented in '%s'\n", interfaceMethod.Name, itf.Name, this.Name)
                continue
            }
            if !classMethod.Compare(&interfaceMethod) {
                doImplementsAllInterfaces = false
                fmt.Printf("Method '%s' from interface '%s' not compatible with method '%s' in '%s'\n", interfaceMethod.Name, itf.Name, interfaceMethod.Name, this.Name)
                fmt.Printf("\tOn '%s' interface, method looks like '%s'\n", itf.Name, interfaceMethod.Signature())
                fmt.Printf("\tOn '%s' class, method looks like '%s'\n", this.Name, classMethod.Signature())
                continue
            }
        }
    }
    return doImplementsAllInterfaces

}

