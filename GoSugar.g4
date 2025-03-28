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
    : IDENTIFIER varType
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
    | sliceOrArrayLiteral // 3
    | methodCall (DOT methodCall)? // 4
    | STAR? IDENTIFIER // 5
    | AMPERSAND? IDENTIFIER // 6
    | concatenatedString // 7
    | NIL // 8
    | STRING // 9
    | NUMBER // 10
    | leftHandSide // 11
    | listLiteral // 12
    | negationExpression // 13
    | '(' expression ')' // 14
    | listAccess // 15
    | anonimousFunctionDeclaration // 16
    | incrementOrDecrementStatement // 17
    | typeConversion // 18
    | varType // 19
    | interfaceTypeVerification // 20
    | directCreateInstance // 21
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

varStatement
    : 'var' IDENTIFIER varType ('=' expression)?
    | 'var' IDENTIFIER ':=' expression
    | 'var' IDENTIFIER '=' expression
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
