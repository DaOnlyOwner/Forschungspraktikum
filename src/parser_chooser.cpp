#include "parser_chooser.h"

// Antlr
#include "antlr4_parser.h"
#include "expressions/antlr4/expressionsLexer.h"
#include "expressions/antlr4/expressionsParser.h"
#include "ebnf/antlr4/ebnfLexer.h"
#include "ebnf/antlr4/ebnfParser.h"


std::unique_ptr<base_parser> choose_for_antlr4(GrammarType g)
{
	switch (g)
	{
	case GrammarType::Expression:
		return std::make_unique<antlr4_parser<expressionsLexer, expressionsParser>>(nullptr);
	case GrammarType::EBNF:
		return std::make_unique<antlr4_parser<ebnfLexer, ebnfParser>>(std::make_unique<ebnf_antlr4_gen>());
	case GrammarType::HTML:
		break;
	default: 
		break;
	}
}

std::unique_ptr<base_parser> choose_parser(GrammarType grammar, Generator generator)
{
	switch (generator)
	{
	case Generator::Antlr4:
		return choose_for_antlr4(grammar);
	}
}
