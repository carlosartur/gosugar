package transpiler

import (
    "fmt"
    "strings"
    "gosugar-parser/parser"
    "reflect"
    "runtime"
    "github.com/antlr4-go/antlr/v4"
)

type TranspilerListener struct {
    *parser.BaseGoSugarListener
    structBuilder strings.Builder
    methodBuilder strings.Builder
    ProcessedRulesList ProcessedRules
}

func (TranspilerListener) Constructor() *TranspilerListener {
    this := new(TranspilerListener)
    return this
}

type GetTextInterface interface {
    GetText()string     
}


var ClassInfoMap = make(map[string]*ClassInfo)
var CurrentClass *ClassInfo
var InterfaceInfoMap = make(map[string]*InterfaceInfo)
var CurrentInterface *InterfaceInfo
var indentationStruct Indentation = 0
var indentationMethod Indentation = 0
func (this *TranspilerListener) AddStringToStruct(str string, indent ...bool) {
    indentValue := true
    if len(indent)>0 {
        indentValue = indent[0]
    }
    if indentValue {
        this.structBuilder.WriteString(indentationStruct.String()+str)
        return
    }
    this.structBuilder.WriteString(str)

}

func (this *TranspilerListener) AddStringToMethod(str string, indent ...bool) {
    indentValue := true
    if len(indent)>0 {
        indentValue = indent[0]
    }
    if indentValue {
        this.methodBuilder.WriteString(indentationMethod.String()+str)
        return
    }
    this.methodBuilder.WriteString(str)

}

func (this *TranspilerListener) GoCode() string {
    return this.structBuilder.String()+"\n"+this.methodBuilder.String()

}

func (this *TranspilerListener) EnterClassDeclaration(ctx *parser.ClassDeclarationContext) {
    className := ctx.IDENTIFIER().GetText()
    aliasType := ctx.AliasType()
    if aliasType!=nil {
        this.AddStringToStruct(fmt.Sprintf("type %s %s\n",className,aliasType.GetText()))
        CurrentClass = ClassInfo{}.Constructor(className)        
        CurrentClass.SetAlias(aliasType.GetText())
    } else {
        this.AddStringToStruct(fmt.Sprintf("type %s struct {\n",className))
        CurrentClass = ClassInfo{}.Constructor(className)        
    }
    indentationStruct.Increment()
    if ctx.CompositionList()!=nil {
        if aliasType!=nil {
            panic(fmt.Sprintf("\nClass %s cannot have composition, because it is an alias of %s\n"+"To do it, remove the alias type, or remove the composition\n\n"+"    Current class declaration:\n"+"        class %s as %s use %s \n\n"+"    Fix option 1, removing type alias: \n"+"        class %s use %s \n\n"+"    Fix option 2, removing composition: \n"+"        class %s as %s \n",className,aliasType.GetText(),className,aliasType.GetText(),ctx.CompositionList().GetText(),className,ctx.CompositionList().GetText(),className,aliasType.GetText(),))
        }
        for _, compCtx := range ctx.CompositionList().AllLeftHandSide() {
            compName := compCtx.GetText()
            this.AddStringToStruct(fmt.Sprintf("%s\n",compName))
            if ClassInfoMap[compName]==nil {
                ClassInfoMap[compName] = &ClassInfo{Name:compName,}
            }
            CurrentClass.AddUse(*ClassInfoMap[compName])
        }
    }
    if ctx.MustInterfaceList()!=nil {
        for _, interfaceCtx := range ctx.MustInterfaceList().AllIDENTIFIER() {
            interfaceName := interfaceCtx.GetText()
            CurrentClass.AddMustInterfaceList(*InterfaceInfoMap[interfaceName])
        }
    }

}

func (this *TranspilerListener) ExitClassDeclaration(ctx *parser.ClassDeclarationContext) {
    indentationStruct.Decrement()
    if CurrentClass.Alias=="" {
        this.AddStringToStruct("}\n")
    }
    this.AddStringToStruct("\n")
    ClassInfoMap[CurrentClass.Name] = CurrentClass
    if !CurrentClass.HasConstructor()&&CurrentClass.Alias=="" {
        this.AddStringToStruct(fmt.Sprintf("func (%s) Constructor() *%s {\n"+"    this := new(%s)\n"+"    return this\n"+"}\n\n",CurrentClass.Name,CurrentClass.Name,CurrentClass.Name))
    }
    if !CurrentClass.ImplementsAllInterfaces() {
        panic(fmt.Sprintf("Class '%s' does not implement all interfaces on 'must' list\n",CurrentClass.Name))
    }
    CurrentClass = nil

}

