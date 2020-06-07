cmake_minimum_required(VERSION 3.8)
project(parser_gen_comparsion LANGUAGES CXX C)
set_property(GLOBAL PROPERTY USE_FOLDERS ON)
set_property(DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR} PROPERTY VS_STARTUP_PROJECT parser_gen_comparsion)
file(GLOB_RECURSE FILES "src/*.cpp" "src/*.h")
set(CMAKE_WINDOWS_EXPORT_ALL_SYMBOLS ON)
set (CMAKE_LIBRARY_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR})
set (CMAKE_RUNTIME_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR})

# Antlr4
add_subdirectory(generators/ANTLR4) # Add the generated stuff.
add_subdirectory(generators/ANTLR4/runtime) # Add the runtime.

# Build the executable
add_executable(parser_gen_comparsion ${FILES} ${ANTLR4_GEN_SRC})
set_target_properties(parser_gen_comparsion PROPERTIES CXX_EXTENSIONS OFF)
target_compile_features(parser_gen_comparsion PUBLIC cxx_std_17)
target_compile_definitions(parser_gen_comparsion PUBLIC INPUT_RES=\"${CMAKE_SOURCE_DIR}/textgenerator/\")
target_compile_definitions(parser_gen_comparsion PUBLIC OUTPUT_RES=\"${CMAKE_SOURCE_DIR}/timings/\")

#Link to the runtime libraries:
target_link_libraries(parser_gen_comparsion PRIVATE antlr4_shared)

source_group("Antlr4_Generated" FILES ${ANTLR4_GEN_SRC})
source_group("Main" FILES ${FILES})

#Includes
target_include_directories(parser_gen_comparsion PUBLIC ${ANTLR4_GEN_INC})