#pragma once
#include <string>

struct startup_info
{
	bool build_ast;
	bool use_fast_algorithm; // i.e. LR vs. GLR in Bison or LL(*) vs SLL(*) in Antlr4.
};

class base_parser
{
public:
	virtual bool parse(const startup_info& info) = 0;
	virtual void reset_stream(const std::string& filename) = 0;
	virtual void reset_state() = 0;
	virtual ~base_parser() {};
};