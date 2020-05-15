#include "time_measurement.h"
#include "base_parser.h"
#include "antlr4_parser.h"
#include "parser_chooser.h"

#define EXPR_LIST_SIZE 50

void info(const std::string& parser, const std::string& what_parse)
{
	printf("Start parsing of \"%s\" with parser %s\n", what_parse.c_str(), parser.c_str());
}

void report_time(int size_parsed, double time_it_took)
{
	printf("-----RESULTS-----\n\t> parsed size: %i\n\t> time it took: %f\n\n", size_parsed, time_it_took);
}

void save_timings(const std::string& filename, const std::string& header, const std::vector<double> timings)
{
	std::ofstream file(filename);
	file << "-" << header << "-" << std::endl;
	for (double timing : timings)
	{
		file << timing << ",";
	}
	file.close();
}

void parse_expression(std::unique_ptr<base_parser>& parser, std::vector<double>& timings_antlr4, const std::string& filename, int amount = 100)
{
	for (int i = 0; i < EXPR_LIST_SIZE; i++)
	{
		parser->reset_stream((INPUT_RES + filename) + std::to_string(i + 1) + "KB.txt");
		double time_antlr4 = timing::measure([&] { parser->parse(); }, [&] {parser->reset_state(); }, amount);
		report_time(i + 1, time_antlr4);
		timings_antlr4.push_back(time_antlr4);
	}
}

void timing::measure_expressions()
{
	auto exp_antlr4 = choose_parser(GrammarType::Expression, Generator::Antlr4);
	std::vector<double> timings_antlr4;
	
	info("Antlr4", "list of expressions");
	parse_expression(exp_antlr4, timings_antlr4, "expression_lists/expression_",1000);
	save_timings("expression_list_timings_antlr4.txt", "expression_list", timings_antlr4);

	timings_antlr4.clear();
	info("Antlr4", "deeply nested expression");
	parse_expression(exp_antlr4, timings_antlr4, "expressions/expression_",1000);
	save_timings("deeply_nested_expressions_timings_antlr4.txt", "deeply_nested_expressions", timings_antlr4);

	// Parse the big fat deeply nested expression (around 50 MB). Crashes on ANTLR4. 
	//info_bf_expr("Antlr4");
	//exp_antlr4->reset_stream(INPUT_RES "deeply_nested_expression/expression.txt");
	//double time_antlr4_bfexp = measure([&] {exp_antlr4->parse(); }, [&] {exp_antlr4->reset_state(); },1);
	//printf("Bif fat expression (around 100MB) Time it took: %f secs\n", time_antlr4_bfexp / 1000.0);
}
