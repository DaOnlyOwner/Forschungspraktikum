#include "time_measurement.h"
#include "base_parser.h"
#include "antlr4_parser.h"
#include "parser_chooser.h"

#define EXPR_LIST_SIZE 50

void timing::measure_expressions()
{
	auto exp_antlr4 = choose_parser(GrammarType::Expression, Generator::Antlr4);
	
	for (int i = 0; i < EXPR_LIST_SIZE; i++)
	{
		exp_antlr4->reset_stream((EXPR_RES "expression_") + std::to_string(i + 1) + "KB.txt");
		double time_antlr4 = measure([&] { exp_antlr4->parse(); }, [&] {exp_antlr4->reset_state(); });

		printf("Size parsed: %iKB, Time it took: %f\n", i+1, time_antlr4);

	}

}