func (this *TranspilerListener) EnterFieldDeclaration(ctx *parser.FieldDeclarationContext) {
    fieldName := ctx.IDENTIFIER().GetText()
    fieldType := ctx.VarType().GetText()
    this.AddStringToStruct(fmt.Sprintf("%s %s\n",fieldName,fieldType))
    CurrentClass.AddField(fieldName, fieldType)

}

func (this *TranspilerListener) EnterMethodDeclaration(ctx *parser.MethodDeclarationContext) {
    indentationMethod.Increment()
    methodName := ctx.IDENTIFIER().GetText()
    method := Method{}.Constructor(methodName, []Arg{}, []string{})    
    var className string
    parent := ctx.GetParent()
    for parent!=nil {
        if classCtx,ok:=parent.(*parser.ClassDeclarationContext);ok {
            className = classCtx.IDENTIFIER().GetText()
            break
        }
        parent = parent.GetParent()
    }
    if className=="" {
        this.AddStringToMethod(fmt.Sprintf("func %s(",methodName), false)
    } else {
        isStatic := ctx.STATIC()!=nil
        if methodName=="Constructor"||isStatic {
            this.AddStringToMethod(fmt.Sprintf("func (%s) %s(",className,methodName), false)
        } else {
            this.AddStringToMethod(fmt.Sprintf("func (this *%s) %s(",className,methodName), false)
        }
    }
    params := []string{}
    if ctx.ParameterList()!=nil {
        for _, paramCtx := range ctx.ParameterList().AllParameter() {
            paramName := paramCtx.IDENTIFIER().GetText()
            if paramCtx.VarType()==nil {
                panic(fmt.Sprintf(`param must have a type, got "%s" on line %d`,paramCtx.GetText(),paramCtx.GetStart().GetLine()))
            }
            paramType := paramCtx.VarType().GetText()
            if paramCtx.ELLIPSIS()!=nil {
                paramType = "..."+paramType
            }
            params = append(params,fmt.Sprintf("%s %s",paramName,paramType))
            method.AddArg(paramName, paramType)
        }
    }
    this.AddStringToMethod(strings.Join(params,", "), false)
    this.AddStringToMethod(") ", false)
    if ctx.ReturnType()!=nil&&methodName!="Constructor" {
        if ctx.ReturnType().ReturnTypeList()!=nil {
            returnTypes := []string{}
            for _, paramCtx := range ctx.ReturnType().ReturnTypeList().AllReturnTypeSingle() {
                returnType := paramCtx.VarType().GetText()
                returnTypes = append(returnTypes,returnType)
                method.AddReturnType(returnType)
            }
            this.AddStringToMethod(fmt.Sprintf("(%s) ",strings.Join(returnTypes,", ")), false)
        } else if singleReturn:=ctx.ReturnType().VarType();singleReturn!=nil {
            returnType := singleReturn.GetText()
            this.AddStringToMethod(fmt.Sprintf("%s ",returnType), false)
            method.AddReturnType(returnType)
        }
} else if methodName=="Constructor" {
        this.AddStringToMethod(fmt.Sprintf("*%s ",className), false)
    }
this.AddStringToMethod("{\n", false)
if methodName=="Constructor" {
    this.AddStringToMethod("this := new("+className+")\n")
}
if CurrentClass!=nil {
    CurrentClass.AddMethod(*method)
}

}

func (this *TranspilerListener) ExitMethodDeclaration(ctx *parser.MethodDeclarationContext) {
    methodName := ctx.IDENTIFIER().GetText()
    if methodName=="Constructor" {
        this.AddStringToMethod("return this\n")
    }
    indentationMethod.Decrement()
    this.AddStringToMethod("\n")
    this.AddStringToMethod("}\n\n")

}

