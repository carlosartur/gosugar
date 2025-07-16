// Code generated from GoSugar.g4 by ANTLR 4.13.1. DO NOT EDIT.

package parser // GoSugar

import "github.com/antlr4-go/antlr/v4"

// BaseGoSugarListener is a complete listener for a parse tree produced by GoSugarParser.
type BaseGoSugarListener struct{}

var _ GoSugarListener = &BaseGoSugarListener{}

// VisitTerminal is called when a terminal node is visited.
func (s *BaseGoSugarListener) VisitTerminal(node antlr.TerminalNode) {}

// VisitErrorNode is called when an error node is visited.
func (s *BaseGoSugarListener) VisitErrorNode(node antlr.ErrorNode) {}

// EnterEveryRule is called when any rule is entered.
func (s *BaseGoSugarListener) EnterEveryRule(ctx antlr.ParserRuleContext) {}

// ExitEveryRule is called when any rule is exited.
func (s *BaseGoSugarListener) ExitEveryRule(ctx antlr.ParserRuleContext) {}

// EnterProgram is called when production program is entered.
func (s *BaseGoSugarListener) EnterProgram(ctx *ProgramContext) {}

// ExitProgram is called when production program is exited.
func (s *BaseGoSugarListener) ExitProgram(ctx *ProgramContext) {}

// EnterProgramDeclaration is called when production programDeclaration is entered.
func (s *BaseGoSugarListener) EnterProgramDeclaration(ctx *ProgramDeclarationContext) {}

// ExitProgramDeclaration is called when production programDeclaration is exited.
func (s *BaseGoSugarListener) ExitProgramDeclaration(ctx *ProgramDeclarationContext) {}

// EnterGlobalVarStatement is called when production globalVarStatement is entered.
func (s *BaseGoSugarListener) EnterGlobalVarStatement(ctx *GlobalVarStatementContext) {}

// ExitGlobalVarStatement is called when production globalVarStatement is exited.
func (s *BaseGoSugarListener) ExitGlobalVarStatement(ctx *GlobalVarStatementContext) {}

// EnterInterfaceDeclaration is called when production interfaceDeclaration is entered.
func (s *BaseGoSugarListener) EnterInterfaceDeclaration(ctx *InterfaceDeclarationContext) {}

// ExitInterfaceDeclaration is called when production interfaceDeclaration is exited.
func (s *BaseGoSugarListener) ExitInterfaceDeclaration(ctx *InterfaceDeclarationContext) {}

// EnterInterfaceBody is called when production interfaceBody is entered.
func (s *BaseGoSugarListener) EnterInterfaceBody(ctx *InterfaceBodyContext) {}

// ExitInterfaceBody is called when production interfaceBody is exited.
func (s *BaseGoSugarListener) ExitInterfaceBody(ctx *InterfaceBodyContext) {}

// EnterInterfaceMethod is called when production interfaceMethod is entered.
func (s *BaseGoSugarListener) EnterInterfaceMethod(ctx *InterfaceMethodContext) {}

// ExitInterfaceMethod is called when production interfaceMethod is exited.
func (s *BaseGoSugarListener) ExitInterfaceMethod(ctx *InterfaceMethodContext) {}

// EnterClassDeclaration is called when production classDeclaration is entered.
func (s *BaseGoSugarListener) EnterClassDeclaration(ctx *ClassDeclarationContext) {}

// ExitClassDeclaration is called when production classDeclaration is exited.
func (s *BaseGoSugarListener) ExitClassDeclaration(ctx *ClassDeclarationContext) {}

// EnterPackageDeclaration is called when production packageDeclaration is entered.
func (s *BaseGoSugarListener) EnterPackageDeclaration(ctx *PackageDeclarationContext) {}

// ExitPackageDeclaration is called when production packageDeclaration is exited.
func (s *BaseGoSugarListener) ExitPackageDeclaration(ctx *PackageDeclarationContext) {}

// EnterImportsDeclaration is called when production importsDeclaration is entered.
func (s *BaseGoSugarListener) EnterImportsDeclaration(ctx *ImportsDeclarationContext) {}

