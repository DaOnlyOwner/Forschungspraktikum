
set(GEN_EXPRESSIONS ${CMAKE_CURRENT_SOURCE_DIR}/generated/expressions/antlr4)
set(GEN_EBNF ${CMAKE_CURRENT_SOURCE_DIR}/generated/ebnf/antlr4)
set(GEN_SEM_ACT ${CMAKE_CURRENT_SOURCE_DIR}/generated/semantic_actions/antlr4)

function(generate_parser where_to_put where_to_find)
if(NOT EXISTS ${where_to_put})
	set(CMD java -jar ${CMAKE_CURRENT_SOURCE_DIR}/antlr-4.8-complete.jar 
		-Dlanguage=Cpp
		-no-listener
		-visitor
		-o ${where_to_put}
		${where_to_find})

	execute_process(COMMAND ${CMD} RESULT_VARIABLE res)
	if(NOT EQUAL(${res},0))
		message(FATAL_ERROR "generation of antlr4 ${where_to_find} grammar failed")
	endif()
endif()
endfunction()


generate_parser(${GEN_EXPRESSIONS} ${CMAKE_CURRENT_SOURCE_DIR}/grammar/expressions/expressions.g4)
generate_parser(${GEN_EBNF} ${CMAKE_CURRENT_SOURCE_DIR}/grammar/ebnf/ebnf.g4)
generate_parser(${GEN_SEM_ACT} ${CMAKE_CURRENT_SOURCE_DIR}/grammar/semantic_actions/semantic_actions.g4)

file(GLOB_RECURSE generated_source "generated/*.cpp")

set(ANTLR4_GEN_SRC ${generated_source} PARENT_SCOPE)
set(ANTLR4_GEN_INC files( "${CMAKE_CURRENT_SOURCE_DIR}/runtime/include" "${CMAKE_CURRENT_SOURCE_DIR}/generated") PARENT_SCOPE)
