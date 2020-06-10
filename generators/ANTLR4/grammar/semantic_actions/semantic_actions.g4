grammar semantic_actions;

@parser::header{
    #include "../src/stack_collection.h"
}

@parser::members {
    stack_collection stacks;
}

start : stmt* EOF {stacks.print_error_counts();};
stmt : new_stack_stmt | decl_stmt | atomic_stmt;
decl_stmt : IDENT '=' expr {stacks.check_decl($IDENT.text);} ';'; // Declare the variable after we know the type of the expression.
atomic_stmt : expr ';';
new_stack_stmt : '{' {stacks.push();} stmt+ '}' {stacks.pop();};
expr :
paren_expr
| expr ('*'|'/') expr 
| expr ('+'|'-') expr
| function_call_expr
| IDENT {stacks.check_use($IDENT.text);}
| INTEGER
;

paren_expr : '(' expr ')';
function_call_expr : IDENT {stacks.check_function_name($IDENT.text);} '(' call_expr_list ')';
call_expr_list : (expr (',' expr)*)?;
IDENT : [a-zA-Z_]+;
INTEGER : [0-9]+;
WS : [ \n\r\t]+ -> skip;
