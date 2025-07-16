grammar GoSugar;

// Regras principais
program: programDeclaration* EOF;

programDeclaration
    : importsDeclaration
    | globalVarStatement
    | interfaceDeclaration
    | classDeclaration
    | packageDeclaration
    | methodDeclaration
    ;

globalVarStatement
    : varStatement
    ;

interfaceDeclaration
    :  'interface' IDENTIFIER interfaceBody
    ;

interfaceBody
    : '{' interfaceMethod* '}'
    ;

interfaceMethod
    : IDENTIFIER '(' parameterList? ')' returnType?
    ;

classDeclaration
    : 'class' IDENTIFIER ('as' aliasType)? ( 'use' compositionList )? ('must' mustInterfaceList)? classBody
    ;

packageDeclaration
    : 'package' IDENTIFIER
    ;

importsDeclaration
    : 'import' STRING 
    | 'import' '(' WS* STRING (WS* NEWLINE* WS* STRING)* ')'
    ;

createObjectDeclaration
    : CREATE IDENTIFIER '(' argumentList? ')'
    ;

sliceDeclaration
    : '[]' IDENTIFIER '{' (primaryExpression (',' primaryExpression)*)? '}'
    ;

sliceOrArrayLiteral
    : '[' (primaryExpression (',' primaryExpression)*)? ']'
    ;

listAccess
    : leftHandSide ('[' expression ']')*
    ;

aliasType
    : varType
    ;

compositionList
    : leftHandSide ( ',' leftHandSide )*
    ;

mustInterfaceList
    : IDENTIFIER ( ',' IDENTIFIER )*
    ;

classBody
    : '{' classMember* '}'
    ;

classMember
    : fieldDeclaration
    | methodDeclaration
    ;

varType
    : STAR? AMPERSAND? IDENTIFIER
    | STAR? AMPERSAND? '[]' varType
    | STAR? AMPERSAND? '[' NUMBER? ']' varType
    | STAR? AMPERSAND? 'map' '[' varType ']' varType
    | STAR? AMPERSAND? IDENTIFIER DOT varType
    ;

fieldDeclaration
    : IDENTIFIER varType structTag?
    ;

structTag
    : STRING_TAG
    | ANGLE_TAG
    ;

methodDeclaration
    : ( STATIC )? 'func' IDENTIFIER '(' parameterList? ')' returnType? methodBody
    ;

anonimousFunctionDeclaration
    : '(' parameterList? ')' (':' returnType)? '->' methodBody
    ;

returnType
    : '(' returnTypeList ')'
    | varType
    ;

returnTypeList
    : returnTypeSingle (',' returnTypeSingle)*
    ;

returnTypeSingle
    : varType
    ;

parameterList
    : parameter ( ',' parameter )*
    ;

methodBody
    : '{' statement* '}'
    ;

parameter
    : IDENTIFIER varType?
    | IDENTIFIER ELLIPSIS varType
    ;

block
    : '{' statement* '}'
    ;

statement
    : assignment // 1
    | methodCall // 2
    | returnOperation // 3
    | continueOperation // 4
    | breakOperation // 5
    | varStatement // 6
    | listLiteral // 7
    | ifStatement // 8
    | elseStatement // 9
    | forStatement // 10
    | foreachStatement // 11
    | incrementOrDecrementStatement // 12
    | switchStatement // 13
    ;

switchStatement
    : 'switch' expression '{' caseBlock* defaultBlock? '}'
    ;

caseBlock
    : 'case' expressionList ':' statement*
    ;

defaultBlock
    : 'default' ':' statement*
    ;

negationExpression
    : '!' STAR? AMPERSAND? expression
    ;

assignment
    : assignmentLeftHandSide (',' assignmentLeftHandSide)? assignmentOperator expression
    ;

assignmentLeftHandSide
    : leftHandSide (',' leftHandSide)
    | listAccess
    ;

leftHandSide
    : STAR? AMPERSAND? IDENTIFIER ('{}')* (DOT IDENTIFIER)*
    | STAR? AMPERSAND? IDENTIFIER ('[' expression ']')* ( DOT IDENTIFIER ('[' expression ']')*)*
    ;

assignmentOperator
    : '='
    | ':='
    | '*='
    | '/='
    | '%='
    | '+='
    | '-='
    | '<<='
    | '>>='
    | '&='
    | '^='
    | '|='
    ;

comparisonOperator
    : '=='
    | '!='
    | '>'
    | '<'
    | '>='
    | '<='
    | '||'
    | '&&'
    ;

methodCall
    : IDENTIFIER '(' argumentList? ')' (DOT methodCall)?
    | leftHandSide '(' argumentList? ')' ','? (DOT methodCall)?
    ;

argumentList
    : expression (',' expression)*
    ;

expression
    : primaryExpression (operatorExpression)*
    ;



concatenatedString
    : STRING ('+' STRING)+
    ;

