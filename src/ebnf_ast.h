#pragma once
#include <memory>
#include <vector>
#include <string>
#include <type_traits>

namespace ebnf_ast 
{
	template<typename T>
	using ptr = std::unique_ptr<T>;

	struct node {};
	struct expr : node {};
	struct weights_info { double weight; double decrease_factor; };

	struct production :node { std::string name; ptr<expr> rhs; };
	struct production_list :node { std::vector<ptr<production>> prods; };
	
	struct terminal_expr : expr { std::string token_name; };
	struct nonterminal_expr : expr { std::string name; };

	struct alt_expr : expr { ptr<expr> lhs; weights_info lhs_weight = { 10,10 }; ptr<expr> rhs; weights_info rhs_weight = { 10,10 }; };
	struct concat_expr : expr { ptr<expr> lhs; weights_info lhs_weight = { 10,10 }; ptr<expr> rhs; weights_info rhs_weight{ 10,10 }; };
	struct zero_list_expr : expr { ptr<expr> expr; weights_info weight{ 10,10 }; };
	struct one_list_expr : expr { ptr<expr> expr; weights_info weight{ 10,10 }; };
	struct maybe_expr : expr { ptr<expr> expr; weights_info weight{ 10,10 }; };

	static_assert(std::is_base_of_v<expr, terminal_expr>);
}
