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

// NewMethod creates a new Method instance with the given name, argument list, and return type list.
//
// The method name is the name of the method, and the argument list contains the names and types of
// the arguments the method takes. The return type list contains the types of the values returned by
// the method.
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

// AddReturnType adds a return type to the method.
//
// The return type is added to the end of the existing return type list.
//
// If the method has no return type, a single return type is added.
// If the method has multiple return types, the new return type is added
// to the end of the list.
func (m *Method) AddReturnType(returnType string) {
	m.ReturnType = append(m.ReturnType, returnType)
}

// Compare compares the current method with another method to determine
// if they are equivalent. It returns true if both methods have the same
// name, identical argument lists (including argument names and types),
// and identical return types. Otherwise, it returns false.
func (m *Method) Compare(other *Method) bool {
	if m.Name != other.Name {
		return false
	}

	if len(m.Args) != len(other.Args) {
		return false
	}

	for i := range m.Args {
		if m.Args[i].Name != other.Args[i].Name || m.Args[i].Type != other.Args[i].Type {
			return false
		}
	}

	if len(m.ReturnType) != len(other.ReturnType) {
		return false
	}

	for i := range m.ReturnType {
		if m.ReturnType[i] != other.ReturnType[i] {
			return false
		}
	}

	return true
}

// Signature returns a string representation of the method in the format
// "<name>(<args>) <returnType>", where <name> is the name of the method,
// <args> is a comma-separated list of argument names and types, and
// <returnType> is a comma-separated list of return types.
//
// If the method has multiple return types, the return type list is
// enclosed in parentheses. If the method has no return type, the
// return type list is empty.
func (m *Method) Signature() string {
	args := []string{}
	for _, arg := range m.Args {
		args = append(args, fmt.Sprintf("%s %s", arg.Name, arg.Type))
	}

	returnValues := ""
	if len(m.ReturnType) > 0 {
		returnValues = strings.Join(m.ReturnType, ", ")
		if len(m.ReturnType) > 1 {
			returnValues = fmt.Sprintf("(%s)", returnValues)
		}
	}

	if returnValues != "" {
		return fmt.Sprintf("%s(%s) %s", m.Name, strings.Join(args, ", "), returnValues)
	}

	return fmt.Sprintf("%s(%s)", m.Name, strings.Join(args, ", "))
}



// String returns a string representation of the method.
//
// The returned string is in the format "Name: <name>, Args: <args>, ReturnType: <returnType>",
// where <name> is the name of the method, <args> is a slice of strings representing
// the names and types of the arguments, and <returnType> is a slice of strings
// representing the types of the return values.
func (m *Method) String() string {
	return fmt.Sprintf("Name: %s, Args: %v, ReturnType: %v", m.Name, m.Args, m.ReturnType)
}

