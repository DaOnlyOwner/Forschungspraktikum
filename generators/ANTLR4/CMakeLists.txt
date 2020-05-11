project(rebuild_parser_antlr4)

set(GEN_EXPRESSIONS ${CMAKE_CURRENT_SOURCE_DIR}/generated/expressions/antlr4)

if(NOT EXISTS ${GEN_EXPRESSIONS})
	set(CMD java -jar ${CMAKE_CURRENT_SOURCE_DIR}/antlr-4.8-complete.jar 
		-Dlanguage=Cpp
		-o ${GEN_EXPRESSIONS}
		${CMAKE_CURRENT_SOURCE_DIR}/grammar/expressions/expressions.g4)

	execute_process(COMMAND ${CMD} RESULT_VARIABLE res)
	if(NOT EQUAL(${res},0))
		message(FATAL_ERROR "generation of antlr4 expression grammar failed")
	endif()
endif()

file(GLOB_RECURSE generated_source "generated/*.cpp")

set(ANTLR4_GEN_SRC ${generated_source} PARENT_SCOPE)
set(ANTLR4_GEN_INC files( "${CMAKE_CURRENT_SOURCE_DIR}/runtime/include" "${CMAKE_CURRENT_SOURCE_DIR}/generated") PARENT_SCOPE)

add_custom_target(rebuild_parser_antlr4)