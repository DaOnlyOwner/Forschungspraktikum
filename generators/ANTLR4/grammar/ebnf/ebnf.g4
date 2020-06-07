grammar ebnf;

start : production_list EOF;

production_list : production+;
production: IDENT ':' rhs ';';
rhs:
expr_right=rhs weights_right=weight_bin? '|' expr_left=rhs weights_left=weight_bin? #alt_expr
| expr_right=rhs weights_right=weight_bin? expr_left=rhs weights_left=weight_bin? #concat_expr
| rhs '*' weight_post? #zero_list_expr
| rhs '+' weight_post? #one_list_expr
| rhs '?' weight_post? #maybe_expr
| '(' rhs ')' #paren_expr
| QUOTED_STRING #terminal_expr
| IDENT #nonterminal_expr
;

weight_bin : '#' weight=DECIMAL (',' decrease=DECIMAL)?;
weight_post : '##' weight=DECIMAL (',' decrease=DECIMAL)?;

INTEGER : [0-9];
DECIMAL : INTEGER ('.' INTEGER)?;
IDENT : [a-zA-Z_]+;
QUOTED_STRING : '"' ( '\\"' | .)*? '"';
WS : [ \r\t\n]+ ->channel(HIDDEN);


