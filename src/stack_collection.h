#pragma once
#include <string>
#include <unordered_set>
#include <memory>


struct stack
{
	std::unordered_set<std::string> defined_vars;
	int error_undef_vars = 0;
	int error_decl_vars = 0;
	int error_undef_funcs = 0;
};

class stack_collection
{
public:
	void check_decl(const std::string& str);
	void check_use(const std::string& str);
	void check_function_name(const std::string& str);
	void print_error_counts();
	void push();
	void pop();

private:
	std::vector<stack> children = { stack{} };
	stack& get() { return children.back(); }
};