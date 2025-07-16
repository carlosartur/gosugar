// Code generated from GoSugar.g4 by ANTLR 4.13.1. DO NOT EDIT.

package parser // GoSugar

import "github.com/antlr4-go/antlr/v4"

// GoSugarListener is a complete listener for a parse tree produced by GoSugarParser.
type GoSugarListener interface {
	antlr.ParseTreeListener

	// EnterProgram is called when entering the program production.
	EnterProgram(c *ProgramContext)

	// EnterProgramDeclaration is called when entering the programDeclaration production.
	EnterProgramDeclaration(c *ProgramDeclarationContext)

	// EnterGlobalVarStatement is called when entering the globalVarStatement production.
	EnterGlobalVarStatement(c *GlobalVarStatementContext)

	// EnterInterfaceDeclaration is called when entering the interfaceDeclaration production.
	EnterInterfaceDeclaration(c *InterfaceDeclarationContext)

	// EnterInterfaceBody is called when entering the interfaceBody production.
	EnterInterfaceBody(c *InterfaceBodyContext)

	// EnterInterfaceMethod is called when entering the interfaceMethod production.
	EnterInterfaceMethod(c *InterfaceMethodContext)

	// EnterClassDeclaration is called when entering the classDeclaration production.
	EnterClassDeclaration(c *ClassDeclarationContext)

	// EnterPackageDeclaration is called when entering the packageDeclaration production.
	EnterPackageDeclaration(c *PackageDeclarationContext)

	// EnterImportsDeclaration is called when entering the importsDeclaration production.
	EnterImportsDeclaration(c *ImportsDeclarationContext)

	// EnterCreateObjectDeclaration is called when entering the createObjectDeclaration production.
	EnterCreateObjectDeclaration(c *CreateObjectDeclarationContext)

	// EnterSliceDeclaration is called when entering the sliceDeclaration production.
	EnterSliceDeclaration(c *SliceDeclarationContext)

	// EnterSliceOrArrayLiteral is called when entering the sliceOrArrayLiteral production.
	EnterSliceOrArrayLiteral(c *SliceOrArrayLiteralContext)

	// EnterListAccess is called when entering the listAccess production.
	EnterListAccess(c *ListAccessContext)

	// EnterAliasType is called when entering the aliasType production.
	EnterAliasType(c *AliasTypeContext)

	// EnterCompositionList is called when entering the compositionList production.
	EnterCompositionList(c *CompositionListContext)

	// EnterMustInterfaceList is called when entering the mustInterfaceList production.
	EnterMustInterfaceList(c *MustInterfaceListContext)

	// EnterClassBody is called when entering the classBody production.
	EnterClassBody(c *ClassBodyContext)

	// EnterClassMember is called when entering the classMember production.
	EnterClassMember(c *ClassMemberContext)

	// EnterVarType is called when entering the varType production.
	EnterVarType(c *VarTypeContext)

	// EnterFieldDeclaration is called when entering the fieldDeclaration production.
	EnterFieldDeclaration(c *FieldDeclarationContext)

	// EnterStructTag is called when entering the structTag production.
	EnterStructTag(c *StructTagContext)

	// EnterMethodDeclaration is called when entering the methodDeclaration production.
	EnterMethodDeclaration(c *MethodDeclarationContext)

	// EnterAnonimousFunctionDeclaration is called when entering the anonimousFunctionDeclaration production.
	EnterAnonimousFunctionDeclaration(c *AnonimousFunctionDeclarationContext)

	// EnterReturnType is called when entering the returnType production.
	EnterReturnType(c *ReturnTypeContext)

	// EnterReturnTypeList is called when entering the returnTypeList production.
	EnterReturnTypeList(c *ReturnTypeListContext)

	// EnterReturnTypeSingle is called when entering the returnTypeSingle production.
	EnterReturnTypeSingle(c *ReturnTypeSingleContext)

	// EnterParameterList is called when entering the parameterList production.
	EnterParameterList(c *ParameterListContext)

	// EnterMethodBody is called when entering the methodBody production.
	EnterMethodBody(c *MethodBodyContext)

	// EnterParameter is called when entering the parameter production.
	EnterParameter(c *ParameterContext)

	// EnterBlock is called when entering the block production.
	EnterBlock(c *BlockContext)

	// EnterStatement is called when entering the statement production.
	EnterStatement(c *StatementContext)

	// EnterSwitchStatement is called when entering the switchStatement production.
	EnterSwitchStatement(c *SwitchStatementContext)

	// EnterCaseBlock is called when entering the caseBlock production.
	EnterCaseBlock(c *CaseBlockContext)

	// EnterDefaultBlock is called when entering the defaultBlock production.
	EnterDefaultBlock(c *DefaultBlockContext)

	// EnterNegationExpression is called when entering the negationExpression production.
	EnterNegationExpression(c *NegationExpressionContext)

	// EnterAssignment is called when entering the assignment production.
	EnterAssignment(c *AssignmentContext)

	// EnterAssignmentLeftHandSide is called when entering the assignmentLeftHandSide production.
	EnterAssignmentLeftHandSide(c *AssignmentLeftHandSideContext)

	// EnterLeftHandSide is called when entering the leftHandSide production.
	EnterLeftHandSide(c *LeftHandSideContext)

	// EnterAssignmentOperator is called when entering the assignmentOperator production.
	EnterAssignmentOperator(c *AssignmentOperatorContext)

	// EnterComparisonOperator is called when entering the comparisonOperator production.
	EnterComparisonOperator(c *ComparisonOperatorContext)

	// EnterMethodCall is called when entering the methodCall production.
	EnterMethodCall(c *MethodCallContext)

	// EnterArgumentList is called when entering the argumentList production.
	EnterArgumentList(c *ArgumentListContext)

	// EnterExpression is called when entering the expression production.
	EnterExpression(c *ExpressionContext)

	// EnterConcatenatedString is called when entering the concatenatedString production.
	EnterConcatenatedString(c *ConcatenatedStringContext)

	// EnterInterfaceTypeVerification is called when entering the interfaceTypeVerification production.
	EnterInterfaceTypeVerification(c *InterfaceTypeVerificationContext)

	// EnterPrimaryExpression is called when entering the primaryExpression production.
	EnterPrimaryExpression(c *PrimaryExpressionContext)

	// EnterDirectCreateInstance is called when entering the directCreateInstance production.
	EnterDirectCreateInstance(c *DirectCreateInstanceContext)

	// EnterMapKeyValue is called when entering the mapKeyValue production.
	EnterMapKeyValue(c *MapKeyValueContext)

	// EnterListLiteral is called when entering the listLiteral production.
	EnterListLiteral(c *ListLiteralContext)

	// EnterOperatorExpression is called when entering the operatorExpression production.
	EnterOperatorExpression(c *OperatorExpressionContext)

	// EnterComparison is called when entering the comparison production.
	EnterComparison(c *ComparisonContext)

	// EnterReturnOperation is called when entering the returnOperation production.
	EnterReturnOperation(c *ReturnOperationContext)

	// EnterContinueOperation is called when entering the continueOperation production.
	EnterContinueOperation(c *ContinueOperationContext)

	// EnterBreakOperation is called when entering the breakOperation production.
	EnterBreakOperation(c *BreakOperationContext)

	// EnterVarValue is called when entering the varValue production.
	EnterVarValue(c *VarValueContext)

	// EnterVarStatement is called when entering the varStatement production.
	EnterVarStatement(c *VarStatementContext)

	// EnterIfStatement is called when entering the ifStatement production.
	EnterIfStatement(c *IfStatementContext)

	// EnterElseStatement is called when entering the elseStatement production.
	EnterElseStatement(c *ElseStatementContext)

	// EnterIncrementOrDecrementStatement is called when entering the incrementOrDecrementStatement production.
	EnterIncrementOrDecrementStatement(c *IncrementOrDecrementStatementContext)

	// EnterForStatement is called when entering the forStatement production.
	EnterForStatement(c *ForStatementContext)

	// EnterClassicForLoop is called when entering the classicForLoop production.
	EnterClassicForLoop(c *ClassicForLoopContext)

	// EnterRangeForLoop is called when entering the rangeForLoop production.
	EnterRangeForLoop(c *RangeForLoopContext)

	// EnterConditionForLoop is called when entering the conditionForLoop production.
	EnterConditionForLoop(c *ConditionForLoopContext)

	// EnterInfiniteForLoop is called when entering the infiniteForLoop production.
	EnterInfiniteForLoop(c *InfiniteForLoopContext)

	// EnterSimpleStatement is called when entering the simpleStatement production.
	EnterSimpleStatement(c *SimpleStatementContext)

	// EnterExpressionList is called when entering the expressionList production.
	EnterExpressionList(c *ExpressionListContext)

	// EnterMapInitialization is called when entering the mapInitialization production.
	EnterMapInitialization(c *MapInitializationContext)

	// EnterForeachStatement is called when entering the foreachStatement production.
	EnterForeachStatement(c *ForeachStatementContext)

	// EnterTypeConversion is called when entering the typeConversion production.
	EnterTypeConversion(c *TypeConversionContext)

	// ExitProgram is called when exiting the program production.
	ExitProgram(c *ProgramContext)

	// ExitProgramDeclaration is called when exiting the programDeclaration production.
	ExitProgramDeclaration(c *ProgramDeclarationContext)

	// ExitGlobalVarStatement is called when exiting the globalVarStatement production.
	ExitGlobalVarStatement(c *GlobalVarStatementContext)

	// ExitInterfaceDeclaration is called when exiting the interfaceDeclaration production.
	ExitInterfaceDeclaration(c *InterfaceDeclarationContext)

	// ExitInterfaceBody is called when exiting the interfaceBody production.
	ExitInterfaceBody(c *InterfaceBodyContext)

	// ExitInterfaceMethod is called when exiting the interfaceMethod production.
	ExitInterfaceMethod(c *InterfaceMethodContext)

	// ExitClassDeclaration is called when exiting the classDeclaration production.
	ExitClassDeclaration(c *ClassDeclarationContext)

	// ExitPackageDeclaration is called when exiting the packageDeclaration production.
	ExitPackageDeclaration(c *PackageDeclarationContext)

	// ExitImportsDeclaration is called when exiting the importsDeclaration production.
	ExitImportsDeclaration(c *ImportsDeclarationContext)

	// ExitCreateObjectDeclaration is called when exiting the createObjectDeclaration production.
	ExitCreateObjectDeclaration(c *CreateObjectDeclarationContext)

	// ExitSliceDeclaration is called when exiting the sliceDeclaration production.
	ExitSliceDeclaration(c *SliceDeclarationContext)

	// ExitSliceOrArrayLiteral is called when exiting the sliceOrArrayLiteral production.
	ExitSliceOrArrayLiteral(c *SliceOrArrayLiteralContext)

	// ExitListAccess is called when exiting the listAccess production.
	ExitListAccess(c *ListAccessContext)

	// ExitAliasType is called when exiting the aliasType production.
	ExitAliasType(c *AliasTypeContext)

	// ExitCompositionList is called when exiting the compositionList production.
	ExitCompositionList(c *CompositionListContext)

	// ExitMustInterfaceList is called when exiting the mustInterfaceList production.
	ExitMustInterfaceList(c *MustInterfaceListContext)

	// ExitClassBody is called when exiting the classBody production.
	ExitClassBody(c *ClassBodyContext)

	// ExitClassMember is called when exiting the classMember production.
	ExitClassMember(c *ClassMemberContext)

	// ExitVarType is called when exiting the varType production.
	ExitVarType(c *VarTypeContext)

	// ExitFieldDeclaration is called when exiting the fieldDeclaration production.
	ExitFieldDeclaration(c *FieldDeclarationContext)

	// ExitStructTag is called when exiting the structTag production.
	ExitStructTag(c *StructTagContext)

	// ExitMethodDeclaration is called when exiting the methodDeclaration production.
	ExitMethodDeclaration(c *MethodDeclarationContext)

	// ExitAnonimousFunctionDeclaration is called when exiting the anonimousFunctionDeclaration production.
	ExitAnonimousFunctionDeclaration(c *AnonimousFunctionDeclarationContext)

	// ExitReturnType is called when exiting the returnType production.
	ExitReturnType(c *ReturnTypeContext)

	// ExitReturnTypeList is called when exiting the returnTypeList production.
	ExitReturnTypeList(c *ReturnTypeListContext)

	// ExitReturnTypeSingle is called when exiting the returnTypeSingle production.
	ExitReturnTypeSingle(c *ReturnTypeSingleContext)

	// ExitParameterList is called when exiting the parameterList production.
	ExitParameterList(c *ParameterListContext)

	// ExitMethodBody is called when exiting the methodBody production.
	ExitMethodBody(c *MethodBodyContext)

	// ExitParameter is called when exiting the parameter production.
	ExitParameter(c *ParameterContext)

	// ExitBlock is called when exiting the block production.
	ExitBlock(c *BlockContext)

	// ExitStatement is called when exiting the statement production.
	ExitStatement(c *StatementContext)

	// ExitSwitchStatement is called when exiting the switchStatement production.
	ExitSwitchStatement(c *SwitchStatementContext)

	// ExitCaseBlock is called when exiting the caseBlock production.
	ExitCaseBlock(c *CaseBlockContext)

	// ExitDefaultBlock is called when exiting the defaultBlock production.
	ExitDefaultBlock(c *DefaultBlockContext)

	// ExitNegationExpression is called when exiting the negationExpression production.
	ExitNegationExpression(c *NegationExpressionContext)

	// ExitAssignment is called when exiting the assignment production.
	ExitAssignment(c *AssignmentContext)

	// ExitAssignmentLeftHandSide is called when exiting the assignmentLeftHandSide production.
	ExitAssignmentLeftHandSide(c *AssignmentLeftHandSideContext)

	// ExitLeftHandSide is called when exiting the leftHandSide production.
	ExitLeftHandSide(c *LeftHandSideContext)

	// ExitAssignmentOperator is called when exiting the assignmentOperator production.
	ExitAssignmentOperator(c *AssignmentOperatorContext)

	// ExitComparisonOperator is called when exiting the comparisonOperator production.
	ExitComparisonOperator(c *ComparisonOperatorContext)

	// ExitMethodCall is called when exiting the methodCall production.
	ExitMethodCall(c *MethodCallContext)

	// ExitArgumentList is called when exiting the argumentList production.
	ExitArgumentList(c *ArgumentListContext)

	// ExitExpression is called when exiting the expression production.
	ExitExpression(c *ExpressionContext)

	// ExitConcatenatedString is called when exiting the concatenatedString production.
	ExitConcatenatedString(c *ConcatenatedStringContext)

	// ExitInterfaceTypeVerification is called when exiting the interfaceTypeVerification production.
	ExitInterfaceTypeVerification(c *InterfaceTypeVerificationContext)

	// ExitPrimaryExpression is called when exiting the primaryExpression production.
	ExitPrimaryExpression(c *PrimaryExpressionContext)

	// ExitDirectCreateInstance is called when exiting the directCreateInstance production.
	ExitDirectCreateInstance(c *DirectCreateInstanceContext)

	// ExitMapKeyValue is called when exiting the mapKeyValue production.
	ExitMapKeyValue(c *MapKeyValueContext)

	// ExitListLiteral is called when exiting the listLiteral production.
	ExitListLiteral(c *ListLiteralContext)

	// ExitOperatorExpression is called when exiting the operatorExpression production.
	ExitOperatorExpression(c *OperatorExpressionContext)

	// ExitComparison is called when exiting the comparison production.
	ExitComparison(c *ComparisonContext)

	// ExitReturnOperation is called when exiting the returnOperation production.
	ExitReturnOperation(c *ReturnOperationContext)

	// ExitContinueOperation is called when exiting the continueOperation production.
	ExitContinueOperation(c *ContinueOperationContext)

	// ExitBreakOperation is called when exiting the breakOperation production.
	ExitBreakOperation(c *BreakOperationContext)

	// ExitVarValue is called when exiting the varValue production.
	ExitVarValue(c *VarValueContext)

	// ExitVarStatement is called when exiting the varStatement production.
	ExitVarStatement(c *VarStatementContext)

	// ExitIfStatement is called when exiting the ifStatement production.
	ExitIfStatement(c *IfStatementContext)

	// ExitElseStatement is called when exiting the elseStatement production.
	ExitElseStatement(c *ElseStatementContext)

	// ExitIncrementOrDecrementStatement is called when exiting the incrementOrDecrementStatement production.
	ExitIncrementOrDecrementStatement(c *IncrementOrDecrementStatementContext)

	// ExitForStatement is called when exiting the forStatement production.
	ExitForStatement(c *ForStatementContext)

	// ExitClassicForLoop is called when exiting the classicForLoop production.
	ExitClassicForLoop(c *ClassicForLoopContext)

	// ExitRangeForLoop is called when exiting the rangeForLoop production.
	ExitRangeForLoop(c *RangeForLoopContext)

	// ExitConditionForLoop is called when exiting the conditionForLoop production.
	ExitConditionForLoop(c *ConditionForLoopContext)

	// ExitInfiniteForLoop is called when exiting the infiniteForLoop production.
	ExitInfiniteForLoop(c *InfiniteForLoopContext)

	// ExitSimpleStatement is called when exiting the simpleStatement production.
	ExitSimpleStatement(c *SimpleStatementContext)

	// ExitExpressionList is called when exiting the expressionList production.
	ExitExpressionList(c *ExpressionListContext)

	// ExitMapInitialization is called when exiting the mapInitialization production.
	ExitMapInitialization(c *MapInitializationContext)

	// ExitForeachStatement is called when exiting the foreachStatement production.
	ExitForeachStatement(c *ForeachStatementContext)

	// ExitTypeConversion is called when exiting the typeConversion production.
	ExitTypeConversion(c *TypeConversionContext)
}