// ExitImportsDeclaration is called when production importsDeclaration is exited.
func (s *BaseGoSugarListener) ExitImportsDeclaration(ctx *ImportsDeclarationContext) {}

// EnterCreateObjectDeclaration is called when production createObjectDeclaration is entered.
func (s *BaseGoSugarListener) EnterCreateObjectDeclaration(ctx *CreateObjectDeclarationContext) {}

// ExitCreateObjectDeclaration is called when production createObjectDeclaration is exited.
func (s *BaseGoSugarListener) ExitCreateObjectDeclaration(ctx *CreateObjectDeclarationContext) {}

// EnterSliceDeclaration is called when production sliceDeclaration is entered.
func (s *BaseGoSugarListener) EnterSliceDeclaration(ctx *SliceDeclarationContext) {}

// ExitSliceDeclaration is called when production sliceDeclaration is exited.
func (s *BaseGoSugarListener) ExitSliceDeclaration(ctx *SliceDeclarationContext) {}

// EnterSliceOrArrayLiteral is called when production sliceOrArrayLiteral is entered.
func (s *BaseGoSugarListener) EnterSliceOrArrayLiteral(ctx *SliceOrArrayLiteralContext) {}

// ExitSliceOrArrayLiteral is called when production sliceOrArrayLiteral is exited.
func (s *BaseGoSugarListener) ExitSliceOrArrayLiteral(ctx *SliceOrArrayLiteralContext) {}

// EnterListAccess is called when production listAccess is entered.
func (s *BaseGoSugarListener) EnterListAccess(ctx *ListAccessContext) {}

// ExitListAccess is called when production listAccess is exited.
func (s *BaseGoSugarListener) ExitListAccess(ctx *ListAccessContext) {}

// EnterAliasType is called when production aliasType is entered.
func (s *BaseGoSugarListener) EnterAliasType(ctx *AliasTypeContext) {}

// ExitAliasType is called when production aliasType is exited.
func (s *BaseGoSugarListener) ExitAliasType(ctx *AliasTypeContext) {}

// EnterCompositionList is called when production compositionList is entered.
func (s *BaseGoSugarListener) EnterCompositionList(ctx *CompositionListContext) {}

// ExitCompositionList is called when production compositionList is exited.
func (s *BaseGoSugarListener) ExitCompositionList(ctx *CompositionListContext) {}

// EnterMustInterfaceList is called when production mustInterfaceList is entered.
func (s *BaseGoSugarListener) EnterMustInterfaceList(ctx *MustInterfaceListContext) {}

// ExitMustInterfaceList is called when production mustInterfaceList is exited.
func (s *BaseGoSugarListener) ExitMustInterfaceList(ctx *MustInterfaceListContext) {}

// EnterClassBody is called when production classBody is entered.
func (s *BaseGoSugarListener) EnterClassBody(ctx *ClassBodyContext) {}

// ExitClassBody is called when production classBody is exited.
func (s *BaseGoSugarListener) ExitClassBody(ctx *ClassBodyContext) {}

// EnterClassMember is called when production classMember is entered.
func (s *BaseGoSugarListener) EnterClassMember(ctx *ClassMemberContext) {}

// ExitClassMember is called when production classMember is exited.
func (s *BaseGoSugarListener) ExitClassMember(ctx *ClassMemberContext) {}

// EnterVarType is called when production varType is entered.
func (s *BaseGoSugarListener) EnterVarType(ctx *VarTypeContext) {}

// ExitVarType is called when production varType is exited.
func (s *BaseGoSugarListener) ExitVarType(ctx *VarTypeContext) {}

// EnterFieldDeclaration is called when production fieldDeclaration is entered.
func (s *BaseGoSugarListener) EnterFieldDeclaration(ctx *FieldDeclarationContext) {}

// ExitFieldDeclaration is called when production fieldDeclaration is exited.
func (s *BaseGoSugarListener) ExitFieldDeclaration(ctx *FieldDeclarationContext) {}

// EnterStructTag is called when production structTag is entered.
func (s *BaseGoSugarListener) EnterStructTag(ctx *StructTagContext) {}