func (this *TranspilerListener) EnterAssignment(ctx *parser.AssignmentContext) {
    var lhs string
    var expr string
    var lhsPieces []string
    operation := "="
    if this.ProcessedRulesList.IsDuplicate(ctx,"*parser.IfStatementContext") {
        return
    }
    if _,isSimpleStatement:=ctx.GetParent().(*parser.SimpleStatementContext);isSimpleStatement {
        ssParent := ctx.GetParent().GetParent().GetParent()
        if _,isFor:=ssParent.(*parser.ForStatementContext);isFor {
            return
        }
    }
    for _, alhs := range ctx.AllAssignmentLeftHandSide() {
        lhsPieces = append(lhsPieces,alhs.GetText())
    }
    lhs = strings.Join(lhsPieces,", ")
    if ctx.AssignmentOperator()!=nil {
        operation = ctx.AssignmentOperator().GetText()
    }
    primaryExpression := ctx.Expression().PrimaryExpression()
    showOnlyLhsAndOperation := primaryExpression.CreateObjectDeclaration()!=nil||primaryExpression.AnonimousFunctionDeclaration()!=nil
    if showOnlyLhsAndOperation {
        this.AddStringToMethod(fmt.Sprintf("%s %s ",lhs,operation))
        return
    }
    expr = ctx.Expression().GetText()
    this.AddStringToMethod(fmt.Sprintf("%s %s %s\n",lhs,operation,expr))

}

func (this *TranspilerListener) EnterReturnOperation(ctx *parser.ReturnOperationContext) {
    if ctx.ArgumentList()!=nil {
        args := []string{}
        for _, arg := range ctx.ArgumentList().AllExpression() {
            args = append(args,arg.GetText())
        }
        this.AddStringToMethod(fmt.Sprintf("return %s\n",strings.Join(args,", ")))
        return
    }
    this.AddStringToMethod("return\n")

}

func (this *TranspilerListener) EnterMethodCall(ctx *parser.MethodCallContext) {
    var methodName string
    if IsInside(ctx,"*parser.AssignmentContext","*parser.ReturnOperationContext","*parser.VarStatementContext")&&!IsInside(ctx,"*parser.AnonimousFunctionDeclarationContext") {
        return
    }
    if IsInside(ctx,"*parser.IfStatementContext")&&!IsInside(ctx,"*parser.AnonimousFunctionDeclarationContext")&&!IsInside(ctx,"*parser.BlockContext") {
        return
    }
    if IsInside(ctx.GetParent(),"*parser.MethodCallContext") {
        return
    }
    isDuplicated := this.ProcessedRulesList.IsDuplicate(ctx,"*parser.AssignmentContext","*parser.ReturnOperationContext","*parser.VarStatementContext","*parser.AnonimousFunctionDeclarationContext","*parser.IfStatementContext","*parser.ArgumentListContext","*parser.ClassicForLoopContext","*parser.RangeForLoopContext","*parser.ConditionForLoopContext","*parser.ForeachStatementContext","*parser.SwitchStatementContext")
    if isDuplicated {
        return
    }
    if ctx.IDENTIFIER()!=nil {
        methodName = ctx.IDENTIFIER().GetText()
    } else if ctx.LeftHandSide()!=nil {
        methodName = ctx.LeftHandSide().GetText()
    } else {
        fmt.Println("methodCall: neither IDENTIFIER nor leftHandSide is present\n\n")
    }
args := []string{}
if ctx.ArgumentList()!=nil {
    for _, arg := range ctx.ArgumentList().AllExpression() {
        args = append(args,arg.GetText())
    }
}
this.AddStringToMethod(fmt.Sprintf("%s(%s)\n",methodName,strings.Join(args,", ")))

}

func (this *TranspilerListener) EnterCreateObjectDeclaration(ctx *parser.CreateObjectDeclarationContext) {
    className := ctx.IDENTIFIER().GetText()
    args := []string{}
    if ctx.ArgumentList()!=nil {
        for _, arg := range ctx.ArgumentList().AllExpression() {
            args = append(args,arg.GetText())
        }
    }
    calledClass := ClassInfoMap[className]
    if calledClass!=nil&&calledClass.Alias!="" {
        this.AddStringToMethod(fmt.Sprintf("%s(%s)",className,strings.Join(args,", ")), false)
        return
    }
    this.AddStringToMethod(fmt.Sprintf("%s{}.Constructor(%s)",className,strings.Join(args,", ")), false)

}

func (this *TranspilerListener) EnterPackageDeclaration(ctx *parser.PackageDeclarationContext) {
    this.AddStringToStruct(fmt.Sprintf("package %s\n\n",ctx.IDENTIFIER().GetText()), false)

}

