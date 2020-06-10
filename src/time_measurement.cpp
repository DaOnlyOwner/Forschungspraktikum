#include "time_measurement.h"
#include "base_parser.h"
#include "antlr4_parser.h"
#include "parser_chooser.h"
#include <cstdio>

#define EXPR_LIST_SIZE 50

void info(const std::string& parser, const std::string& what_parse)
{
	printf("Start parsing of \"%s\" with parser %s\n", what_parse.c_str(), parser.c_str());
}

void report_time(int size_parsed, double time_it_took)
{
	printf("-----RESULTS-----\n\t> parsed size: %i\n\t> time it took: %f\n\n", size_parsed, time_it_took);
}

void save_timings(const std::string& filename, const std::string& parser_name, const std::string& parsed_grammar, const std::vector<double>& timings, int x_start, int x_end)
{
	std::ofstream file(filename);
	file << "-" << parser_name << "," << parsed_grammar << "-" << std::endl;
	file << x_start << "," << x_end << std::endl;
	for (double timing : timings)
	{
		file << timing << ",";
	}
	file.close();
}

void parse_file(
	std::unique_ptr<base_parser>& parser,
	std::vector<double>& timings,
	const std::string& filename,
	int sample_amount = 100,
	int file_start = 1,
	int file_end = 50,
	startup_info info = { false,true })
{
	for (int i = file_start; i <= file_end; i++)
	{
		parser->reset_stream((INPUT_RES + filename) + std::to_string(i) + "KB.txt");
		double time = timing::measure([&] { parser->parse(info); }, [&] {parser->reset_state(); }, sample_amount);
		report_time(i, time);
		timings.push_back(time);
	}
}

void timing::measure_expressions()
{
	auto exp_antlr4 = choose_parser(GrammarType::Expression, Generator::Antlr4);
	std::vector<double> timings_antlr4;
	
	info("Antlr4", "list of expressions");
	parse_file(exp_antlr4, timings_antlr4, "expression_lists/expression_",100);
	save_timings(OUTPUT_RES "expression_list_timings_antlr4.txt", "antlr4", "expression_list", timings_antlr4, 1,50);

	timings_antlr4.clear();
	info("Antlr4", "deeply nested expression");
	parse_file(exp_antlr4, timings_antlr4, "expressions/expression_", 100);
	save_timings(OUTPUT_RES "deeply_nested_expressions_timings_antlr4.txt", "antlr4", "deeply_nested_expressions", timings_antlr4,1,50);

	// Parse the big fat deeply nested expression (around 50 MB). Crashes on ANTLR4 due to stackoverflow
	//info_bf_expr("Antlr4");
	//exp_antlr4->reset_stream(INPUT_RES "deeply_nested_expression/expression.txt");
	//double time_antlr4_bfexp = measure([&] {exp_antlr4->parse(); }, [&] {exp_antlr4->reset_state(); },1);
	//printf("Bif fat expression (around 100MB) Time it took: %f secs\n", time_antlr4_bfexp / 1000.0);
}

void timing::measure_semantic_actions()
{
	auto semantic_actions_antlr4 = choose_parser(GrammarType::SemanticActions, Generator::Antlr4);
	std::vector<double> timings_antlr4;
	info("Antlr4", "semantic actions");

	parse_file(semantic_actions_antlr4, timings_antlr4, "semantic_actions/semantic_actions_",100,1,1);
	save_timings(OUTPUT_RES "semantic_actions_antlr4.txt", "antlr4", "semantic_actions", timings_antlr4, 1, 1);
}


void timing::measure_ebnf()
{
	auto ebnf_antlr4 = choose_parser(GrammarType::EBNF, Generator::Antlr4);
	std::vector<double> timings_antlr4;
	info("Antlr4", "Ebnf and generating an abstract syntax tree");

	parse_file(ebnf_antlr4, timings_antlr4,"ebnf/ebnf_", 1, 500, 550, { true,true });
	save_timings(OUTPUT_RES "ebnf_antlr4.txt", "antlr4", "ebnf", timings_antlr4, 500,550);
}