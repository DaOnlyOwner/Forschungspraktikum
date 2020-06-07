#pragma once
#include "ebnf/antlr4/ebnfBaseVisitor.h"

class ebnf_antlr4_gen : public ebnfVisitor
{
	// Geerbt über ebnfVisitor
	virtual antlrcpp::Any visitStart(ebnfParser::StartContext* context) override;
	virtual antlrcpp::Any visitProduction_list(ebnfParser::Production_listContext* context) override;
	virtual antlrcpp::Any visitProduction(ebnfParser::ProductionContext* context) override;
	virtual antlrcpp::Any visitParen_expr(ebnfParser::Paren_exprContext* context) override;
	virtual antlrcpp::Any visitZero_list_expr(ebnfParser::Zero_list_exprContext* context) override;
	virtual antlrcpp::Any visitAlt_expr(ebnfParser::Alt_exprContext* context) override;
	virtual antlrcpp::Any visitMaybe_expr(ebnfParser::Maybe_exprContext* context) override;
	virtual antlrcpp::Any visitConcat_expr(ebnfParser::Concat_exprContext* context) override;
	virtual antlrcpp::Any visitOne_list_expr(ebnfParser::One_list_exprContext* context) override;
	virtual antlrcpp::Any visitTerminal_expr(ebnfParser::Terminal_exprContext* context) override;
	virtual antlrcpp::Any visitNonterminal_expr(ebnfParser::Nonterminal_exprContext* context) override;
	virtual antlrcpp::Any visitWeight_bin(ebnfParser::Weight_binContext* context) override;
	virtual antlrcpp::Any visitWeight_post(ebnfParser::Weight_postContext* context) override;
};