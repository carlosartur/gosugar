package transpiler

import (
    "fmt"
    "strings"
)

type Arg struct {
    Name string
    Type string
}

type Method struct {
    Name string
    Args []Arg
    ReturnType []string
}


func (Arg) Constructor(name string, typ string) *Arg {
    this := new(Arg)
    this.Name = name
    this.Type = typ
    return this

}

func (Method) Constructor(name string, args []Arg, returnType []string) *Method {
    this := new(Method)
    this.Name = name
    this.Args = args
    this.ReturnType = returnType
    return this

}

func (this *Method) AddArg(name string, argType string) {
    newArg := Arg{}.Constructor(name, argType)    
    this.Args = append(this.Args,*newArg)

}

func (this *Method) AddReturnType(returnType string) {
    this.ReturnType = append(this.ReturnType,returnType)

}

func (this *Method) Compare(other *Method) bool {
    if this.Name!=other.Name {
        return false
    }
    if len(this.Args)!=len(other.Args) {
        return false
    }
    for i :=  range this.Args {
        if this.Args[i].Name!=other.Args[i].Name||this.Args[i].Type!=other.Args[i].Type {
            return false
        }
    }
    if len(this.ReturnType)!=len(other.ReturnType) {
        return false
    }
    for i :=  range this.ReturnType {
        if this.ReturnType[i]!=other.ReturnType[i] {
            return false
        }
    }
    return true

}

func (this *Method) Signature() string {
    args := []string{}
    for _, arg := range this.Args {
        args = append(args,fmt.Sprintf("%s %s",arg.Name,arg.Type))
    }
    returnValues := ""
    if len(this.ReturnType)>0 {
        returnValues = strings.Join(this.ReturnType,", ")
        if len(this.ReturnType)>1 {
            returnValues = fmt.Sprintf("(%s)",returnValues)
        }
    }
    if returnValues!="" {
        return fmt.Sprintf("%s(%s) %s",this.Name,strings.Join(args,", "),returnValues)
    }
    return fmt.Sprintf("%s(%s)",this.Name,strings.Join(args,", "))

}

func (this *Method) String() string {
    return fmt.Sprintf("Name: %s, Args: %v, ReturnType: %v",this.Name,this.Args,this.ReturnType)

}

