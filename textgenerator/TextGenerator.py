import lark
import logging
import sys
from functools import reduce
import itertools
import os
import random 
from collections import deque 


spec_grammar = r"""
%import common.WS
%import common.NUMBER
%import common.WORD
%import common.ESCAPED_STRING
%ignore WS
%ignore COMMENT
_STRING_INNER2: /.*?/
_STRING_ESC_INNER2: _STRING_INNER2 /(?<!\\)(\\\\)*?/ 
ESCAPED_STRING2 : "'" _STRING_ESC_INNER2 "'"
RULE_NAME : WORD ("_" WORD)*
COMMENT : "-" /[^\n]/*
FLOAT : NUMBER ("." NUMBER)?
OP : "+" | "*" | "?"
IDENT : RULE_NAME | ESCAPED_STRING | ESCAPED_STRING2 
start : rule*
rule: RULE_NAME ":" rule_expr ";"
weights_branch : "#" FLOAT ("," FLOAT)?
weights_post : "##" FLOAT ("," FLOAT)?
?rule_expr : alt_expr
?alt_expr : concat_expr weights_branch? ("|" concat_expr weights_branch?)*
?concat_expr : postfix_expr+
?postfix_expr : postfix_expr OP weights_post? | primary 
?paren_expr : "(" rule_expr ")"
primary: IDENT | paren_expr
"""

def print_error_full(line,col,msg):
    error = f"====================\nError in line {line}, column {col}:\n> {msg}\n====================\n"
    sys.stderr.write(error)

def print_error(line,msg):
    error = f"====================\nError in line {line}:\n> {msg}\n====================\n"
    sys.stderr.write(error)

def print_warning_full(line,col,msg):
    error = f"====================\nWarning in line {line}, column {col}:\n> {msg}\n====================\n"
    sys.stderr.write(error)

def print_warning(line,msg):
    error = f"====================\nWarning in line {line}:\n> {msg}\n====================\n"
    sys.stderr.write(error)



class Expr(object):
    def __init__(self):
        self.is_parenthesised = False

class ConcatExpr(Expr):
    def __init__(self,exprs):
        super().__init__()
        self.exprs = exprs
    
    def accept(self,visitor):
        return visitor.concat_expr(self)


class AltExpr(Expr):
    def __init__(self,exprs_weight):
        super().__init__()
        self.exprs,weights_factors = map(list,zip(*exprs_weight))
        self.weights,self.factors = map(list,zip(*weights_factors))

    def accept(self,visitor):
        return visitor.alt_expr(self)

    def update_weight(self,chosen_index):
        weight = self.weights[chosen_index]
        factor = self.factors[chosen_index]
        return factor * weight
        
    def choose(self):
        choice_index = random.choices(range(len(self.weights)),self.weights)[0]
        new_weights = self.weights.copy()
        updated_weight = self.update_weight(choice_index)
        new_weights[choice_index] = updated_weight
        #print("From: ",self, "Old_weights: ", self.weights, "New Weights", new_weights)
        return new_weights,self.exprs[choice_index]

    
class PostfixExpr(Expr):
    def __init__(self,lh,op,weight):
        super().__init__()
        self.lh = lh
        self.op = op
        self.weights,self.factor = weight

    def accept(self,visitor):
        return visitor.postfix_expr(self)
        
    def choose(self,visitor): 
        if self.op == '+':
            self.lh.accept(visitor) # Guarantee one evauluation

        local_weight = self.weights
        local_weights = [local_weight, 1]
        population = [1,0] # 1 == loop, 0 == exit
        chosen = random.choices(population,local_weights)[0]

        if self.op == '?' and chosen == 1:
            self.lh.accept(visitor) # Only one iteration
            return

        while chosen == 1:
            self.lh.accept(visitor)
            chosen = random.choices(population,local_weights)[0]
            local_weight *= self.factor
            local_weights = [local_weight, 1]

        
class RuleExpr(Expr):
    def __init__(self, name, rule_registry,line,col):
        super().__init__()
        self.name = name
        self.rule_ref = rule_registry.declare(self.name,line,col)
        
    def accept(self,visitor):
        return visitor.nonterminal_expr(self)

    def __repr__(self):
        return self.name

    
