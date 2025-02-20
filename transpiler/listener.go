package transpiler

import (
	"fmt"
	"strings"

	"gopp-parser/parser" // Replace with the path to the generated parser

	"reflect"

	"github.com/antlr4-go/antlr/v4"
)

// ClassInfoMap maps class names to their associated ClassInfo instances
var ClassInfoMap = make(map[string]*ClassInfo)

var CurrentClass *ClassInfo

var InterfaceInfoMap = make(map[string]*InterfaceInfo)

var CurrentInterface *InterfaceInfo

var indentationStruct Indentation = 0

var indentationMethod Indentation = 0

// TranspilerListener implements the custom listener
type TranspilerListener struct {
	*parser.BaseGoPlusListener                 // Inherits from the generated base listener
	structBuilder              strings.Builder // For struct composition and attributes
	methodBuilder              strings.Builder // For method declarations and bodies
}

func (t *TranspilerListener) AddStringToStruct(str string) {
	t.structBuilder.WriteString(indentationStruct.String() + str)
}

func (t *TranspilerListener) AddStringToMethod(str string) {
	t.methodBuilder.WriteString(indentationMethod.String() + str)
}

// GoCode combines the generated Go code for the struct and methods
// by concatenating the strings from the structBuilder and methodBuilder.
// It returns the complete Go code representation as a single string.
func (t *TranspilerListener) GoCode() string {
	// Combines struct and methods sequentially
	return t.structBuilder.String() + "\n" + t.methodBuilder.String()
}

// EnterClassDeclaration is called when entering the classDeclaration production.
// It starts a new struct declaration with the class name and adds any composition
// types as fields.
func (t *TranspilerListener) EnterClassDeclaration(ctx *parser.ClassDeclarationContext) {
	className := ctx.IDENTIFIER().GetText()
	t.AddStringToStruct(fmt.Sprintf("type %s struct {\n", className))

	indentationStruct.Increment()

	CurrentClass = &ClassInfo{
		Name: className,
	}

	// Add compositions, if they exist
	if ctx.CompositionList() != nil {
		for _, compCtx := range ctx.CompositionList().AllIDENTIFIER() {
			compName := compCtx.GetText()
			t.AddStringToStruct(fmt.Sprintf("%s\n", compName))

			CurrentClass.AddUse(*ClassInfoMap[compName])
		}
	}

	if ctx.MustInterfaceList() != nil {
		for _, interfaceCtx := range ctx.MustInterfaceList().AllIDENTIFIER() {
			interfaceName := interfaceCtx.GetText()

			CurrentClass.AddMustInterfaceList(*InterfaceInfoMap[interfaceName])
		}
	}
}

// ExitClassDeclaration is called when exiting the classDeclaration production.
// It finalizes the struct declaration by closing the brace and adding a newline.
func (t *TranspilerListener) ExitClassDeclaration(ctx *parser.ClassDeclarationContext) {
	indentationStruct.Decrement()
	t.AddStringToStruct("}\n\n") // Finalizes the struct

	ClassInfoMap[CurrentClass.Name] = CurrentClass

	if !CurrentClass.HasConstructor() {
		t.AddStringToStruct(fmt.Sprintf(
			"func (%s) Constructor() *%s {\n"+
				"    this := new(%s)\n"+
				"    return this\n"+
				"}\n\n",
			CurrentClass.Name,
			CurrentClass.Name,
			CurrentClass.Name,
		))
	}

	// CurrentClass.PrintClassInfo()

	if !CurrentClass.ImplementsAllInterfaces() {
		panic(fmt.Sprintf("Class '%s' does not implement all interfaces on 'must' list\n", CurrentClass.Name))
	}

	CurrentClass = nil
}

// EnterFieldDeclaration is called when entering the fieldDeclaration production.
//
// This listener is responsible for generating the Go code for the field being
// declared. It retrieves the field name and type from the context and writes a
// line of code to the struct builder in the form of "fieldName fieldType".
func (t *TranspilerListener) EnterFieldDeclaration(ctx *parser.FieldDeclarationContext) {
	fieldName := ctx.IDENTIFIER(0).GetText()
	fieldType := ctx.IDENTIFIER(1).GetText()

	if ctx.STAR() != nil {
		fieldType = "*" + fieldType
	}

	t.AddStringToStruct(fmt.Sprintf("%s %s\n", fieldName, fieldType))

	CurrentClass.AddField(fieldName, fieldType)
}

