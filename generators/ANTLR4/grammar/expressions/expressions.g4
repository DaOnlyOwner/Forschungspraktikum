grammar expressions;

start : exprs EOF;

exprs : (expr ';')+;
expr_list : (expr (',' expr)*)?; // The list may be empty.
expr : expr '::' expr #scope_expr
| expr '+' '+' #postfix_incr_expr // Parsing '++' as '+' '+' allows for stuff like x++4 == (bin(+,x,unary(+,4))) which is not allowed in C++ btw.
| expr '-' '-' #postfix_decr_expr
| expr '(' expr_list ')' #function_call_expr
| expr '[' expr_list ']' #array_index_expr
| '+' '+' expr #prefix_incr_expr
| '-' '-' expr #prefix_decr_expr
| '+' expr #unary_plus_expr
| '-' expr #unary_minus_expr
| '~' expr #bit_flip_expr
| '!' expr #logical_neg_expr
| '*' expr #pointer_deref_expr
|'&' expr #pointer__expr
| expr '*' expr #mul_expr
| expr '/' expr #div_expr
| expr '%' expr #mod_expr
| expr '-' expr #sub_expr
| expr '+' expr  #add_expr
| expr '<' '<' expr #left_shift_expr
| expr '>' '>' expr #right_shift_expr
| expr '^' expr #bit_xor_expr
| expr '&' expr #bit_and_expr
| expr '|' expr #bit_or_expr
| expr '<' expr #comp_lesser_expr
| expr '<' '=' expr #comp_lesser_equal_expr
| expr '>' expr #comp_greater_expr
| expr '>' '=' expr #comp_greater_equal_expr
| expr '=' '=' expr #comp_equal_expr
| expr '!' '=' expr #comp_not_equal_expr
| expr '&' '&' expr #logical_and_expr
| expr '|' '|' expr #logical_or_expr
|<assoc=right> expr '?' expr ':' expr #ternary_if_expr
|<assoc=right> expr '=' expr    #ass_expr
|<assoc=right> expr '+' '=' expr   #ass_sum_expr
|<assoc=right> expr '-' '=' expr   #ass_diff_expr
|<assoc=right> expr '*' '=' expr   #ass_mul_expr
|<assoc=right> expr '/' '=' expr   #ass_div_expr
|<assoc=right> expr '%' '=' expr   #ass_mod_expr
|<assoc=right> expr '<' '<' '=' expr  #ass_rshift_expr
|<assoc=right> expr '>' '>' '=' expr  #ass_lshift_expr
|<assoc=right> expr '&' '=' expr   #ass_and_expr
|<assoc=right> expr '^' '=' expr   #ass_flip_expr
|<assoc=right> expr '|' '=' expr   #ass_or_expr
| primary #primary_expr
;

primary : Word | Number | '(' expr ')';

Number : [1-9]+([.][1-9]+)?;
Word : [a-z_]+;

Whitespace
    :   [ \t\r\n]+
        -> channel(HIDDEN)
    ;


