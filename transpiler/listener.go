package transpiler

import (
	"fmt"
	"strings"

	"gopp-parser/parser" // Replace with the path to the generated parser

	"reflect"
	"runtime"

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

func (t *TranspilerListener) AddStringToStruct(str string, indent ...bool) {
	// fmt.Println(str, "\n", GetCaller(), "\n", "-----------------\n")

	indentValue := true
	if len(indent) > 0 {
		indentValue = indent[0]
	}

	if indentValue {
		t.structBuilder.WriteString(indentationStruct.String() + str)

		return
	}

	t.structBuilder.WriteString(str)
}

func (t *TranspilerListener) AddStringToMethod(str string, indent ...bool) {
	fmt.Println(str, "\n", GetCaller(), "\n", "-----------------\n")

	indentValue := true
	if len(indent) > 0 {
		indentValue = indent[0]
	}

	if indentValue {
		t.methodBuilder.WriteString(indentationMethod.String() + str)
		return
	}

	t.methodBuilder.WriteString(str)
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
	fieldName := ctx.IDENTIFIER().GetText()
	fieldType := ctx.VarType().GetText()
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
		t.AddStringToMethod(fmt.Sprintf("func %s(", methodName), false)
	} else {
		isStatic := ctx.STATIC() != nil

		if methodName == "Constructor" || isStatic {
			t.AddStringToMethod(fmt.Sprintf("func (%s) %s(", className, methodName), false)
		} else {
			t.AddStringToMethod(fmt.Sprintf("func (this *%s) %s(", className, methodName), false)
		}
	}

	params := []string{}
	if ctx.ParameterList() != nil {
		for _, paramCtx := range ctx.ParameterList().AllParameter() {
			paramName := paramCtx.IDENTIFIER().GetText()
			paramType := paramCtx.VarType().GetText()

			params = append(params, fmt.Sprintf("%s %s", paramName, paramType))
			method.AddArg(paramName, paramType)
		}
	}
	t.AddStringToMethod(strings.Join(params, ", "), false)
	t.AddStringToMethod(") ", false)

	if ctx.ReturnType() != nil && methodName != "Constructor" {
		if ctx.ReturnType().ReturnTypeList() != nil {
			returnTypes := []string{}
			for _, paramCtx := range ctx.ReturnType().ReturnTypeList().AllReturnTypeSingle() {
				returnType := paramCtx.VarType().GetText()
				returnTypes = append(returnTypes, returnType)
				method.AddReturnType(returnType)
			}
			t.AddStringToMethod(fmt.Sprintf("(%s) ", strings.Join(returnTypes, ", ")), false)
		} else if singleReturn := ctx.ReturnType().VarType(); singleReturn != nil {
			returnType := singleReturn.GetText()
			t.AddStringToMethod(fmt.Sprintf("%s ", returnType), false)
			method.AddReturnType(returnType)
		}
	} else if methodName == "Constructor" {
		t.AddStringToMethod(fmt.Sprintf("*%s ", className), false)
	}

	t.AddStringToMethod("{\n", false)

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

	if _, isSimpleStatement := ctx.GetParent().(*parser.SimpleStatementContext); isSimpleStatement {
		ssParent := ctx.GetParent().GetParent().GetParent()
		if _, isFor := ssParent.(*parser.ForStatementContext); isFor {
			return
		}
	}

	switch true {
	case ctx.LeftHandSide() != nil:
		lhs = ctx.LeftHandSide().GetText()
	case ctx.ListAccess() != nil:
		lhs = ctx.ListAccess().GetText()
	default:
		fmt.Println("No left-hand side found in the assignment.")
		return
	}

	if ctx.AssignmentOperator() != nil {
		operation = ctx.AssignmentOperator().GetText()
	} else {
		operation = "="
	}

	createObjDeclaration := ctx.Expression().PrimaryExpression().CreateObjectDeclaration()

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

	if IsInside(ctx, "*parser.AssignmentContext") {
		return
	}

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

	t.AddStringToMethod(fmt.Sprintf("%s{}.Constructor(%s)", className, strings.Join(args, ", ")), false)
}

// EnterPackageDeclaration is called when entering the packageDeclaration production.
// It generates the Go code for the package declaration in the form of "package <packageName>".
func (t *TranspilerListener) EnterPackageDeclaration(ctx *parser.PackageDeclarationContext) {
	t.AddStringToStruct(fmt.Sprintf("package %s\n\n", ctx.IDENTIFIER().GetText()), false)
}