// EnterMethodDeclaration is called when entering the methodDeclaration production.
//
// This listener is responsible for generating the Go code for the method
// being declared. This can be either a constructor or a regular method.
//
// For constructors, the listener will generate the Go code:
//
//	func New<ClassName>(<params>) *<ClassName> {
//	    this := new(<ClassName>)
//	}
//
// For regular methods, the listener will generate the Go code:
//
// func (this *<ClassName>) <MethodName>(<params>) {
// }
//
// The listener is also responsible for finding the parent class of the method
// by traversing up the tree of contexts.
func (t *TranspilerListener) EnterMethodDeclaration(ctx *parser.MethodDeclarationContext) {
	indentationMethod.Increment()
	methodName := ctx.IDENTIFIER().GetText()

	method := NewMethod(methodName, []Arg{}, []string{})

	var className string
	parent := ctx.GetParent()
	for parent != nil {
		if classCtx, ok := parent.(*parser.ClassDeclarationContext); ok {
			className = classCtx.IDENTIFIER().GetText()
			break
		}
		parent = parent.GetParent()
	}

	if className == "" {
		t.methodBuilder.WriteString(fmt.Sprintf("func %s(", methodName))
	} else {
		isStatic := ctx.STATIC() != nil

		if methodName == "Constructor" || isStatic {
			t.methodBuilder.WriteString(fmt.Sprintf("func (%s) %s(", className, methodName))
		} else {
			t.methodBuilder.WriteString(fmt.Sprintf("func (this *%s) %s(", className, methodName))
		}
	}

	// Parâmetros do método
	params := []string{}
	if ctx.ParameterList() != nil {
		for _, paramCtx := range ctx.ParameterList().AllParameter() {
			paramName := paramCtx.IDENTIFIER(0).GetText()

			if paramCtx.IDENTIFIER(1) != nil {
				paramType := paramCtx.IDENTIFIER(1).GetText()

				if paramCtx.STAR() != nil {
					paramType = "*" + paramType
				}

				params = append(params, fmt.Sprintf("%s %s", paramName, paramType))

				method.AddArg(paramName, paramType)
				continue
			}

			params = append(params, paramName)

			method.AddArg(paramName, ``)
		}
	}
	t.methodBuilder.WriteString(strings.Join(params, ", "))
	t.methodBuilder.WriteString(") ")

	// Tipo de retorno
	if ctx.ReturnType() != nil && methodName != "Constructor" {
		if ctx.ReturnType().ReturnTypeList() != nil {
			// Múltiplos tipos de retorno
			returnTypes := []string{}
			for _, paramCtx := range ctx.ReturnType().ReturnTypeList().AllReturnTypeSingle() {
				returnType := paramCtx.IDENTIFIER().GetText()
				if paramCtx.STAR() != nil {
					returnType = "*" + returnType
				}

				returnTypes = append(returnTypes, returnType)
				method.AddReturnType(returnType)
			}
			t.methodBuilder.WriteString(fmt.Sprintf("(%s) ", strings.Join(returnTypes, ", ")))
		} else if singleReturn := ctx.ReturnType().IDENTIFIER(); singleReturn != nil {
			returnType := singleReturn.GetText()

			if ctx.ReturnType().STAR() != nil {
				returnType = "*" + returnType
			}

			t.methodBuilder.WriteString(fmt.Sprintf("%s ", returnType))
			method.AddReturnType(returnType)
		}
	} else if methodName == "Constructor" {
		t.methodBuilder.WriteString(fmt.Sprintf("*%s ", className))
	}

	t.methodBuilder.WriteString("{\n") // Início do corpo do método

	if methodName == "Constructor" {
		t.AddStringToMethod("this := new(" + className + ")\n")
	}

	if CurrentClass != nil {
		CurrentClass.AddMethod(*method)
	}
}

// ExitMethodDeclaration is called when exiting the methodDeclaration production.
// It retrieves the method name and finalizes the method's Go code representation.
// For constructors, it appends a return statement returning the constructed instance.
func (t *TranspilerListener) ExitMethodDeclaration(ctx *parser.MethodDeclarationContext) {
	methodName := ctx.IDENTIFIER().GetText()
	if methodName == "Constructor" {
		t.AddStringToMethod("return this\n")
	}

	indentationMethod.Decrement()
	t.AddStringToMethod("\n")
	t.AddStringToMethod("}\n\n")
}