func (this *TranspilerListener) EnterImportsDeclaration(ctx *parser.ImportsDeclarationContext) {
    if len(ctx.AllSTRING())==0 {
        panic("No imports found")
    }
    if len(ctx.AllSTRING())==1 {
        this.AddStringToStruct(fmt.Sprintf("import %s\n\n",ctx.STRING(0).GetText()), false)
        return
    }
    var importList []string
    for _, importCtx := range ctx.AllSTRING() {
        importList = append(importList,importCtx.GetText())
    }
    this.AddStringToStruct(fmt.Sprintf("import (\n    %s\n)\n\n",strings.Join(importList,"\n    ")), false)

}

func (this *TranspilerListener) ExitCreateObjectDeclaration(ctx *parser.CreateObjectDeclarationContext) {
    this.AddStringToMethod("\n")

}

func (this *TranspilerListener) EnterInterfaceDeclaration(ctx *parser.InterfaceDeclarationContext) {
    interfaceName := ctx.IDENTIFIER().GetText()
    this.AddStringToStruct(fmt.Sprintf("type %s interface {\n",interfaceName), false)
    indentationStruct.Increment()
    CurrentInterface = &InterfaceInfo{Name:interfaceName,}

}

func (this *TranspilerListener) ExitInterfaceDeclaration(ctx *parser.InterfaceDeclarationContext) {
    indentationStruct.Decrement()
    this.AddStringToStruct("}\n\n", false)
    InterfaceInfoMap[CurrentInterface.Name] = CurrentInterface
    CurrentInterface = nil

}

func (this *TranspilerListener) EnterInterfaceMethod(ctx *parser.InterfaceMethodContext) {
    if ctx==nil {
        fmt.Println("Erro: ctx é nil")
        return
    }
    methodName := ctx.IDENTIFIER().GetText()
    this.AddStringToStruct(fmt.Sprintf("%s(",methodName))
    method := Method{}.Constructor(methodName, []Arg{}, []string{})    
    params := []string{}
    if ctx.ParameterList()!=nil {
        for _, paramCtx := range ctx.ParameterList().AllParameter() {
            paramName := paramCtx.IDENTIFIER().GetText()
            paramType := paramCtx.VarType().GetText()
            params = append(params,fmt.Sprintf("%s %s",paramName,paramType))
            method.AddArg(paramName, paramType)
        }
    }
    this.AddStringToStruct(strings.Join(params,", "), false)
    this.AddStringToStruct(")", false)
    if ctx.ReturnType()!=nil {
        if ctx.ReturnType().ReturnTypeList()!=nil {
            returnTypes := []string{}
            for _, paramCtx := range ctx.ReturnType().ReturnTypeList().AllReturnTypeSingle() {
                returnType := paramCtx.VarType().GetText()
                returnTypes = append(returnTypes,returnType)
                method.AddReturnType(returnType)
            }
            this.AddStringToStruct(fmt.Sprintf("(%s) ",strings.Join(returnTypes,", ")), false)
        } else if singleReturn:=ctx.ReturnType().VarType();singleReturn!=nil {
            returnType := singleReturn.GetText()
            this.AddStringToStruct(fmt.Sprintf("%s ",returnType), false)
            method.AddReturnType(returnType)
        }
}
CurrentInterface.AddMethod(*method)

}

func (this *TranspilerListener) ExitInterfaceMethod(ctx *parser.InterfaceMethodContext) {
    this.AddStringToStruct("\n")

}

func (this *TranspilerListener) EnterVarStatement(ctx *parser.VarStatementContext) {
    varName := ctx.IDENTIFIER().GetText()
    assignmentOperator := `=`
    if ctx.AssignmentOperator()!=nil {
        assignmentOperator = ctx.AssignmentOperator().GetText()
    }
    if ctx.VarType()!=nil {
        varName = fmt.Sprintf("%s %s",varName,ctx.VarType().GetText())
    }
    if ctx.VarValue()!=nil {
        varValue := ctx.VarValue().GetText()
        this.AddStringToMethod(fmt.Sprintf("var %s %s %s\n",varName,assignmentOperator,varValue))
        return
    }
    this.AddStringToMethod(fmt.Sprintf("var %s\n",varName))

}

func (this *TranspilerListener) EnterIfStatement(ctx *parser.IfStatementContext) {
    isElseIf := ctx.GetParent()!=nil&&reflect.TypeOf(ctx.GetParent()).String()=="*parser.ElseStatementContext"
    if isElseIf {
        this.AddStringToMethod("if ", false)
    } else {
        this.AddStringToMethod("if ")
    }
    if ctx.Assignment()!=nil {
        this.AddStringToMethod(ctx.Assignment().GetText()+";", false)
    }
    if ctx.Comparison()!=nil {
        this.AddStringToMethod(ctx.Comparison().GetText(), false)
    } else {
        panic(fmt.Sprintf(`if must have an condition, got "%s"`,ctx.GetText()))
    }
    this.AddStringToMethod(" {\n", false)
    indentationMethod.Increment()

}