interfaceTypeVerification
    : STAR? IDENTIFIER DOT '(' STAR? IDENTIFIER (DOT IDENTIFIER)? ')'
    | methodCall DOT '(' STAR? IDENTIFIER (DOT IDENTIFIER)? ')'
    | 'interface{}' '(' IDENTIFIER (DOT IDENTIFIER | methodCall)? ')' (DOT '(' IDENTIFIER ')')?
    | STAR? IDENTIFIER DOT (IDENTIFIER DOT)? ('(' IDENTIFIER (DOT IDENTIFIER | methodCall)? ')')? (DOT methodCall)?
    ;

primaryExpression
    : createObjectDeclaration // 1
    | sliceDeclaration // 2
    | mapInitialization // 3
    | sliceOrArrayLiteral // 4
    | methodCall (DOT methodCall)? // 5
    | STAR? IDENTIFIER // 6
    | AMPERSAND? IDENTIFIER // 7
    | concatenatedString // 8
    | NIL // 9
    | STRING // 10
    | NUMBER // 11
    | leftHandSide // 12
    | listLiteral // 13
    | negationExpression // 14
    | '(' expression ')' // 15
    | listAccess // 16
    | anonimousFunctionDeclaration // 17
    | incrementOrDecrementStatement // 18
    | typeConversion // 19
    | varType // 20
    | interfaceTypeVerification // 21
    | directCreateInstance // 22
    ;

directCreateInstance
    : AMPERSAND? varType '{' (mapKeyValue (',' mapKeyValue)* ','?)? '}'
    ;

mapKeyValue
    : (STRING | IDENTIFIER) ':' expression
    ;

listLiteral
    : '{' (mapKeyValue (',' mapKeyValue)* ','?)? '}'
    | '{' (expression (',' expression)* ','?)? '}'
    | varType '{' (expression (',' expression)* ','?)? '}'
    | varType '[' NUMBER? ']' '{' (expression (',' expression)* ','?)? '}'
    | varType '{}'
    ;

operatorExpression
    : ('*' | '/' | '%') primaryExpression
    | ('+' | '-') primaryExpression
    | comparisonOperator primaryExpression
    ;

comparison
    : primaryExpression (comparisonOperator comparison)?
    ;

returnOperation
    : 'return' argumentList?
    ;

continueOperation
    : 'continue' IDENTIFIER?
    ;

breakOperation
    : 'break' IDENTIFIER?
    ;

varValue
    : listLiteral
    | expression
    | mapInitialization
    ;

varStatement
    : 'var' IDENTIFIER varType (assignmentOperator varValue)?
    | 'var' IDENTIFIER assignmentOperator varValue
    ;

ifStatement
    : 'if' (assignment ';')? comparison block elseStatement?
    ;

elseStatement
    : 'else' (ifStatement | block)
    ;

incrementOrDecrementStatement
    : STAR? AMPERSAND? IDENTIFIER ('++' | '--')
    ;

forStatement
    : 'for' (classicForLoop | rangeForLoop | conditionForLoop | infiniteForLoop) block
    ;

classicForLoop
    : simpleStatement? ';' expression? ';' simpleStatement?
    ;

rangeForLoop
    : (expressionList ':=')? 'range' expression
    ;

conditionForLoop
    : expression
    ;

infiniteForLoop
    : // Nenhuma condição, apenas 'for' e um bloco de código
    ;

simpleStatement
    : assignment
    | expression
    | incrementOrDecrementStatement
    ;

expressionList
    : expression (',' expression)*
    ;

mapInitialization
    : varType '{' (mapKeyValue (',' mapKeyValue)* ','?)? '}'
    ;

foreachStatement
    : 'foreach' expression 'as' IDENTIFIER (',' IDENTIFIER)? block
    ;

typeConversion
    : IDENTIFIER '(' expression ')'
    ;

// Tokens
ELLIPSIS: '...';
STAR: '*';
AMPERSAND: '&';
CREATE: 'create';
STATIC: 'static';
IDENTIFIER: '_' | [a-zA-Z][a-zA-Z_0-9]*;
NUMBER: '-'? [0-9]+ ('.' [0-9]+)?;
POSITIVE_INTEGER: [1-9][0-9]* | '0';
DOT: '.';
STRING: ('"' (ESC | ~('\\' | '"'))* '"') 
      | ('\'' (ESC | ~('\\' | '\''))* '\'') 
      | ('`' ~'`'* '`');
NIL: 'nil';

fragment ESC: '\\' (["\\/bfnrt']|UNICODE);
fragment UNICODE: 'u' HEX HEX HEX HEX;
fragment HEX: [0-9a-fA-F];


// Ignorar espaços em branco
WS: [ \t\r\n]+ -> skip;

BlockComment
    : '/*' .*? '*/' -> channel(HIDDEN)
    ;

LineComment
    : '//' ~[\r\n]* -> channel(HIDDEN)
    ;

// Final de instrução (implícito)
NEWLINE: ';' | '\r'? '\n';

// struct tags
STRING_TAG   : '`' .*? '`';
ANGLE_TAG    : '<' ~[>]* '>';
