#include "stack_collection.h"
#include <cstdio>

void stack_collection::check_decl(const std::string& str)
{
	auto [it,succ] = get().defined_vars.insert(str);
	if (!succ) {
		get().error_decl_vars++;
#ifndef NDEBUG
		printf("Error: %s has already been declared.\n", str.c_str());
#endif
	}
}

void stack_collection::check_use(const std::string& str)
{
	auto it = get().defined_vars.find(str);
	if (it == get().defined_vars.end()) {
		get().error_undef_vars++;
#ifndef NDEBUG
		printf("Error: %s has not been defined yet.\n", str.c_str());
#endif
	}
}

void stack_collection::check_function_name(const std::string& str)
{
	if (str != "cos" && str != "sin" && str != "sqrt") {
		get().error_undef_funcs++;
#ifndef NDEBUG
		printf("Error: %s is not a valid function name.\n", str.c_str());
#endif
	}
}

void stack_collection::print_error_counts()
{
#ifndef NDEBUG
	printf("Use of undefined vars: %i\nUse of undefined functions: %i\nRedeclaration of variables: %i\n", get().error_undef_vars, get().error_undef_funcs, get().error_decl_vars);
#endif
}

void stack_collection::push()
{
	// Just copy, the overhead from this operation is high, but constant for all generated parsers.
	auto& last_child = children.back();
	stack new_child;
	new_child.defined_vars = last_child.defined_vars;
	children.push_back(new_child);
}

void stack_collection::pop()
{
	// Just copy, the overhead from this operation is high, but constant for all generated parsers.
	auto pop_child = children.back();
	children.pop_back();
	auto& last_child = children.back();
	last_child.error_decl_vars += pop_child.error_decl_vars;
	last_child.error_undef_funcs += pop_child.error_undef_funcs;
	last_child.error_undef_vars += pop_child.error_undef_vars;
}