func (this *TranspilerListener) ExitIfStatement(ctx *parser.IfStatementContext) {
    indentationMethod.Decrement()
    if ctx.ElseStatement()==nil {
        this.AddStringToMethod("}\n")
    }

}

func (this *TranspilerListener) EnterElseStatement(ctx *parser.ElseStatementContext) {
    indentationMethod.Decrement()
    this.AddStringToMethod("} else ")
    if ctx.IfStatement()!=nil {
        indentationMethod.Decrement()
    } else {
        this.AddStringToMethod("{\n", false)
    }
    indentationMethod.Increment()

}

func (this *TranspilerListener) ExitElseStatement(ctx *parser.ElseStatementContext) {
    indentationMethod.Decrement()
    if ctx.IfStatement()==nil {
        this.AddStringToMethod("}\n")
    }
    if ctx.IfStatement()==nil {
        indentationMethod.Increment()
    }

}

func (this *TranspilerListener) EnterSliceDeclaration(ctx *parser.SliceDeclarationContext) {
    slcType := ctx.IDENTIFIER().GetText()
    values := []string{}
    if IsInside(ctx,"*parser.AssignmentContext","*parser.AnonimousFunctionDeclarationContext","*parser.ForeachStatementContext") {
        return
    }
    for _, expr := range ctx.AllPrimaryExpression() {
        values = append(values,expr.GetText())
    }
    this.AddStringToMethod(fmt.Sprintf("[]%s{%s}\n",slcType,strings.Join(values,", ")), true)

}

func (this *TranspilerListener) EnterForStatement(ctx *parser.ForStatementContext) {
    this.AddStringToMethod("for ")
    indentationMethod.Increment()
    switch true {
        case ctx.ClassicForLoop()!=nil:
            ctx.ClassicForLoop()
            if ctx.ClassicForLoop().SimpleStatement(0)!=nil {
                this.AddStringToMethod(ctx.ClassicForLoop().SimpleStatement(0).GetText(), false)
            }
            this.AddStringToMethod("; ", false)
            if ctx.ClassicForLoop().Expression()!=nil {
                this.AddStringToMethod(ctx.ClassicForLoop().Expression().GetText(), false)
            }
            this.AddStringToMethod("; ", false)
            if ctx.ClassicForLoop().SimpleStatement(1)!=nil {
                this.AddStringToMethod(ctx.ClassicForLoop().SimpleStatement(1).GetText(), false)
            }
        case ctx.RangeForLoop()!=nil:
            ctx.RangeForLoop()
            if ctx.RangeForLoop().ExpressionList()!=nil {
                this.AddStringToMethod(ctx.RangeForLoop().ExpressionList().GetText()+" := ", false)
            }
            this.AddStringToMethod(" range ", false)
            if ctx.RangeForLoop().Expression()!=nil {
                this.AddStringToMethod(ctx.RangeForLoop().Expression().GetText(), false)
            }
        case ctx.ConditionForLoop()!=nil:
            ctx.ConditionForLoop()
            if ctx.ConditionForLoop().Expression()!=nil {
                this.AddStringToMethod(ctx.ConditionForLoop().Expression().GetText(), false)
            }
        case ctx.InfiniteForLoop()!=nil:
            ctx.InfiniteForLoop()
            this.AddStringToMethod("/* Infinite for loop */", false)
    }
    this.AddStringToMethod(" {\n", false)

}

func (this *TranspilerListener) ExitForStatement(ctx *parser.ForStatementContext) {
    indentationMethod.Decrement()
    this.AddStringToMethod("}\n")

}

func (this *TranspilerListener) EnterForeachStatement(ctx *parser.ForeachStatementContext) {
    collection := ctx.Expression().GetText()
    keyOrValue := ctx.IDENTIFIER(0)
    valueOnly := ctx.IDENTIFIER(1)
    if valueOnly==nil {
        this.AddStringToMethod(fmt.Sprintf("for _, %s := range %s {\n",keyOrValue,collection))
    } else {
        this.AddStringToMethod(fmt.Sprintf("for %s, %s := range %s {\n",keyOrValue,valueOnly,collection))
    }
    indentationMethod.Increment()

}