// EnterAssignment is called when entering the assignment production.
// It retrieves the variable name and expression from the context and
// writes a line of code to the method builder in the form of
// "this.<varName> = <expr>".
func (t *TranspilerListener) EnterAssignment(ctx *parser.AssignmentContext) {
	// Process the left-hand side (lhs) of the assignment
	var lhs string
	var operation string
	var expr string

	// Traverse the leftHandSide tree
	if ctx.LeftHandSide() != nil {
		lhs = ctx.LeftHandSide().GetText()
	} else {
		fmt.Println("No left-hand side found in the assignment.")
		return
	}

	if ctx.AssignmentOperator() != nil {
		operation = ctx.AssignmentOperator().GetText()
	} else {
		operation = "="
	}

	createObjDeclaration := ctx.Expression().CreateObjectDeclaration()

	if createObjDeclaration != nil {
		t.AddStringToMethod(fmt.Sprintf("%s %s ", lhs, operation))
	} else {
		expr = ctx.Expression().GetText()
		t.AddStringToMethod(fmt.Sprintf("%s %s %s\n", lhs, operation, expr))
	}
}

// EnterReturnOperation is called when entering the returnOperation production.
// It is responsible for generating the Go code for a return statement.
// If the return operation has an expression, it is included in the generated code.
// Otherwise, a simple "return" is generated.
func (t *TranspilerListener) EnterReturnOperation(ctx *parser.ReturnOperationContext) {
	if ctx.ArgumentList() != nil {
		args := []string{}
		for _, arg := range ctx.ArgumentList().AllExpression() {
			args = append(args, arg.GetText())
		}
		t.AddStringToMethod(fmt.Sprintf("return %s\n", strings.Join(args, ", ")))

		// expr := ctx.Expression().GetText()
		// t.methodBuilder.WriteString(fmt.Sprintf("return %s\n", expr))
	} else {
		t.AddStringToMethod("return\n")
	}
}

// EnterMethodCallExpression is called when entering the methodCall production.
// It retrieves the method name and the arguments from the context and
// writes a line of code to the method builder in the form of
// "<methodName>(<args>)".
func (t *TranspilerListener) EnterMethodCall(ctx *parser.MethodCallContext) {
	var methodName string

	// Verifica se o método é um IDENTIFIER simples
	if ctx.IDENTIFIER() != nil {
		methodName = ctx.IDENTIFIER().GetText()
	} else if ctx.LeftHandSide() != nil { // Caso contrário, trata como um leftHandSide
		methodName = ctx.LeftHandSide().GetText()
	} else {
		panic("methodCall: neither IDENTIFIER nor leftHandSide is present")
	}

	args := []string{}
	if ctx.ArgumentList() != nil {
		for _, arg := range ctx.ArgumentList().AllExpression() {
			args = append(args, arg.GetText())
		}
	}

	t.AddStringToMethod(fmt.Sprintf("%s(%s)\n", methodName, strings.Join(args, ", ")))
}

// EnterCreateObjectDeclaration is called when entering the createObjectDeclaration production.
// It retrieves the class name and the arguments from the context and writes a line of code to
// the method builder in the form of "<className>{}.Constructor(<args>)".
func (t *TranspilerListener) EnterCreateObjectDeclaration(ctx *parser.CreateObjectDeclarationContext) {
	className := ctx.IDENTIFIER().GetText()

	args := []string{}
	if ctx.ArgumentList() != nil {
		for _, arg := range ctx.ArgumentList().AllExpression() {
			args = append(args, arg.GetText())
		}
	}

	t.methodBuilder.WriteString(fmt.Sprintf("%s{}.Constructor(%s)", className, strings.Join(args, ", ")))
}

// EnterPackageDeclaration is called when entering the packageDeclaration production.
// It generates the Go code for the package declaration in the form of "package <packageName>".
func (t *TranspilerListener) EnterPackageDeclaration(ctx *parser.PackageDeclarationContext) {
	t.structBuilder.WriteString(fmt.Sprintf("package %s\n\n", ctx.IDENTIFIER().GetText()))
}

