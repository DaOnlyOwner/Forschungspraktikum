#pragma once
#include <string>

class base_parser
{
public:
	virtual void* parse() = 0;
	virtual void reset_stream(const std::string& filename) = 0;
	virtual void reset_state() = 0;
	virtual ~base_parser() {};
};