func (this *TranspilerListener) ExitForeachStatement(ctx *parser.ForeachStatementContext) {
    indentationMethod.Decrement()
    this.AddStringToMethod("}\n")

}

func (this *TranspilerListener) EnterContinueOperation(ctx *parser.ContinueOperationContext) {
    if ctx.IDENTIFIER()!=nil {
        this.AddStringToMethod(fmt.Sprintf("continue %s\n",ctx.IDENTIFIER().GetText()))
        return
    }
    this.AddStringToMethod("continue\n")

}

func (this *TranspilerListener) EnterBreakOperation(ctx *parser.BreakOperationContext) {
    if ctx.IDENTIFIER()!=nil {
        this.AddStringToMethod(fmt.Sprintf("break %s\n",ctx.IDENTIFIER().GetText()))
        return
    }
    this.AddStringToMethod("break\n")

}

func (this *TranspilerListener) EnterSwitchStatement(ctx *parser.SwitchStatementContext) {
    this.AddStringToMethod("switch ")
    if ctx.Expression()!=nil {
        this.AddStringToMethod(ctx.Expression().GetText(), false)
    }
    this.AddStringToMethod(" {\n", false)
    indentationMethod.Increment()

}

func (this *TranspilerListener) ExitSwitchStatement(ctx *parser.SwitchStatementContext) {
    indentationMethod.Decrement()
    this.AddStringToMethod("}\n")

}

func (this *TranspilerListener) EnterCaseBlock(ctx *parser.CaseBlockContext) {
    this.AddStringToMethod("case ")
    if ctx.ExpressionList()!=nil {
        this.AddStringToMethod(ctx.ExpressionList().GetText(), false)
    }
    this.AddStringToMethod(":\n", false)
    indentationMethod.Increment()

}

func (this *TranspilerListener) EnterListAccess(ctx *parser.ListAccessContext) {
    if IsInside(ctx,"*parser.ArgumentListContext","*parser.AssignmentContext","*parser.VarStatementContext") {
        return
    }
    fmt.Printf("%s\n", ctx.GetText())
    this.AddStringToMethod(ctx.LeftHandSide().GetText()+"[", false)

}

func (this *TranspilerListener) ExitListAccess(ctx *parser.ListAccessContext) {
    if IsInside(ctx,"*parser.ArgumentListContext","*parser.AssignmentContext","*parser.VarStatementContext") {
        return
    }
    this.AddStringToMethod("]", false)

}

func (this *TranspilerListener) ExitCaseBlock(ctx *parser.CaseBlockContext) {
    indentationMethod.Decrement()

}

func (this *TranspilerListener) EnterDefaultBlock(ctx *parser.DefaultBlockContext) {
    this.AddStringToMethod("default:\n")
    indentationMethod.Increment()

}

func (this *TranspilerListener) ExitDefaultBlock(ctx *parser.DefaultBlockContext) {
    indentationMethod.Decrement()

}

func (this *TranspilerListener) EnterIncrementOrDecrementStatement(ctx *parser.IncrementOrDecrementStatementContext) {
    if IsInside(ctx,"*parser.AssignmentContext")&&!IsInside(ctx,"*parser.AnonimousFunctionDeclarationContext") {
        return
    }
    this.AddStringToMethod(ctx.GetText()+"\n")

}

func (this *TranspilerListener) ExitIncrementOrDecrementStatement(ctx *parser.IncrementOrDecrementStatementContext) {
    if IsInside(ctx,"*parser.AssignmentContext")&&!IsInside(ctx,"*parser.AnonimousFunctionDeclarationContext") {
        return
    }

}

