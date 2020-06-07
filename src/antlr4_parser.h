#pragma once
#include "base_parser.h"
#include <string>
#include <istream>
#include "antlr4-runtime.h"
#include <stdio.h>
#include <cassert>
#include <memory>
#include "ebnf_antlr4_ast_gen.h"

template<typename TLexer, typename TParser>
struct antlr4_parser_vars
{
	antlr4_parser_vars(const std::string& filename) : stream(filename), input(stream), lexer(&input), token_stream(&lexer), parser(&token_stream)
	{
		if (!stream.good()) 
			throw std::runtime_error("Bad filename: " + filename);
		
	}

	~antlr4_parser_vars()
	{
		stream.close();
	}

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
	antlr4_parser(std::unique_ptr<antlr4::tree::ParseTreeVisitor>&& visitor_) { visitor = std::move(visitor_); }
	virtual bool parse(const startup_info& info) override
	{
		assert(parser_vars != nullptr);
		auto& interpreter = *parser_vars->parser.template getInterpreter<antlr4::atn::ParserATNSimulator>();
		auto prediction_mode = info.use_fast_algorithm ? antlr4::atn::PredictionMode::SLL : antlr4::atn::PredictionMode::LL;
		interpreter.setPredictionMode(prediction_mode);
		parser_vars->parser.setErrorHandler(bail_strat);
		parser_vars->parser.setBuildParseTree(info.build_ast);

		try {
			auto tree = parser_vars->parser.start();  // SLL
			if (info.build_ast) build_ast(tree);
			return true;
		}

		catch (antlr4::ParseCancellationException& ex) {
			try
			{
#ifndef NDEBUG
				printf("Input triggered non SLL(k) alternative in grammar \"%s\". Switching to ALL(*).\n", parser_vars->parser.getGrammarFileName().c_str());
#endif
				reset_state_inner();
				auto tree = parser_vars->parser.start();
				if (info.build_ast) build_ast(tree);
				return true;
			}
			catch (std::exception& ex)
			{
				return false;
			}
		}
		return false;
	}

	virtual void reset_stream(const std::string& filename) override
	{
		this->filename = filename;
		parser_vars = std::make_unique<antlr4_parser_vars<TLexer, TParser>>(filename);
	}

	virtual void reset_state() override
	{
		reset_state_inner();
	}
	
private:
	void reset_state_inner()
	{
		
		parser_vars = std::make_unique<antlr4_parser_vars<TLexer, TParser>>(filename);
		//parser_vars->parser.setBuildParseTree(false);
		//parser_vars->parser.setErrorHandler(default_strat);
		//parser_vars->token_stream.reset();
		//parser_vars->parser.reset();
		//auto& interpreter = *parser_vars->parser.template getInterpreter<antlr4::atn::ParserATNSimulator>();
		//interpreter.setPredictionMode(antlr4::atn::PredictionMode::LL);
	}

	void build_ast(typename TParser::StartContext* tree)
	{
		tree->accept(visitor.get());
		//delete tree;
	}

	std::string filename;

	std::unique_ptr<antlr4_parser_vars<TLexer,TParser>> parser_vars = nullptr;
	std::shared_ptr<antlr4::ANTLRErrorStrategy> bail_strat = std::make_shared<antlr4::BailErrorStrategy>();
	std::shared_ptr<antlr4::ANTLRErrorStrategy> default_strat = std::make_shared<antlr4::DefaultErrorStrategy>();

	std::unique_ptr<antlr4::tree::ParseTreeVisitor> visitor;
};