// EnterImportsDeclaration is called when entering the importsDeclaration production.
// It processes the list of import strings and generates the Go code for the import
// declaration in the form of "import (<list of import strings>)".
func (t *TranspilerListener) EnterImportsDeclaration(ctx *parser.ImportsDeclarationContext) {
	if len(ctx.AllSTRING()) == 0 {
		panic("No imports found")
		return
	}

	if len(ctx.AllSTRING()) == 1 {
		t.structBuilder.WriteString(fmt.Sprintf("import %s\n\n", ctx.STRING(0).GetText()))
		return
	}

	var importList []string
	for _, importCtx := range ctx.AllSTRING() {
		importList = append(importList, importCtx.GetText())
	}

	t.structBuilder.WriteString(fmt.Sprintf("import (\n    %s\n)\n\n", strings.Join(importList, "\n    ")))
}

// ExitCreateObjectDeclaration is called when exiting the createObjectDeclaration production.
// It adds a newline to the method builder to separate the create object declaration from
// any other code.
func (t *TranspilerListener) ExitCreateObjectDeclaration(ctx *parser.CreateObjectDeclarationContext) {
	t.AddStringToMethod("\n")
}

// EnterInterfaceDeclaration is called when entering the interfaceDeclaration production.
// It generates the Go code for an interface declaration by writing a line of code to the
// struct builder in the form of "type <interfaceName> interface {".
func (t *TranspilerListener) EnterInterfaceDeclaration(ctx *parser.InterfaceDeclarationContext) {
	interfaceName := ctx.IDENTIFIER().GetText()
	t.structBuilder.WriteString(fmt.Sprintf("type %s interface {\n", interfaceName))

	indentationStruct.Increment()

	CurrentInterface = &InterfaceInfo{
		Name: interfaceName,
	}
}

// ExitInterfaceDeclaration is called when exiting the interfaceDeclaration production.
// It finalizes the interface declaration by writing a closing brace and adding a newline.
func (t *TranspilerListener) ExitInterfaceDeclaration(ctx *parser.InterfaceDeclarationContext) {
	indentationStruct.Decrement()
	t.structBuilder.WriteString("}\n\n")

	InterfaceInfoMap[CurrentInterface.Name] = CurrentInterface

	CurrentInterface = nil

	// fmt.Printf(`%+v\n`, InterfaceInfoMap)
}

func (t *TranspilerListener) EnterInterfaceMethod(ctx *parser.InterfaceMethodContext) {
	if ctx == nil {
		fmt.Println("Erro: ctx é nil")
		return
	}

	methodName := ctx.IDENTIFIER().GetText()
	t.AddStringToStruct(fmt.Sprintf("%s(", methodName))

	method := &Method{Name: methodName}

	params := []string{}
	if ctx.ParameterList() != nil {
		for _, paramCtx := range ctx.ParameterList().AllParameter() {
			paramName := paramCtx.IDENTIFIER(0).GetText()

			paramType := ""
			if len(paramCtx.AllIDENTIFIER()) > 1 {
				paramType = paramCtx.IDENTIFIER(1).GetText()

				if paramCtx.STAR() != nil {
					paramType = "*" + paramType
				}
			}

			params = append(params, fmt.Sprintf("%s %s", paramName, paramType))
			method.AddArg(paramName, paramType)
		}
	}

	t.structBuilder.WriteString(strings.Join(params, ", "))
	t.structBuilder.WriteString(")")

	if ctx.ReturnType() != nil {
		if ctx.ReturnType().ReturnTypeList() != nil {
			returnTypes := []string{}
			for _, paramCtx := range ctx.ReturnType().ReturnTypeList().AllReturnTypeSingle() {
				returnType := paramCtx.IDENTIFIER().GetText()

				if paramCtx.STAR() != nil {
					returnType = "*" + returnType
				}

				returnTypes = append(returnTypes, returnType)
				method.AddReturnType(returnType)
			}
			t.structBuilder.WriteString(fmt.Sprintf("(%s) ", strings.Join(returnTypes, ", ")))

		} else if singleReturn := ctx.ReturnType().IDENTIFIER(); singleReturn != nil {
			returnType := singleReturn.GetText()

			if ctx.ReturnType().STAR() != nil {
				returnType = "*" + returnType
			}

			t.structBuilder.WriteString(fmt.Sprintf("%s ", returnType))
			method.AddReturnType(returnType)
		}
	}

	CurrentInterface.AddMethod(*method)
	// CurrentInterface.PrintInterfaceInfo()
}

func (t *TranspilerListener) ExitInterfaceMethod(ctx *parser.InterfaceMethodContext) {
	t.AddStringToStruct("\n")
}