// ExitStructTag is called when production structTag is exited.
func (s *BaseGoSugarListener) ExitStructTag(ctx *StructTagContext) {}

// EnterMethodDeclaration is called when production methodDeclaration is entered.
func (s *BaseGoSugarListener) EnterMethodDeclaration(ctx *MethodDeclarationContext) {}

// ExitMethodDeclaration is called when production methodDeclaration is exited.
func (s *BaseGoSugarListener) ExitMethodDeclaration(ctx *MethodDeclarationContext) {}

// EnterAnonimousFunctionDeclaration is called when production anonimousFunctionDeclaration is entered.
func (s *BaseGoSugarListener) EnterAnonimousFunctionDeclaration(ctx *AnonimousFunctionDeclarationContext) {
}

// ExitAnonimousFunctionDeclaration is called when production anonimousFunctionDeclaration is exited.
func (s *BaseGoSugarListener) ExitAnonimousFunctionDeclaration(ctx *AnonimousFunctionDeclarationContext) {
}

// EnterReturnType is called when production returnType is entered.
func (s *BaseGoSugarListener) EnterReturnType(ctx *ReturnTypeContext) {}

// ExitReturnType is called when production returnType is exited.
func (s *BaseGoSugarListener) ExitReturnType(ctx *ReturnTypeContext) {}

// EnterReturnTypeList is called when production returnTypeList is entered.
func (s *BaseGoSugarListener) EnterReturnTypeList(ctx *ReturnTypeListContext) {}

// ExitReturnTypeList is called when production returnTypeList is exited.
func (s *BaseGoSugarListener) ExitReturnTypeList(ctx *ReturnTypeListContext) {}

// EnterReturnTypeSingle is called when production returnTypeSingle is entered.
func (s *BaseGoSugarListener) EnterReturnTypeSingle(ctx *ReturnTypeSingleContext) {}

// ExitReturnTypeSingle is called when production returnTypeSingle is exited.
func (s *BaseGoSugarListener) ExitReturnTypeSingle(ctx *ReturnTypeSingleContext) {}

// EnterParameterList is called when production parameterList is entered.
func (s *BaseGoSugarListener) EnterParameterList(ctx *ParameterListContext) {}

// ExitParameterList is called when production parameterList is exited.
func (s *BaseGoSugarListener) ExitParameterList(ctx *ParameterListContext) {}

// EnterMethodBody is called when production methodBody is entered.
func (s *BaseGoSugarListener) EnterMethodBody(ctx *MethodBodyContext) {}

// ExitMethodBody is called when production methodBody is exited.
func (s *BaseGoSugarListener) ExitMethodBody(ctx *MethodBodyContext) {}

// EnterParameter is called when production parameter is entered.
func (s *BaseGoSugarListener) EnterParameter(ctx *ParameterContext) {}

// ExitParameter is called when production parameter is exited.
func (s *BaseGoSugarListener) ExitParameter(ctx *ParameterContext) {}

// EnterBlock is called when production block is entered.
func (s *BaseGoSugarListener) EnterBlock(ctx *BlockContext) {}

// ExitBlock is called when production block is exited.
func (s *BaseGoSugarListener) ExitBlock(ctx *BlockContext) {}

// EnterStatement is called when production statement is entered.
func (s *BaseGoSugarListener) EnterStatement(ctx *StatementContext) {}

// ExitStatement is called when production statement is exited.
func (s *BaseGoSugarListener) ExitStatement(ctx *StatementContext) {}

// EnterSwitchStatement is called when production switchStatement is entered.
func (s *BaseGoSugarListener) EnterSwitchStatement(ctx *SwitchStatementContext) {}

// ExitSwitchStatement is called when production switchStatement is exited.
func (s *BaseGoSugarListener) ExitSwitchStatement(ctx *SwitchStatementContext) {}

// EnterCaseBlock is called when production caseBlock is entered.
func (s *BaseGoSugarListener) EnterCaseBlock(ctx *CaseBlockContext) {}

// ExitCaseBlock is called when production caseBlock is exited.
func (s *BaseGoSugarListener) ExitCaseBlock(ctx *CaseBlockContext) {}

