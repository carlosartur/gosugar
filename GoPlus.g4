grammar GoPlus;

// Regras principais
program: programDeclaration* EOF;

programDeclaration
    : classDeclaration
    | methodDeclaration
    ;

classDeclaration
    : 'class' IDENTIFIER ( 'use' compositionList )? classBody
    ;

createObjectDeclaration
    : CREATE IDENTIFIER '(' argumentList? ')'
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
    : ( STATIC )? 'func' IDENTIFIER '(' parameterList? ')' returnType? methodBody
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
    : createObjectDeclaration
    | methodCall
    | IDENTIFIER
    | STRING
    | NUMBER
    | leftHandSide
    ;

returnOperation
    : 'return' expression?
    ;

// Tokens
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