func (this *TranspilerListener) EnterAnonimousFunctionDeclaration(ctx *parser.AnonimousFunctionDeclarationContext) {
    var params []string
    this.AddStringToMethod("func (", false)
    if ctx.ParameterList()!=nil {
        for _, paramCtx := range ctx.ParameterList().AllParameter() {
            paramName := paramCtx.IDENTIFIER().GetText()
            paramType := paramCtx.VarType().GetText()
            if paramCtx.ELLIPSIS()!=nil {
                paramType = "..."+paramType
            }
            params = append(params,fmt.Sprintf("%s %s",paramName,paramType))
        }
    }
    this.AddStringToMethod(strings.Join(params,", "), false)
    this.AddStringToMethod(") ", false)
    if ctx.ReturnType()!=nil {
        if ctx.ReturnType().ReturnTypeList()!=nil {
            returnTypes := []string{}
            for _, paramCtx := range ctx.ReturnType().ReturnTypeList().AllReturnTypeSingle() {
                returnType := paramCtx.VarType().GetText()
                returnTypes = append(returnTypes,returnType)
            }
            this.AddStringToMethod(fmt.Sprintf("(%s) ",strings.Join(returnTypes,", ")), false)
        } else if singleReturn:=ctx.ReturnType().VarType();singleReturn!=nil {
            returnType := singleReturn.GetText()
            this.AddStringToMethod(fmt.Sprintf("%s ",returnType), false)
        }
}
this.AddStringToMethod("{\n", false)
indentationMethod.Increment()

}

func (this *TranspilerListener) ExitAnonimousFunctionDeclaration(ctx *parser.AnonimousFunctionDeclarationContext) {
    indentationMethod.Decrement()
    this.AddStringToMethod("}\n")

}

func (this *TranspilerListener) EnterInterfaceTypeVerification(ctx *parser.InterfaceTypeVerificationContext) {
    isDuplicated := this.ProcessedRulesList.IsDuplicate(ctx,"*parser.AssignmentContext","*parser.ReturnOperationContext","*parser.VarStatementContext","*parser.AnonimousFunctionDeclarationContext","*parser.IfStatementContext","*parser.ArgumentListContext","*parser.ClassicForLoopContext","*parser.RangeForLoopContext","*parser.ConditionForLoopContext","*parser.ForeachStatementContext","*parser.SwitchStatementContext","*parser.MethodCallContext")
    if isDuplicated {
        return
    }
    this.AddStringToMethod(ctx.GetText(), false)

}

func (this *TranspilerListener) EnterEveryRule(ctx antlr.ParserRuleContext) {
    this.ProcessedRulesList.AddRule(ctx)

}

func (this *TranspilerListener) ExitEveryRule(ctx antlr.ParserRuleContext) {

}

func (this *TranspilerListener) VisitErrorNode(node antlr.ErrorNode) {

}

func (this *TranspilerListener) VisitTerminal(node antlr.TerminalNode) {

}

func DebugContext(ctx any) {
    fmt.Println("-----------------\n")
    fmt.Printf("%T\n\n\n", ctx)
    _,ok := interface{}(ctx).(GetTextInterface)
    if ok {
        fmt.Println(ctx.(GetTextInterface).GetText())
    }
    t := reflect.TypeOf(ctx)
    if t.Kind()==reflect.Ptr {
        t = t.Elem()
    }
    fmt.Println("\nMethods:\n")
    for i:=0; i<t.NumMethod(); i++ {
        i++
        method := t.Method(i)
        fmt.Printf("- %s (%v)\n", method.Name, method.Type)
    }

}

func IsInside(ctx any, external ...string) bool {
    for ctx!=nil {
        ctxType := reflect.TypeOf(ctx).String()
        for _, ext := range external {
            if ctxType==ext {
                return true
            }
        }
        _,exists := reflect.TypeOf(ctx).MethodByName("GetParent")
        if !exists {
            return false
        }
        parent := reflect.ValueOf(ctx).MethodByName("GetParent").Call(nil)
        if len(parent)==0||parent[0].IsNil() {
            return false
        }
        ctx = parent[0].Interface()
    }
    return false

}

func InsideCompare(ctx any, external1 string, external2 string) (int, int) {
    var levelInside = [2]int{-1,-1}
    for i, external := range []string{external1,external2} {
        level := 0
        currentCtx := ctx
        for currentCtx!=nil {
            ctxType := reflect.TypeOf(currentCtx).String()
            if ctxType==external {
                levelInside[i] = level
                break
            }
            _,exists := reflect.TypeOf(currentCtx).MethodByName("GetParent")
            if !exists {
                break
            }
            parent := reflect.ValueOf(currentCtx).MethodByName("GetParent").Call(nil)
            if len(parent)==0||parent[0].IsNil() {
                break
            }
            currentCtx = parent[0].Interface()
            level++
        }
    }
    return levelInside[0], levelInside[1]

}

func GetCaller() string {
    pc,_, _,ok := runtime.Caller(2)
    if !ok {
        return "Unknown"
    }
    return runtime.FuncForPC(pc).Name()

}