class TerminalExpr(Expr):
    def __init__(self,text):
        super().__init__()
        self.text = text

    def accept(self,visitor):
        return visitor.terminal_expr(self)


class Rule:
    def __init__(self, name,col,line):
        self.name = name
        self.col = col
        self.line = line
        self.exprs = None
        
    def __repr__(self):
        return self.name

    @classmethod
    def from_definition(cls,name,exprs, col,line):
        out = cls(name,line,col)
        out.exprs = exprs
        return out

    @classmethod
    def from_decl(cls,name,line,col):
        out = cls(name,line,col)
        return out

    def is_defined(self):
        return self.exprs != None
    
    def define(self,col,line,exprs):
        self.col = col
        self.line = line
        self.exprs = exprs

class RuleList:
    def __init__(self):
        self.rules = dict()

    def declare(self,name,line,col):
        if name not in self.rules:
            out = Rule.from_decl(name,line,col)
            self.rules[name] = out
            return out
        return self.rules[name]

    def define(self,name, line, col, exprs):
        if name not in self.rules:
            out = Rule.from_definition(name, exprs, line, col)
            self.rules[name] = out
            return out
        out = self.rules[name]
        if(out.is_defined()):
            print_error_full(line,col,"Redefinition of rule "+name)
            return None

        out.define(col,line,exprs)
        return out

    def print_error_on_undefined_rules(self):
        succ = True
        for rule in self.rules.values():
            if not rule.is_defined():
                print_error_full(rule.line,rule.col,f'The rule "{rule.name}" is used, but never defined')
                succ = False
        
        return succ


class MakeAst(lark.Transformer):
    def __init__(self,std_factor):
        self.rule_list = RuleList()
        self.has_errors = False
        self.current_line = 0
        self.current_col = 0
        self.std_factor = std_factor
        
    def start(self,items):
        return items

    def general_rule(self,items):
        return items
    
    def rule(self,items):
        succ = self.rule_list.define(str(items[0]), items[0].line, items[0].column, items[1])        
        if succ == None:
            self.has_errors = True
        return items

    def weights_branch(self,items):
        weight,factor,_ = self.weights(items)
        return(weight,factor)

    def weights_post(self,items):
        weight,factor,_ = self.weights(items)
        return (weight,factor) 

    def weights(self,items):
        weight = float(items[0])
    
        if len(items) == 2:
            factor = float(items[1])
            if factor >= 1:
                print_error_full(items[1].line,items[1].column,f"The decrease factor of {factor} surpasses 1. Thus the weights increase instead of decrease, potentially leading to a memoryoverflow.")
                self.has_errors = True
        else: factor = float(self.std_factor)
    
        return (weight,factor,items[0])        
    
    def alt_expr(self,items):
        exprs_weights = []
        count_of_given_weights = 0
        for i in items:
            if type(i) is tuple:
                new_weight,new_factor = i
                expr,_ = exprs_weights[-1]
                exprs_weights[-1] = expr,(new_weight,new_factor)
                count_of_given_weights += 1
            else:
                exprs_weights.append((i,(100,self.std_factor)))

        if count_of_given_weights > 0:
            if count_of_given_weights != len(exprs_weights):    
                print_warning(self.current_line,f"At least one alternative branch has no specified weight, while other alternative branches do.")
        aexpr = AltExpr(exprs_weights)
        return aexpr

    def concat_expr(self,items):
        cexpr = ConcatExpr(items)
        return cexpr
        
    def postfix_expr(self,items):
        if(len(items) == 3):
            pexpr = PostfixExpr(items[0],items[1],items[2])
        else:
            pexpr = PostfixExpr(items[0],items[1],(100,self.std_factor))
        return pexpr
    
    def primary(self,items):
        if type(items[0]) is lark.Token:
            self.current_line = items[0].line
            self.current_col = items[0].column
            txt = str(items[0])
            if txt.startswith('"'):
                return TerminalExpr(txt[1:-1].replace("\\n",os.linesep).replace("\\",""))
            elif txt.startswith("'"):
                return TerminalExpr(txt[1:-1].replace("\\n",os.linesep).replace("\\","") + " ")
            return RuleExpr(txt,self.rule_list,items[0].line,items[0].column)
        items[0].parenthesised = True # ( expr )
        return items[0]

