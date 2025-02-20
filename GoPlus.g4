grammar GoPlus;

// Regras principais
program: programDeclaration* EOF;

programDeclaration
    : importsDeclaration
    | interfaceDeclaration
    | classDeclaration
    | packageDeclaration
    | methodDeclaration
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
    : 'class' IDENTIFIER ( 'use' compositionList )? ('must' mustInterfaceList)? classBody
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

compositionList
    : IDENTIFIER ( ',' IDENTIFIER )*
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

fieldDeclaration
    : IDENTIFIER STAR? IDENTIFIER
    ;

methodDeclaration
    : ( STATIC )? 'func' IDENTIFIER '(' parameterList? ')' returnType? methodBody
    ;

returnType
    : '(' returnTypeList ')'
    | STAR? IDENTIFIER
    ;

returnTypeList
    : returnTypeSingle (',' returnTypeSingle)*
    ;

returnTypeSingle
    : STAR? IDENTIFIER
    ;

parameterList
    : parameter ( ',' parameter )*
    ;

methodBody
    : '{' statement* '}'
    ;

parameter
    : IDENTIFIER STAR? IDENTIFIER?
    ;

block
    : '{' statement* '}'
    ;

statement
    : assignment
    | methodCall
    | returnOperation
    | varStatement
    | ifStatement
    | elseStatement
    ;

negationExpression
    : '!' expression
    ;

assignment
    : leftHandSide assignmentOperator expression
    ;

leftHandSide
    : IDENTIFIER ('{}')* (DOT IDENTIFIER)*
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
    ;

comparison
    : leftHandSide comparisonOperator expression
    ;

methodCall
    : IDENTIFIER '(' argumentList? ')'
    | leftHandSide '(' argumentList? ')'
    ;

argumentList
    : expression (',' expression)*
    ;

expression
    : createObjectDeclaration
    | methodCall
    | IDENTIFIER
    | STRING
    | NUMBER
    | leftHandSide
    | negationExpression
    | comparison
    ;

returnOperation
    : 'return' argumentList?
    ;

varStatement
    : 'var' IDENTIFIER STAR? IDENTIFIER ('=' expression)?
    | 'var' IDENTIFIER ':=' expression
    ;

ifStatement
    : 'if' (assignment ';')? expression block elseStatement?
    ;

elseStatement
    : 'else' (ifStatement | block)
    ;

// Tokens
STAR: '*';
CREATE: 'create';
STATIC: 'static';
IDENTIFIER: [a-zA-Z_][a-zA-Z_0-9]*;
NUMBER: [0-9]+ ('.' [0-9]+)?;
DOT: '.';
STRING: '"' (ESC | ~('\\' | '"'))* '"'; // Regra para strings
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
NEWLINE: ';'; // Ou ('\r'? '\n' | ';') -> skip;