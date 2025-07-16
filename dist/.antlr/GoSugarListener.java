// Generated from /home/carlos/outros-projetos/gosugar/GoSugar.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GoSugarParser}.
 */
public interface GoSugarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(GoSugarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(GoSugarParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#programDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterProgramDeclaration(GoSugarParser.ProgramDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#programDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitProgramDeclaration(GoSugarParser.ProgramDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#globalVarStatement}.
	 * @param ctx the parse tree
	 */
	void enterGlobalVarStatement(GoSugarParser.GlobalVarStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#globalVarStatement}.
	 * @param ctx the parse tree
	 */
	void exitGlobalVarStatement(GoSugarParser.GlobalVarStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceDeclaration(GoSugarParser.InterfaceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceDeclaration(GoSugarParser.InterfaceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceBody(GoSugarParser.InterfaceBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceBody(GoSugarParser.InterfaceBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#interfaceMethod}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceMethod(GoSugarParser.InterfaceMethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#interfaceMethod}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceMethod(GoSugarParser.InterfaceMethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(GoSugarParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(GoSugarParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterPackageDeclaration(GoSugarParser.PackageDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitPackageDeclaration(GoSugarParser.PackageDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#importsDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterImportsDeclaration(GoSugarParser.ImportsDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#importsDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitImportsDeclaration(GoSugarParser.ImportsDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#createObjectDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterCreateObjectDeclaration(GoSugarParser.CreateObjectDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#createObjectDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitCreateObjectDeclaration(GoSugarParser.CreateObjectDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#sliceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterSliceDeclaration(GoSugarParser.SliceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#sliceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitSliceDeclaration(GoSugarParser.SliceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#sliceOrArrayLiteral}.
	 * @param ctx the parse tree
	 */
	void enterSliceOrArrayLiteral(GoSugarParser.SliceOrArrayLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#sliceOrArrayLiteral}.
	 * @param ctx the parse tree
	 */
	void exitSliceOrArrayLiteral(GoSugarParser.SliceOrArrayLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#listAccess}.
	 * @param ctx the parse tree
	 */
	void enterListAccess(GoSugarParser.ListAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#listAccess}.
	 * @param ctx the parse tree
	 */
	void exitListAccess(GoSugarParser.ListAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#aliasType}.
	 * @param ctx the parse tree
	 */
	void enterAliasType(GoSugarParser.AliasTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#aliasType}.
	 * @param ctx the parse tree
	 */
	void exitAliasType(GoSugarParser.AliasTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#compositionList}.
	 * @param ctx the parse tree
	 */
	void enterCompositionList(GoSugarParser.CompositionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#compositionList}.
	 * @param ctx the parse tree
	 */
	void exitCompositionList(GoSugarParser.CompositionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#mustInterfaceList}.
	 * @param ctx the parse tree
	 */
	void enterMustInterfaceList(GoSugarParser.MustInterfaceListContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#mustInterfaceList}.
	 * @param ctx the parse tree
	 */
	void exitMustInterfaceList(GoSugarParser.MustInterfaceListContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(GoSugarParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(GoSugarParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#classMember}.
	 * @param ctx the parse tree
	 */
	void enterClassMember(GoSugarParser.ClassMemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#classMember}.
	 * @param ctx the parse tree
	 */
	void exitClassMember(GoSugarParser.ClassMemberContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#varType}.
	 * @param ctx the parse tree
	 */
	void enterVarType(GoSugarParser.VarTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#varType}.
	 * @param ctx the parse tree
	 */
	void exitVarType(GoSugarParser.VarTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclaration(GoSugarParser.FieldDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclaration(GoSugarParser.FieldDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(GoSugarParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(GoSugarParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#anonimousFunctionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAnonimousFunctionDeclaration(GoSugarParser.AnonimousFunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#anonimousFunctionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAnonimousFunctionDeclaration(GoSugarParser.AnonimousFunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#returnType}.
	 * @param ctx the parse tree
	 */
	void enterReturnType(GoSugarParser.ReturnTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#returnType}.
	 * @param ctx the parse tree
	 */
	void exitReturnType(GoSugarParser.ReturnTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#returnTypeList}.
	 * @param ctx the parse tree
	 */
	void enterReturnTypeList(GoSugarParser.ReturnTypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#returnTypeList}.
	 * @param ctx the parse tree
	 */
	void exitReturnTypeList(GoSugarParser.ReturnTypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#returnTypeSingle}.
	 * @param ctx the parse tree
	 */
	void enterReturnTypeSingle(GoSugarParser.ReturnTypeSingleContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#returnTypeSingle}.
	 * @param ctx the parse tree
	 */
	void exitReturnTypeSingle(GoSugarParser.ReturnTypeSingleContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(GoSugarParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(GoSugarParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void enterMethodBody(GoSugarParser.MethodBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void exitMethodBody(GoSugarParser.MethodBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(GoSugarParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(GoSugarParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(GoSugarParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(GoSugarParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(GoSugarParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(GoSugarParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void enterSwitchStatement(GoSugarParser.SwitchStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void exitSwitchStatement(GoSugarParser.SwitchStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#caseBlock}.
	 * @param ctx the parse tree
	 */
	void enterCaseBlock(GoSugarParser.CaseBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#caseBlock}.
	 * @param ctx the parse tree
	 */
	void exitCaseBlock(GoSugarParser.CaseBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#defaultBlock}.
	 * @param ctx the parse tree
	 */
	void enterDefaultBlock(GoSugarParser.DefaultBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#defaultBlock}.
	 * @param ctx the parse tree
	 */
	void exitDefaultBlock(GoSugarParser.DefaultBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#negationExpression}.
	 * @param ctx the parse tree
	 */
	void enterNegationExpression(GoSugarParser.NegationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#negationExpression}.
	 * @param ctx the parse tree
	 */
	void exitNegationExpression(GoSugarParser.NegationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(GoSugarParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(GoSugarParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#assignmentLeftHandSide}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentLeftHandSide(GoSugarParser.AssignmentLeftHandSideContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#assignmentLeftHandSide}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentLeftHandSide(GoSugarParser.AssignmentLeftHandSideContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#leftHandSide}.
	 * @param ctx the parse tree
	 */
	void enterLeftHandSide(GoSugarParser.LeftHandSideContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#leftHandSide}.
	 * @param ctx the parse tree
	 */
	void exitLeftHandSide(GoSugarParser.LeftHandSideContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentOperator(GoSugarParser.AssignmentOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentOperator(GoSugarParser.AssignmentOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void enterComparisonOperator(GoSugarParser.ComparisonOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void exitComparisonOperator(GoSugarParser.ComparisonOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(GoSugarParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(GoSugarParser.MethodCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(GoSugarParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(GoSugarParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(GoSugarParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(GoSugarParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#concatenatedString}.
	 * @param ctx the parse tree
	 */
	void enterConcatenatedString(GoSugarParser.ConcatenatedStringContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#concatenatedString}.
	 * @param ctx the parse tree
	 */
	void exitConcatenatedString(GoSugarParser.ConcatenatedStringContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#interfaceTypeVerification}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceTypeVerification(GoSugarParser.InterfaceTypeVerificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#interfaceTypeVerification}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceTypeVerification(GoSugarParser.InterfaceTypeVerificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpression(GoSugarParser.PrimaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpression(GoSugarParser.PrimaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#directCreateInstance}.
	 * @param ctx the parse tree
	 */
	void enterDirectCreateInstance(GoSugarParser.DirectCreateInstanceContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#directCreateInstance}.
	 * @param ctx the parse tree
	 */
	void exitDirectCreateInstance(GoSugarParser.DirectCreateInstanceContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#mapKeyValue}.
	 * @param ctx the parse tree
	 */
	void enterMapKeyValue(GoSugarParser.MapKeyValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#mapKeyValue}.
	 * @param ctx the parse tree
	 */
	void exitMapKeyValue(GoSugarParser.MapKeyValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#listLiteral}.
	 * @param ctx the parse tree
	 */
	void enterListLiteral(GoSugarParser.ListLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#listLiteral}.
	 * @param ctx the parse tree
	 */
	void exitListLiteral(GoSugarParser.ListLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#operatorExpression}.
	 * @param ctx the parse tree
	 */
	void enterOperatorExpression(GoSugarParser.OperatorExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#operatorExpression}.
	 * @param ctx the parse tree
	 */
	void exitOperatorExpression(GoSugarParser.OperatorExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(GoSugarParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(GoSugarParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#returnOperation}.
	 * @param ctx the parse tree
	 */
	void enterReturnOperation(GoSugarParser.ReturnOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#returnOperation}.
	 * @param ctx the parse tree
	 */
	void exitReturnOperation(GoSugarParser.ReturnOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#continueOperation}.
	 * @param ctx the parse tree
	 */
	void enterContinueOperation(GoSugarParser.ContinueOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#continueOperation}.
	 * @param ctx the parse tree
	 */
	void exitContinueOperation(GoSugarParser.ContinueOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#breakOperation}.
	 * @param ctx the parse tree
	 */
	void enterBreakOperation(GoSugarParser.BreakOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#breakOperation}.
	 * @param ctx the parse tree
	 */
	void exitBreakOperation(GoSugarParser.BreakOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#varValue}.
	 * @param ctx the parse tree
	 */
	void enterVarValue(GoSugarParser.VarValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#varValue}.
	 * @param ctx the parse tree
	 */
	void exitVarValue(GoSugarParser.VarValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#varStatement}.
	 * @param ctx the parse tree
	 */
	void enterVarStatement(GoSugarParser.VarStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#varStatement}.
	 * @param ctx the parse tree
	 */
	void exitVarStatement(GoSugarParser.VarStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(GoSugarParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(GoSugarParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseStatement(GoSugarParser.ElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseStatement(GoSugarParser.ElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#incrementOrDecrementStatement}.
	 * @param ctx the parse tree
	 */
	void enterIncrementOrDecrementStatement(GoSugarParser.IncrementOrDecrementStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#incrementOrDecrementStatement}.
	 * @param ctx the parse tree
	 */
	void exitIncrementOrDecrementStatement(GoSugarParser.IncrementOrDecrementStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(GoSugarParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(GoSugarParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#classicForLoop}.
	 * @param ctx the parse tree
	 */
	void enterClassicForLoop(GoSugarParser.ClassicForLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#classicForLoop}.
	 * @param ctx the parse tree
	 */
	void exitClassicForLoop(GoSugarParser.ClassicForLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#rangeForLoop}.
	 * @param ctx the parse tree
	 */
	void enterRangeForLoop(GoSugarParser.RangeForLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#rangeForLoop}.
	 * @param ctx the parse tree
	 */
	void exitRangeForLoop(GoSugarParser.RangeForLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#conditionForLoop}.
	 * @param ctx the parse tree
	 */
	void enterConditionForLoop(GoSugarParser.ConditionForLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#conditionForLoop}.
	 * @param ctx the parse tree
	 */
	void exitConditionForLoop(GoSugarParser.ConditionForLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#infiniteForLoop}.
	 * @param ctx the parse tree
	 */
	void enterInfiniteForLoop(GoSugarParser.InfiniteForLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#infiniteForLoop}.
	 * @param ctx the parse tree
	 */
	void exitInfiniteForLoop(GoSugarParser.InfiniteForLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#simpleStatement}.
	 * @param ctx the parse tree
	 */
	void enterSimpleStatement(GoSugarParser.SimpleStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#simpleStatement}.
	 * @param ctx the parse tree
	 */
	void exitSimpleStatement(GoSugarParser.SimpleStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(GoSugarParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(GoSugarParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#mapInitialization}.
	 * @param ctx the parse tree
	 */
	void enterMapInitialization(GoSugarParser.MapInitializationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#mapInitialization}.
	 * @param ctx the parse tree
	 */
	void exitMapInitialization(GoSugarParser.MapInitializationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#foreachStatement}.
	 * @param ctx the parse tree
	 */
	void enterForeachStatement(GoSugarParser.ForeachStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#foreachStatement}.
	 * @param ctx the parse tree
	 */
	void exitForeachStatement(GoSugarParser.ForeachStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoSugarParser#typeConversion}.
	 * @param ctx the parse tree
	 */
	void enterTypeConversion(GoSugarParser.TypeConversionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoSugarParser#typeConversion}.
	 * @param ctx the parse tree
	 */
	void exitTypeConversion(GoSugarParser.TypeConversionContext ctx);
}