// EnterDefaultBlock is called when production defaultBlock is entered.
func (s *BaseGoSugarListener) EnterDefaultBlock(ctx *DefaultBlockContext) {}

// ExitDefaultBlock is called when production defaultBlock is exited.
func (s *BaseGoSugarListener) ExitDefaultBlock(ctx *DefaultBlockContext) {}

// EnterNegationExpression is called when production negationExpression is entered.
func (s *BaseGoSugarListener) EnterNegationExpression(ctx *NegationExpressionContext) {}

// ExitNegationExpression is called when production negationExpression is exited.
func (s *BaseGoSugarListener) ExitNegationExpression(ctx *NegationExpressionContext) {}

// EnterAssignment is called when production assignment is entered.
func (s *BaseGoSugarListener) EnterAssignment(ctx *AssignmentContext) {}

// ExitAssignment is called when production assignment is exited.
func (s *BaseGoSugarListener) ExitAssignment(ctx *AssignmentContext) {}

// EnterAssignmentLeftHandSide is called when production assignmentLeftHandSide is entered.
func (s *BaseGoSugarListener) EnterAssignmentLeftHandSide(ctx *AssignmentLeftHandSideContext) {}

// ExitAssignmentLeftHandSide is called when production assignmentLeftHandSide is exited.
func (s *BaseGoSugarListener) ExitAssignmentLeftHandSide(ctx *AssignmentLeftHandSideContext) {}

// EnterLeftHandSide is called when production leftHandSide is entered.
func (s *BaseGoSugarListener) EnterLeftHandSide(ctx *LeftHandSideContext) {}

// ExitLeftHandSide is called when production leftHandSide is exited.
func (s *BaseGoSugarListener) ExitLeftHandSide(ctx *LeftHandSideContext) {}

// EnterAssignmentOperator is called when production assignmentOperator is entered.
func (s *BaseGoSugarListener) EnterAssignmentOperator(ctx *AssignmentOperatorContext) {}

// ExitAssignmentOperator is called when production assignmentOperator is exited.
func (s *BaseGoSugarListener) ExitAssignmentOperator(ctx *AssignmentOperatorContext) {}

// EnterComparisonOperator is called when production comparisonOperator is entered.
func (s *BaseGoSugarListener) EnterComparisonOperator(ctx *ComparisonOperatorContext) {}

// ExitComparisonOperator is called when production comparisonOperator is exited.
func (s *BaseGoSugarListener) ExitComparisonOperator(ctx *ComparisonOperatorContext) {}

// EnterMethodCall is called when production methodCall is entered.
func (s *BaseGoSugarListener) EnterMethodCall(ctx *MethodCallContext) {}

// ExitMethodCall is called when production methodCall is exited.
func (s *BaseGoSugarListener) ExitMethodCall(ctx *MethodCallContext) {}

// EnterArgumentList is called when production argumentList is entered.
func (s *BaseGoSugarListener) EnterArgumentList(ctx *ArgumentListContext) {}

// ExitArgumentList is called when production argumentList is exited.
func (s *BaseGoSugarListener) ExitArgumentList(ctx *ArgumentListContext) {}

// EnterExpression is called when production expression is entered.
func (s *BaseGoSugarListener) EnterExpression(ctx *ExpressionContext) {}

// ExitExpression is called when production expression is exited.
func (s *BaseGoSugarListener) ExitExpression(ctx *ExpressionContext) {}

// EnterConcatenatedString is called when production concatenatedString is entered.
func (s *BaseGoSugarListener) EnterConcatenatedString(ctx *ConcatenatedStringContext) {}

// ExitConcatenatedString is called when production concatenatedString is exited.
func (s *BaseGoSugarListener) ExitConcatenatedString(ctx *ConcatenatedStringContext) {}

// EnterInterfaceTypeVerification is called when production interfaceTypeVerification is entered.
func (s *BaseGoSugarListener) EnterInterfaceTypeVerification(ctx *InterfaceTypeVerificationContext) {}

// ExitInterfaceTypeVerification is called when production interfaceTypeVerification is exited.
func (s *BaseGoSugarListener) ExitInterfaceTypeVerification(ctx *InterfaceTypeVerificationContext) {}

