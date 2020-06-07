#include "ebnf_antlr4_ast_gen.h"
#include "ebnf_ast.h"
#include <cstdio>
#include <tuple>

antlrcpp::Any ebnf_antlr4_gen::visitProduction_list(ebnfParser::Production_listContext* context)
{
    ebnf_ast::production_list* list = new ebnf_ast::production_list;
    for (auto* ptree_node : context->production())
    {
        ebnf_ast::production* prod = ptree_node->accept(this).as<ebnf_ast::production*>();
        std::unique_ptr<ebnf_ast::production> prod_uptr(prod);     
        list->prods.push_back(std::move(prod_uptr));
    }
    return list;
}

antlrcpp::Any ebnf_antlr4_gen::visitProduction(ebnfParser::ProductionContext* context)
{
    ebnf_ast::production* prod = new ebnf_ast::production;
    prod->name = context->IDENT()->getText();
    prod->rhs = ebnf_ast::ptr<ebnf_ast::expr>(context->rhs()->accept(this).as<ebnf_ast::expr*>());
    return prod;
}

antlrcpp::Any ebnf_antlr4_gen::visitParen_expr(ebnfParser::Paren_exprContext* context)
{
    auto a = context->rhs()->accept(this);
    return a.as<ebnf_ast::expr*>();
}


// TODO: Weights.
template<typename T>
ebnf_ast::expr* create_bin_expr(ebnf_antlr4_gen* visitor, ebnfParser::RhsContext* lhs, ebnfParser::RhsContext* rhs, double weightL, double weightR, double decreaseL, double decreaseR)
{
    T* t = new T();
    t->lhs = ebnf_ast::ptr<ebnf_ast::expr>(lhs->accept(visitor).as<ebnf_ast::expr*>());
    t->rhs = ebnf_ast::ptr<ebnf_ast::expr>(rhs->accept(visitor).as<ebnf_ast::expr*>());
    t->lhs_weight = { weightL, decreaseL };
    t->rhs_weight = { weightR, decreaseR };
    return t;
}

template<typename T>
ebnf_ast::expr* create_postfix_expr(ebnf_antlr4_gen* visitor, ebnfParser::RhsContext* lhs, double weight, double decrease)
{
    T* t = new T();
    t->expr = ebnf_ast::ptr<ebnf_ast::expr>(lhs->accept(visitor).as<ebnf_ast::expr*>());
    t->weight = { weight,decrease };
    return t;
}

// TODO: Refactor.

antlrcpp::Any ebnf_antlr4_gen::visitZero_list_expr(ebnfParser::Zero_list_exprContext* context)
{
    auto [weight, decrease] = context->weight_post() != nullptr ? context->weight_post()->accept(this).as<std::tuple<double, double>>() : std::make_tuple(10., 10.);
    auto expr = create_postfix_expr<ebnf_ast::zero_list_expr>(this, context->rhs(),weight,decrease);
    return expr;
}

antlrcpp::Any ebnf_antlr4_gen::visitAlt_expr(ebnfParser::Alt_exprContext* context)
{
    auto [weightL, decreaseL] = context->weights_left != nullptr ? context->weights_left->accept(this).as<std::tuple<double, double>>() : std::make_tuple(10., 10.);
    auto [weightR, decreaseR] = context->weights_right != nullptr ? context->weights_right->accept(this).as<std::tuple<double, double>>() : std::make_tuple(10., 10.);
    return create_bin_expr<ebnf_ast::alt_expr>(this, context->expr_left, context->expr_right,weightL, weightR,decreaseL,decreaseR);
}

antlrcpp::Any ebnf_antlr4_gen::visitMaybe_expr(ebnfParser::Maybe_exprContext* context)
{
    auto [weight, decrease] = context->weight_post() != nullptr ? context->weight_post()->accept(this).as<std::tuple<double, double>>() : std::make_tuple(10., 10.);
    auto expr = create_postfix_expr<ebnf_ast::maybe_expr>(this, context->rhs(),weight,decrease);
    return expr;
}

antlrcpp::Any ebnf_antlr4_gen::visitConcat_expr(ebnfParser::Concat_exprContext* context)
{
    auto [weightL, decreaseL] = context->weights_left != nullptr ? context->weights_left -> accept(this).as<std::tuple<double, double>>() : std::make_tuple(10., 10.);
    auto [weightR, decreaseR] = context->weights_right != nullptr ? context->weights_right -> accept(this).as<std::tuple<double, double>>() : std::make_tuple(10., 10.);
    return create_bin_expr<ebnf_ast::alt_expr>(this, context->expr_left, context->expr_right, weightL, weightR, decreaseL, decreaseR);
}

antlrcpp::Any ebnf_antlr4_gen::visitOne_list_expr(ebnfParser::One_list_exprContext* context)
{
    auto [weight, decrease] = context->weight_post() != nullptr ? context->weight_post()->accept(this).as<std::tuple<double, double>>() : std::make_tuple(10., 10.);
    auto expr = create_postfix_expr<ebnf_ast::one_list_expr>(this, context->rhs(),weight,decrease);
    return expr;
}

antlrcpp::Any ebnf_antlr4_gen::visitTerminal_expr(ebnfParser::Terminal_exprContext* context)
{
    ebnf_ast::terminal_expr* out = new ebnf_ast::terminal_expr();
    out->token_name = context->getText();
    return (ebnf_ast::expr*) out; // https://groups.google.com/forum/#!topic/antlr-discussion/LHHgOLvXza0
}

antlrcpp::Any ebnf_antlr4_gen::visitNonterminal_expr(ebnfParser::Nonterminal_exprContext* context)
{
    auto* out = new ebnf_ast::nonterminal_expr();
    out->name = context->getText();
    return (ebnf_ast::expr*) out;
}


std::tuple<double,double> create_weights(antlr4::Token* weight_token, antlr4::Token* decrease_token)
{
    double weight;
    double decrease;
    if (weight_token == nullptr) weight = 10;
    else weight = atof(weight_token->getText().c_str());
    if (decrease_token == nullptr) decrease = 10;
    else decrease = atof(decrease_token->getText().c_str());

    return std::make_tuple(weight, decrease);
}

antlrcpp::Any ebnf_antlr4_gen::visitWeight_bin(ebnfParser::Weight_binContext* context)
{
    return create_weights(context->weight,context->decrease);
}

antlrcpp::Any ebnf_antlr4_gen::visitWeight_post(ebnfParser::Weight_postContext* context)
{
    return create_weights(context->weight, context->decrease);
}

antlrcpp::Any ebnf_antlr4_gen::visitStart(ebnfParser::StartContext* context)
{
    return context->production_list()->accept(this);
}
