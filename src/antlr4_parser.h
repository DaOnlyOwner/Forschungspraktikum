#pragma once
#include "base_parser.h"
#include <string>
#include <istream>
#include "antlr4-runtime.h"
#include <stdio.h>
#include <cassert>
#include <memory>

template<typename TLexer, typename TParser>
struct antlr4_parser_vars
{
	antlr4_parser_vars(const std::string& filename) : stream(filename), input(stream), lexer(&input), token_stream(&lexer), parser(&token_stream)
	{}

	std::ifstream stream;
	antlr4::ANTLRInputStream input;
	TLexer lexer;
	antlr4::CommonTokenStream token_stream;
	TParser parser;
};

template<typename TLexer, typename TParser>
class antlr4_parser : public base_parser
{
public:
	// Geerbt über base_parser
	antlr4_parser(){}
	virtual bool parse() override
	{
		assert(parser_vars != nullptr);
		auto& interpreter = *parser_vars->parser.getInterpreter<antlr4::atn::ParserATNSimulator>();
		interpreter.setPredictionMode(antlr4::atn::PredictionMode::SLL);
		parser_vars->parser.setErrorHandler(bail_strat);
		
#ifndef NDEBUG
		auto diag = std::make_unique<antlr4::DiagnosticErrorListener>();
		parser_vars->parser.addErrorListener(diag.get());
#endif

		try {
			parser_vars->parser.start();  // SLL
		}

		catch (std::exception& ex) {
#ifndef NDEBUG
			printf("Grammar \"%s\" is not SLL(k). Switching to ALL(*).\n", parser_vars->parser.getGrammarFileName().c_str());
#endif
			reset_state_inner();
			parser_vars->parser.start();  
		}
		return true;
	}

	virtual void reset_stream(const std::string& filename) override
	{
		parser_vars = std::make_unique<antlr4_parser_vars<TLexer, TParser>>(filename);
	}

	virtual void reset_state() override
	{
		reset_state_inner();
	}

	
private:
	void reset_state_inner()
	{
		parser_vars->parser.setErrorHandler(default_strat);
		parser_vars->token_stream.reset();
		parser_vars->parser.reset();
		auto& interpreter = *parser_vars->parser.getInterpreter<antlr4::atn::ParserATNSimulator>();
		interpreter.setPredictionMode(antlr4::atn::PredictionMode::LL);
	}

	std::unique_ptr<antlr4_parser_vars<TLexer,TParser>> parser_vars = nullptr;
	std::shared_ptr<antlr4::ANTLRErrorStrategy> bail_strat = std::make_shared<antlr4::BailErrorStrategy>();
	std::shared_ptr<antlr4::ANTLRErrorStrategy> default_strat = std::make_shared<antlr4::DefaultErrorStrategy>();
};