// EnterPrimaryExpression is called when production primaryExpression is entered.
func (s *BaseGoSugarListener) EnterPrimaryExpression(ctx *PrimaryExpressionContext) {}

// ExitPrimaryExpression is called when production primaryExpression is exited.
func (s *BaseGoSugarListener) ExitPrimaryExpression(ctx *PrimaryExpressionContext) {}

// EnterDirectCreateInstance is called when production directCreateInstance is entered.
func (s *BaseGoSugarListener) EnterDirectCreateInstance(ctx *DirectCreateInstanceContext) {}

// ExitDirectCreateInstance is called when production directCreateInstance is exited.
func (s *BaseGoSugarListener) ExitDirectCreateInstance(ctx *DirectCreateInstanceContext) {}

// EnterMapKeyValue is called when production mapKeyValue is entered.
func (s *BaseGoSugarListener) EnterMapKeyValue(ctx *MapKeyValueContext) {}

// ExitMapKeyValue is called when production mapKeyValue is exited.
func (s *BaseGoSugarListener) ExitMapKeyValue(ctx *MapKeyValueContext) {}

// EnterListLiteral is called when production listLiteral is entered.
func (s *BaseGoSugarListener) EnterListLiteral(ctx *ListLiteralContext) {}

// ExitListLiteral is called when production listLiteral is exited.
func (s *BaseGoSugarListener) ExitListLiteral(ctx *ListLiteralContext) {}

// EnterOperatorExpression is called when production operatorExpression is entered.
func (s *BaseGoSugarListener) EnterOperatorExpression(ctx *OperatorExpressionContext) {}

// ExitOperatorExpression is called when production operatorExpression is exited.
func (s *BaseGoSugarListener) ExitOperatorExpression(ctx *OperatorExpressionContext) {}

// EnterComparison is called when production comparison is entered.
func (s *BaseGoSugarListener) EnterComparison(ctx *ComparisonContext) {}

// ExitComparison is called when production comparison is exited.
func (s *BaseGoSugarListener) ExitComparison(ctx *ComparisonContext) {}

// EnterReturnOperation is called when production returnOperation is entered.
func (s *BaseGoSugarListener) EnterReturnOperation(ctx *ReturnOperationContext) {}

// ExitReturnOperation is called when production returnOperation is exited.
func (s *BaseGoSugarListener) ExitReturnOperation(ctx *ReturnOperationContext) {}

// EnterContinueOperation is called when production continueOperation is entered.
func (s *BaseGoSugarListener) EnterContinueOperation(ctx *ContinueOperationContext) {}

// ExitContinueOperation is called when production continueOperation is exited.
func (s *BaseGoSugarListener) ExitContinueOperation(ctx *ContinueOperationContext) {}

// EnterBreakOperation is called when production breakOperation is entered.
func (s *BaseGoSugarListener) EnterBreakOperation(ctx *BreakOperationContext) {}

// ExitBreakOperation is called when production breakOperation is exited.
func (s *BaseGoSugarListener) ExitBreakOperation(ctx *BreakOperationContext) {}

// EnterVarValue is called when production varValue is entered.
func (s *BaseGoSugarListener) EnterVarValue(ctx *VarValueContext) {}

// ExitVarValue is called when production varValue is exited.
func (s *BaseGoSugarListener) ExitVarValue(ctx *VarValueContext) {}

// EnterVarStatement is called when production varStatement is entered.
func (s *BaseGoSugarListener) EnterVarStatement(ctx *VarStatementContext) {}

// ExitVarStatement is called when production varStatement is exited.
func (s *BaseGoSugarListener) ExitVarStatement(ctx *VarStatementContext) {}

// EnterIfStatement is called when production ifStatement is entered.
func (s *BaseGoSugarListener) EnterIfStatement(ctx *IfStatementContext) {}

// ExitIfStatement is called when production ifStatement is exited.
func (s *BaseGoSugarListener) ExitIfStatement(ctx *IfStatementContext) {}

// EnterElseStatement is called when production elseStatement is entered.
func (s *BaseGoSugarListener) EnterElseStatement(ctx *ElseStatementContext) {}

