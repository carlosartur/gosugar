package transpiler

import (
	"fmt"
	"strings"

	"github.com/antlr4-go/antlr/v4"
	"gopp-parser/parser" // Replace with the path to the generated parser
)

// TranspilerListener implements the custom listener
type TranspilerListener struct {
	*parser.BaseGoPlusListener // Inherits from the generated base listener
	structBuilder strings.Builder // For struct composition and attributes
	methodBuilder strings.Builder // For method declarations and bodies
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
	t.structBuilder.WriteString(fmt.Sprintf("type %s struct {\n", className))

	// Add compositions, if they exist
	if ctx.CompositionList() != nil {
		for _, compCtx := range ctx.CompositionList().AllIDENTIFIER() {
			compName := compCtx.GetText()
			t.structBuilder.WriteString(fmt.Sprintf("\t%s\n", compName))
		}
	}
}

// ExitClassDeclaration is called when exiting the classDeclaration production.
// It finalizes the struct declaration by closing the brace and adding a newline.
func (t *TranspilerListener) ExitClassDeclaration(ctx *parser.ClassDeclarationContext) {
	t.structBuilder.WriteString("}\n\n") // Finalizes the struct
}

// EnterFieldDeclaration is called when entering the fieldDeclaration production.
//
// This listener is responsible for generating the Go code for the field being
// declared. It retrieves the field name and type from the context and writes a
// line of code to the struct builder in the form of "fieldName fieldType".
func (t *TranspilerListener) EnterFieldDeclaration(ctx *parser.FieldDeclarationContext) {
	fieldName := ctx.IDENTIFIER(0).GetText()
	fieldType := ctx.IDENTIFIER(1).GetText()
	t.structBuilder.WriteString(fmt.Sprintf("\t%s %s\n", fieldName, fieldType))
}

// EnterMethodDeclaration is called when entering the methodDeclaration production.
//
// This listener is responsible for generating the Go code for the method
// being declared. This can be either a constructor or a regular method.
//
// For constructors, the listener will generate the Go code:
//
// func New<ClassName>(<params>) *<ClassName> {
//     this := new(<ClassName>)
// }
//
// For regular methods, the listener will generate the Go code:
//
// func (this *<ClassName>) <MethodName>(<params>) {
// }
//
// The listener is also responsible for finding the parent class of the method
// by traversing up the tree of contexts.
func (t *TranspilerListener) EnterMethodDeclaration(ctx *parser.MethodDeclarationContext) {
	methodName := ctx.IDENTIFIER().GetText()

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
		if methodName == "Constructor" {
			t.methodBuilder.WriteString(fmt.Sprintf("func (%s) Constructor(", className))
		} else {
			t.methodBuilder.WriteString(fmt.Sprintf("func (this *%s) %s(", className, methodName))
		}
	}

	// Parâmetros do método
	params := []string{}
	if ctx.ParameterList() != nil {
		for _, paramCtx := range ctx.ParameterList().AllParameter() {
			paramName := paramCtx.IDENTIFIER(0).GetText()
			paramType := paramCtx.IDENTIFIER(1).GetText()
			params = append(params, fmt.Sprintf("%s %s", paramName, paramType))
		}
	}
	t.methodBuilder.WriteString(strings.Join(params, ", "))
	t.methodBuilder.WriteString(") ")

	// Tipo de retorno
	if ctx.ReturnType() != nil && methodName != "Constructor" {
		if ctx.ReturnType().ParameterList() != nil {
			// Múltiplos tipos de retorno
			returnTypes := []string{}
			for _, paramCtx := range ctx.ReturnType().ParameterList().AllParameter() {
				returnType := paramCtx.IDENTIFIER(1).GetText()
				returnTypes = append(returnTypes, returnType)
			}
			t.methodBuilder.WriteString(fmt.Sprintf("(%s) ", strings.Join(returnTypes, ", ")))
		} else if singleReturn := ctx.ReturnType().IDENTIFIER(); singleReturn != nil {
			// Retorno único
			t.methodBuilder.WriteString(fmt.Sprintf("%s ", singleReturn.GetText()))
		}
	} else if methodName == "Constructor" {
		t.methodBuilder.WriteString(fmt.Sprintf("*%s ", className))
	}

	t.methodBuilder.WriteString("{\n") // Início do corpo do método

	if methodName == "Constructor" {
		t.methodBuilder.WriteString("\tthis := new(" + className + ")\n")
	}
}


// ExitMethodDeclaration is called when exiting the methodDeclaration production.
// It retrieves the method name and finalizes the method's Go code representation.
// For constructors, it appends a return statement returning the constructed instance.
func (t *TranspilerListener) ExitMethodDeclaration(ctx *parser.MethodDeclarationContext) {
	methodName := ctx.IDENTIFIER().GetText()
	if methodName == "Constructor" {
		t.methodBuilder.WriteString("\treturn this\n")
	}
	t.methodBuilder.WriteString("\n")
	t.methodBuilder.WriteString("}\n\n")
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
		t.methodBuilder.WriteString(fmt.Sprintf("\t%s %s ", lhs, operation))
	} else {
		expr = ctx.Expression().GetText()
		t.methodBuilder.WriteString(fmt.Sprintf("\t%s %s %s\n", lhs, operation, expr))
	}
}

// EnterReturnOperation is called when entering the returnOperation production.
// It is responsible for generating the Go code for a return statement.
// If the return operation has an expression, it is included in the generated code.
// Otherwise, a simple "return" is generated.
func (t *TranspilerListener) EnterReturnOperation(ctx *parser.ReturnOperationContext) {
	if ctx.Expression() != nil {
        expr := ctx.Expression().GetText()
        t.methodBuilder.WriteString(fmt.Sprintf("\treturn %s\n", expr))
    } else {
        t.methodBuilder.WriteString("\treturn\n")
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

    t.methodBuilder.WriteString(fmt.Sprintf("\t%s(%s)\n", methodName, strings.Join(args, ", ")))
}

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