// EnterImportsDeclaration is called when entering the importsDeclaration production.
// It processes the list of import strings and generates the Go code for the import
// declaration in the form of "import (<list of import strings>)".
func (t *TranspilerListener) EnterImportsDeclaration(ctx *parser.ImportsDeclarationContext) {
	if len(ctx.AllSTRING()) == 0 {
		panic("No imports found")
	}

	if len(ctx.AllSTRING()) == 1 {
		t.AddStringToStruct(fmt.Sprintf("import %s\n\n", ctx.STRING(0).GetText()), false)
		return
	}

	var importList []string
	for _, importCtx := range ctx.AllSTRING() {
		importList = append(importList, importCtx.GetText())
	}

	t.AddStringToStruct(fmt.Sprintf("import (\n    %s\n)\n\n", strings.Join(importList, "\n    ")), false)
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
	t.AddStringToStruct(fmt.Sprintf("type %s interface {\n", interfaceName), false)

	indentationStruct.Increment()

	CurrentInterface = &InterfaceInfo{
		Name: interfaceName,
	}
}

// ExitInterfaceDeclaration is called when exiting the interfaceDeclaration production.
// It finalizes the interface declaration by writing a closing brace and adding a newline.
func (t *TranspilerListener) ExitInterfaceDeclaration(ctx *parser.InterfaceDeclarationContext) {
	indentationStruct.Decrement()
	t.AddStringToStruct("}\n\n", false)

	InterfaceInfoMap[CurrentInterface.Name] = CurrentInterface

	CurrentInterface = nil

	// fmt.Printf(`%+v\n`, InterfaceInfoMap)
}

// EnterInterfaceMethod is called when entering the interfaceMethod production.
// It generates the Go code for a single interface method by writing a line of code to the
// struct builder in the form of "<methodName>(<params>) (<returnTypes>)".
// It also keeps track of the methods in the interface by adding the method to the
// InterfaceInfo's Methods list.
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
			paramName := paramCtx.IDENTIFIER().GetText()
			paramType := paramCtx.VarType().GetText()

			params = append(params, fmt.Sprintf("%s %s", paramName, paramType))
			method.AddArg(paramName, paramType)
		}
	}

	t.AddStringToStruct(strings.Join(params, ", "), false)
	t.AddStringToStruct(")", false)

	if ctx.ReturnType() != nil {
		if ctx.ReturnType().ReturnTypeList() != nil {
			returnTypes := []string{}
			for _, paramCtx := range ctx.ReturnType().ReturnTypeList().AllReturnTypeSingle() {
				returnType := paramCtx.VarType().GetText()
				returnTypes = append(returnTypes, returnType)
				method.AddReturnType(returnType)
			}
			t.AddStringToStruct(fmt.Sprintf("(%s) ", strings.Join(returnTypes, ", ")), false)
		} else if singleReturn := ctx.ReturnType().VarType(); singleReturn != nil {
			returnType := singleReturn.GetText()
			t.AddStringToStruct(fmt.Sprintf("%s ", returnType), false)
			method.AddReturnType(returnType)
		}
	}

	CurrentInterface.AddMethod(*method)
}

func (t *TranspilerListener) ExitInterfaceMethod(ctx *parser.InterfaceMethodContext) {
	t.AddStringToStruct("\n")
}