// ExitElseStatement is called when production elseStatement is exited.
func (s *BaseGoSugarListener) ExitElseStatement(ctx *ElseStatementContext) {}

// EnterIncrementOrDecrementStatement is called when production incrementOrDecrementStatement is entered.
func (s *BaseGoSugarListener) EnterIncrementOrDecrementStatement(ctx *IncrementOrDecrementStatementContext) {
}

// ExitIncrementOrDecrementStatement is called when production incrementOrDecrementStatement is exited.
func (s *BaseGoSugarListener) ExitIncrementOrDecrementStatement(ctx *IncrementOrDecrementStatementContext) {
}

// EnterForStatement is called when production forStatement is entered.
func (s *BaseGoSugarListener) EnterForStatement(ctx *ForStatementContext) {}

// ExitForStatement is called when production forStatement is exited.
func (s *BaseGoSugarListener) ExitForStatement(ctx *ForStatementContext) {}

// EnterClassicForLoop is called when production classicForLoop is entered.
func (s *BaseGoSugarListener) EnterClassicForLoop(ctx *ClassicForLoopContext) {}

// ExitClassicForLoop is called when production classicForLoop is exited.
func (s *BaseGoSugarListener) ExitClassicForLoop(ctx *ClassicForLoopContext) {}

// EnterRangeForLoop is called when production rangeForLoop is entered.
func (s *BaseGoSugarListener) EnterRangeForLoop(ctx *RangeForLoopContext) {}

// ExitRangeForLoop is called when production rangeForLoop is exited.
func (s *BaseGoSugarListener) ExitRangeForLoop(ctx *RangeForLoopContext) {}

// EnterConditionForLoop is called when production conditionForLoop is entered.
func (s *BaseGoSugarListener) EnterConditionForLoop(ctx *ConditionForLoopContext) {}

// ExitConditionForLoop is called when production conditionForLoop is exited.
func (s *BaseGoSugarListener) ExitConditionForLoop(ctx *ConditionForLoopContext) {}

// EnterInfiniteForLoop is called when production infiniteForLoop is entered.
func (s *BaseGoSugarListener) EnterInfiniteForLoop(ctx *InfiniteForLoopContext) {}

// ExitInfiniteForLoop is called when production infiniteForLoop is exited.
func (s *BaseGoSugarListener) ExitInfiniteForLoop(ctx *InfiniteForLoopContext) {}

// EnterSimpleStatement is called when production simpleStatement is entered.
func (s *BaseGoSugarListener) EnterSimpleStatement(ctx *SimpleStatementContext) {}

// ExitSimpleStatement is called when production simpleStatement is exited.
func (s *BaseGoSugarListener) ExitSimpleStatement(ctx *SimpleStatementContext) {}

// EnterExpressionList is called when production expressionList is entered.
func (s *BaseGoSugarListener) EnterExpressionList(ctx *ExpressionListContext) {}

// ExitExpressionList is called when production expressionList is exited.
func (s *BaseGoSugarListener) ExitExpressionList(ctx *ExpressionListContext) {}

// EnterMapInitialization is called when production mapInitialization is entered.
func (s *BaseGoSugarListener) EnterMapInitialization(ctx *MapInitializationContext) {}

// ExitMapInitialization is called when production mapInitialization is exited.
func (s *BaseGoSugarListener) ExitMapInitialization(ctx *MapInitializationContext) {}

// EnterForeachStatement is called when production foreachStatement is entered.
func (s *BaseGoSugarListener) EnterForeachStatement(ctx *ForeachStatementContext) {}

// ExitForeachStatement is called when production foreachStatement is exited.
func (s *BaseGoSugarListener) ExitForeachStatement(ctx *ForeachStatementContext) {}

// EnterTypeConversion is called when production typeConversion is entered.
func (s *BaseGoSugarListener) EnterTypeConversion(ctx *TypeConversionContext) {}

// ExitTypeConversion is called when production typeConversion is exited.
func (s *BaseGoSugarListener) ExitTypeConversion(ctx *TypeConversionContext) {}