func (t *TranspilerListener) EnterVarStatement(ctx *parser.VarStatementContext) {
	varName := ctx.IDENTIFIER(0).GetText()
	varType := ``

	if len(ctx.AllIDENTIFIER()) > 1 {
		varType = ctx.IDENTIFIER(1).GetText()

		if ctx.STAR() != nil {
			varType = "*" + varType
		}

		if ctx.Expression() != nil {
			t.AddStringToMethod(fmt.Sprintf("var %s %s = %s\n", varName, varType, ctx.Expression().GetText()))
			return
		}
	}

	if ctx.Expression() != nil {
		t.AddStringToMethod(fmt.Sprintf("var %s := %s\n", varName, ctx.Expression().GetText()))
		return
	}

	t.AddStringToMethod(fmt.Sprintf("var %s %s\n", varName, varType))

}

// EnterIfStatement is called when entering the ifStatement production.
//
// It generates the Go code for an if statement. If the if statement has an
// assignment, it is included in the generated code. Otherwise, the if statement
// must have an expression. If the expression is not present, a panic is triggered.
//
// The listener also increments the indentation level for the method to correctly
// indent the if statement's body.
func (t *TranspilerListener) EnterIfStatement(ctx *parser.IfStatementContext) {
	isElseIf := ctx.GetParent() != nil && reflect.TypeOf(ctx.GetParent()).String() == "*parser.ElseStatementContext"

	if isElseIf {
		t.methodBuilder.WriteString("if ")
	} else {
		t.AddStringToMethod("if ")
	}

	if ctx.Assignment() != nil {
		t.methodBuilder.WriteString(ctx.Assignment().GetText() + ";")
	}

	if ctx.Expression() != nil {
		t.methodBuilder.WriteString(ctx.Expression().GetText())
	} else {
		panic(fmt.Sprintf(`if must have expression`))
	}

	t.methodBuilder.WriteString(" {\n")

	indentationMethod.Increment()
}

// ExitIfStatement is called when exiting the ifStatement production.
//
// It decrements the indentation level to correctly indent any code following the
// if statement and adds a closing brace to the method builder.
func (t *TranspilerListener) ExitIfStatement(ctx *parser.IfStatementContext) {
	indentationMethod.Decrement()

	if ctx.ElseStatement() == nil {
		t.AddStringToMethod("}\n")
	}
}

// EnterElseStatement is called when entering the elseStatement production.
//
// It decrements the indentation level and appends "} else " to the method builder.
// If the else statement has an if statement, it decrements the indentation level.
// Otherwise, it appends "{\n" to the method builder and increments the indentation
// level.
func (t *TranspilerListener) EnterElseStatement(ctx *parser.ElseStatementContext) {
	indentationMethod.Decrement()

	t.AddStringToMethod("} else ")

	if ctx.IfStatement() != nil {
		indentationMethod.Decrement()
	} else {
		t.methodBuilder.WriteString("{\n")
	}

	indentationMethod.Increment()
}

// ExitElseStatement is called when exiting the elseStatement production.
// It decrements the indentation level to correctly indent any code following
// the else statement. If the else statement does not contain an if statement,
// it appends a closing brace to the method builder.
func (t *TranspilerListener) ExitElseStatement(ctx *parser.ElseStatementContext) {
	indentationMethod.Decrement()

	if ctx.IfStatement() == nil {
		t.AddStringToMethod("}\n")
	}
}

func (t *TranspilerListener) EnterEveryRule(ctx antlr.ParserRuleContext) {
	// Can be used for logic before entering any rule
}

func (t *TranspilerListener) ExitEveryRule(ctx antlr.ParserRuleContext) {
	// Can be used for logic after exiting any rule
}

func (t *TranspilerListener) VisitErrorNode(node antlr.ErrorNode) {
	// Logic to handle error nodes, if necessary
}

func (t *TranspilerListener) VisitTerminal(node antlr.TerminalNode) {
	// Logic for terminal nodes, if necessary
}

type GetTextInterface interface {
	GetText() string
}

func DebugContext(ctx interface{}) {
	fmt.Println("-----------------\n")
	fmt.Printf("%T\n\n\n", ctx)

	_, ok := interface{}(ctx).(GetTextInterface)

	if ok {
		fmt.Println(ctx.(GetTextInterface).GetText())
	}
}
