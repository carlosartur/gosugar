package transpiler

import "fmt"

type Arg struct {
	Name string
	Type string
}

type Method struct {
	Name string
	Args []Arg
	ReturnType []string
}

func NewMethod(name string, args []Arg, returnType []string) *Method {
	return &Method{
		Name: name,
		Args: args,
		ReturnType: returnType,
	}
}

func (m *Method) AddArg(name string, argType string) {
	m.Args = append(m.Args, Arg{
		Name: name,
		Type: argType,
	})
}

func (m *Method) AddReturnType(returnType string) {
	m.ReturnType = append(m.ReturnType, returnType)
}

func (m *Method) Compare(other *Method) bool {
	if m.Name != other.Name {
		return false
	}

	for i := 0; i < len(m.Args); i++ {
		if m.Args[i].Name != other.Args[i].Name || m.Args[i].Type != other.Args[i].Type {
			return false
		}
	}

	for i := 0; i < len(m.ReturnType); i++ {
		if m.ReturnType[i] != other.ReturnType[i] {
			return false
		}
	}

	return true
}

func (m *Method) String() string {
	return fmt.Sprintf("Name: %s, Args: %v, ReturnType: %v", m.Name, m.Args, m.ReturnType)
}