def adapt_weights(items):
    for expr,weights in items:
        #print("Adapted weights of '",expr,"' from", expr.weights, "to ", weights) 
        expr.weights = weights
        
def id_weights(exprs):
    out = []
    for expr in exprs:
        out.append((expr,expr.weights.copy()))
    return out    

class GenerateText():
    def __init__(self,rule_list, start_rule):
        self.rule_list = rule_list
        self.index = 0
        self.weight_map = dict() 
        self.derived = [(start_rule,self.weight_map)]
        self.first_nonterminal = 0

    def start(self):
        while self.first_nonterminal >= 0: # A nonterminal exists in derived.
            #print(print(self.derived)
            rule_to_process,weight_map = self.derived[self.first_nonterminal]
            del self.derived[self.first_nonterminal]
            self.index = self.first_nonterminal
            revert_weight_map = id_weights(weight_map.keys())
            #print("Weightmap for rule ", rule_to_process.name, ":", weight_map)
            adapt_weights(weight_map.items())
            self.weight_map = weight_map
            rule_to_process.exprs.accept(self)
            self.first_nonterminal = self.find_next_nonterminal()
            self.weight_map = dict()
            adapt_weights(revert_weight_map) # Revert the changes.

        return "".join(self.derived)

    def find_next_nonterminal(self):
        #print(self.derived)
        for index,i in enumerate(self.derived[self.first_nonterminal:]):
            if type(i) != str:
                return self.first_nonterminal + index
        return -1
    
    def alt_expr(self,ae):
        old_weight_map = self.weight_map.copy()
        self.weight_map[ae],chosen_rule = ae.choose()
        chosen_rule.accept(self)
        self.weight_map = old_weight_map.copy()

    def postfix_expr(self,pe):
        pe.choose(self)


    def concat_expr(self,ce):
        for expr in ce.exprs:
            expr.accept(self)


    def nonterminal_expr(self,nt):
        rule = nt.rule_ref
        self.derived.insert(self.index,(rule,self.weight_map.copy()))
        self.index += 1

    def terminal_expr(self,t):
        self.derived.insert(self.index,t.text)
        self.index += 1

def read_in(filename):
    f_str = ""
    try:
        with open(filename, "r") as f:
            f_str = f.read()
    except OSError as e:
        raise e
    return f_str

def write_file(txt,filename):
    try:
        f = open(filename, "w")
        f.write(txt)
    except OSError as e:
        raise e
    finally:
        f.close()


def gen_parse_result(grammar_filename):
    grammar_def = ""
    try:
        grammar_def = read_in(grammar_filename)
    except OSError as oe:
        sys.stderr.write(f"Error: An error occured when opening a file: {oe}")
        return None
    parser = lark.Lark(spec_grammar, parser = 'lalr', debug=False)
    res = parser.parse(grammar_def)
    return res

def start_textgen(parse_result, std_factor):
    # 1: GENERATE AST
    astMaker = MakeAst(std_factor)
    # Do better error handling later.
    try:
        astMaker.transform(parse_result)
    except ValueError as e:
        return None

    r = astMaker.rule_list
    if not r.print_error_on_undefined_rules():
        return None

    if(astMaker.has_errors): return    
    rule_list = list(r.rules.values())
    
    start_rule = r.rules.get("start")
    if start_rule == None:
        print_error_full(0,0,"No rule named 'start' defined (which is where the generating starts off)")
        return None
    textGen = GenerateText(rule_list,start_rule)
    txt = textGen.start()
    return txt


def main():
    if len(sys.argv) < 4:
        sys.stderr.write(f"Error: not enough input from commandline")
        return -1
    elif len(sys.argv) > 4:
        sys.stderr.write(f"Error: too much input from commandline")
        return -1       

    filenameIn =  sys.argv[1]
    filenameOut = sys.argv[2]
    std_factor = float(sys.argv[3])
    
    res = gen_parse_result(filenameIn)    
    if res == None: return -1
    txt = start_textgen(res,std_factor)
    if txt == None: return -1
    try:
        write_file(txt,filenameOut)
    except OSError as e:
        sys.stderr.write(f"Error: An error occured when writing to a file: {e}")
        return -1
    print(f"{len(txt)} bytes ({len(txt) / 1000}KB) have been written to", filenameOut)
    return 0

if __name__ == "__main__":
    main()





































    
