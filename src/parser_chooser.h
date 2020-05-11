#pragma once
#include <memory>
#include <string>
#include "base_parser.h"

enum class GrammarType
{
	Expression
};

enum class Generator
{
	Antlr4
};

std::unique_ptr<base_parser> choose_parser(GrammarType grammar, Generator generator);

