grammar GoPlus;

// Regras principais
program: classDeclaration* EOF;

classDeclaration
    : 'class' IDENTIFIER ( 'use' compositionList )? classBody
    ;

compositionList
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
    : IDENTIFIER IDENTIFIER
    ;

methodDeclaration
    : 'func' IDENTIFIER '(' parameterList? ')' returnType? methodBody
    ;

returnType
    : '(' parameterList ')'
    | IDENTIFIER
    ;

parameterList
    : parameter ( ',' parameter )*
    ;

methodBody
    : '{' statement* '}'
    ;

parameter
    : IDENTIFIER IDENTIFIER
    ;

block
    : '{' statement* '}'
    ;

statement
    : assignment
    | methodCall
    | returnOperation
    ;

assignment
    : leftHandSide assignmentOperator expression
    ;

leftHandSide
    : IDENTIFIER (DOT IDENTIFIER)*
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
    | '>>>='
    | '&='
    | '^='
    | '|='
    ;

methodCall
    : IDENTIFIER '(' argumentList? ')'
    | leftHandSide '(' argumentList? ')'
    ;

argumentList
    : expression (',' expression)*
    ;

expression
    : IDENTIFIER
    | STRING
    | NUMBER
    | methodCall
    | leftHandSide
    ;
    
returnOperation
    : 'return' expression?
    ;

// Tokens
IDENTIFIER: [a-zA-Z_][a-zA-Z_0-9]*;
NUMBER: [0-9]+ ('.' [0-9]+)?;
DOT: '.';
STRING: '"' (ESC | ~('\\' | '"'))* '"'; // Regra para strings
fragment ESC: '\\' (["\\/bfnrt']|UNICODE);
fragment UNICODE: 'u' HEX HEX HEX HEX;
fragment HEX: [0-9a-fA-F];


// Ignorar espaços em branco
WS: [ \t\r\n]+ -> skip;

// Final de instrução (implícito)
NEWLINE: ';'; // Ou ('\r'? '\n' | ';') -> skip;