// EnterVarStatement is called when entering the varStatement production.
// It generates the Go code for a single variable declaration by writing a line of code to the
// method builder in the form of "var <varName> <varType> = <expression>".
// If the variable statement does not have an expression, it is generated as "var <varName> <varType>".
// If the variable statement does not have a type, it is generated as "var <varName> := <expression>".
func (t *TranspilerListener) EnterVarStatement(ctx *parser.VarStatementContext) {
	varName := ctx.IDENTIFIER().GetText()
	varType := ""

	if ctx.VarType() != nil {
		varType = ctx.VarType().GetText()

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
		t.AddStringToMethod("if ", false)
	} else {
		t.AddStringToMethod("if ")
	}

	if ctx.Assignment() != nil {
		t.AddStringToMethod(ctx.Assignment().GetText()+";", false)
	}

	if ctx.Expression() != nil {
		t.AddStringToMethod(ctx.Expression().GetText(), false)
	} else {
		panic(fmt.Sprintf(`if must have expression`))
	}

	t.AddStringToMethod(" {\n", false)

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
		t.AddStringToMethod("{\n", false)
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

// EnterSliceDeclaration is called when entering the sliceDeclaration production.
// It generates the Go code for a slice declaration by writing a line of code
// to the method builder in the form of "var <sliceName> []<elementType>".
func (t *TranspilerListener) EnterSliceDeclaration(ctx *parser.SliceDeclarationContext) {
	slcType := ctx.IDENTIFIER().GetText()
	values := []string{}

	if IsInside(ctx, "*parser.AssignmentContext") {
		return
	}

	for _, expr := range ctx.AllPrimaryExpression() {
		values = append(values, expr.GetText())
	}

	t.AddStringToMethod(fmt.Sprintf("[]%s{%s}\n", slcType, strings.Join(values, ", ")), true)
}

// EnterForStatement is called when entering the forStatement production.
// It writes a line of code to the method builder in the form of "for"
// followed by the loop condition and increments the indentation level.
// It then writes a line of code to the method builder depending on the type
// of for loop encountered.
//
// The following cases are handled:
// - ClassicForLoop: writes the initialization statement, condition, and post-loop
// statement to the method builder.
// - RangeForLoop: writes the range keyword followed by the iterable expression
// to the method builder.
// - ConditionForLoop: writes the condition expression to the method builder.
// - InfiniteForLoop: writes a comment to the method builder indicating an infinite
// loop.
func (t *TranspilerListener) EnterForStatement(ctx *parser.ForStatementContext) {
	t.AddStringToMethod("for ")
	indentationMethod.Increment()

	switch true {
	case ctx.ClassicForLoop() != nil:
		if ctx.ClassicForLoop().SimpleStatement(0) != nil {
			t.AddStringToMethod(ctx.ClassicForLoop().SimpleStatement(0).GetText(), false)
		}
		t.AddStringToMethod("; ", false)

		if ctx.ClassicForLoop().Expression() != nil {
			t.AddStringToMethod(ctx.ClassicForLoop().Expression().GetText(), false)
		}
		t.AddStringToMethod("; ", false)

		if ctx.ClassicForLoop().SimpleStatement(1) != nil {
			t.AddStringToMethod(ctx.ClassicForLoop().SimpleStatement(1).GetText(), false)
		}

	case ctx.RangeForLoop() != nil:
		if ctx.RangeForLoop().ExpressionList() != nil {
			t.AddStringToMethod(ctx.RangeForLoop().ExpressionList().GetText()+" := ", false)
		}

		t.AddStringToMethod(" range ", false)
		if ctx.RangeForLoop().Expression() != nil {
			t.AddStringToMethod(ctx.RangeForLoop().Expression().GetText(), false)
		}

	case ctx.ConditionForLoop() != nil:
		if ctx.ConditionForLoop().Expression() != nil {
			t.AddStringToMethod(ctx.ConditionForLoop().Expression().GetText(), false)
		}

	case ctx.InfiniteForLoop() != nil:
		t.AddStringToMethod("/* Infinite for loop */", false)
	}

	t.AddStringToMethod(" {\n", false)
}

// ExitForStatement is called when exiting the forStatement production.
// It decrements the indentation level and appends a closing brace to the method builder.
func (t *TranspilerListener) ExitForStatement(ctx *parser.ForStatementContext) {
	indentationMethod.Decrement()

	t.AddStringToMethod("}\n")
}

// EnterForeachStatement is called when entering the foreachStatement production.
// It generates the Go code for a foreach statement by writing a line of code
// to the method builder in the form of "for <key>, <value> := range <collection> {".
// The listener also increments the indentation level for the method to correctly
// indent the foreach statement's body.
func (t *TranspilerListener) EnterForeachStatement(ctx *parser.ForeachStatementContext) {
	collection := ctx.Expression().GetText()
	keyOrValue := ctx.IDENTIFIER(0)
	valueOnly := ctx.IDENTIFIER(1)

	if valueOnly == nil {
		t.AddStringToMethod(fmt.Sprintf("for _, %s := range %s {\n", keyOrValue, collection))
	} else {
		t.AddStringToMethod(fmt.Sprintf("for %s, %s := range %s {\n", keyOrValue, valueOnly, collection))
	}

	indentationMethod.Increment()
}

// ExitForeachStatement is called when exiting the foreachStatement production.
// It decrements the indentation level and appends a closing brace to the method builder.
func (t *TranspilerListener) ExitForeachStatement(ctx *parser.ForeachStatementContext) {
	indentationMethod.Decrement()
	t.AddStringToMethod("}\n")
}

// EnterContinueOperation is called when entering the continueOperation production.
// It generates the Go code for a continue statement, optionally including a
// label if specified.
func (t *TranspilerListener) EnterContinueOperation(ctx *parser.ContinueOperationContext) {
	if ctx.IDENTIFIER() != nil {
		t.AddStringToMethod(fmt.Sprintf("continue %s\n", ctx.IDENTIFIER().GetText()))
		return
	}

	t.AddStringToMethod("continue\n")
}

// EnterBreakOperation is called when entering the breakOperation production.
// It generates the Go code for a break statement, optionally including a
// label if specified.
func (t *TranspilerListener) EnterBreakOperation(ctx *parser.BreakOperationContext) {
	if ctx.IDENTIFIER() != nil {
		t.AddStringToMethod(fmt.Sprintf("break %s\n", ctx.IDENTIFIER().GetText()))
		return
	}

	t.AddStringToMethod("break\n")
}

// EnterSwitchStatement is called when entering the switchStatement production.
// It generates the Go code for a switch statement by writing "switch"
// followed by the optional expression and an opening brace to the method builder.
func (t *TranspilerListener) EnterSwitchStatement(ctx *parser.SwitchStatementContext) {
	t.AddStringToMethod("switch ")
	if ctx.Expression() != nil {
		t.AddStringToMethod(ctx.Expression().GetText(), false)
	}
	t.AddStringToMethod(" {\n", false)

	indentationMethod.Increment()
}

// ExitSwitchStatement is called when exiting the switchStatement production.
// It appends a closing brace to the method builder to correctly close the switch block.
func (t *TranspilerListener) ExitSwitchStatement(ctx *parser.SwitchStatementContext) {
	indentationMethod.Decrement()
	t.AddStringToMethod("}\n")
}

func (t *TranspilerListener) EnterCaseBlock(ctx *parser.CaseBlockContext) {
	t.AddStringToMethod("case ")
	if ctx.ExpressionList() != nil {
		t.AddStringToMethod(ctx.ExpressionList().GetText(), false)
	}
	t.AddStringToMethod(":\n", false)
	indentationMethod.Increment()
}

func (t *TranspilerListener) EnterListAccess(ctx *parser.ListAccessContext) {
	if IsInside(ctx, "*parser.ArgumentListContext", "*parser.AssignmentContext", "*parser.VarStatementContext") {
		return
	}

	fmt.Printf("%s\n", ctx.GetText())

	t.AddStringToMethod(ctx.LeftHandSide().GetText()+"[", false)
}

func (t *TranspilerListener) ExitListAccess(ctx *parser.ListAccessContext) {
	if IsInside(ctx, "*parser.ArgumentListContext", "*parser.AssignmentContext", "*parser.VarStatementContext") {
		return
	}

	t.AddStringToMethod("]", false)
}

func (t *TranspilerListener) ExitCaseBlock(ctx *parser.CaseBlockContext) {
	indentationMethod.Decrement()
}

func (t *TranspilerListener) EnterDefaultBlock(ctx *parser.DefaultBlockContext) {
	t.AddStringToMethod("default:\n")
	indentationMethod.Increment()
}

func (t *TranspilerListener) ExitDefaultBlock(ctx *parser.DefaultBlockContext) {
	indentationMethod.Decrement()
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

	t := reflect.TypeOf(ctx)
	if t.Kind() == reflect.Ptr {
		t = t.Elem()
	}

	fmt.Println("\nMethods:\n")
	for i := 0; i < t.NumMethod(); i++ {
		method := t.Method(i)
		fmt.Printf("- %s (%v)\n", method.Name, method.Type)
	}

}

func IsInside(ctx any, external ...string) bool {
	for ctx != nil {
		ctxType := reflect.TypeOf(ctx).String()

		for _, ext := range external {
			if ctxType == ext {
				return true
			}
		}

		_, exists := reflect.TypeOf(ctx).MethodByName("GetParent")
		if !exists {
			return false
		}

		parent := reflect.ValueOf(ctx).MethodByName("GetParent").Call(nil)
		if len(parent) == 0 || parent[0].IsNil() {
			return false
		}

		ctx = parent[0].Interface()
	}

	return false
}

func GetCaller() string {
	pc, _, _, ok := runtime.Caller(2)
	if !ok {
		return "Desconhecido"
	}
	return runtime.FuncForPC(pc).Name()
}
