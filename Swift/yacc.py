import ply.yacc as yacc

# Get the token map from the lexer.  This is required.
from lex import tokens

# BNF

def p_strdeclaration(p):
    '''declaration : LET VAR "=" QUOTETEXT
                   | LET VAR "=" SQUOTETEXT
    '''
    p[0] = [p[1], p[2], p[4]]

def p_declaration(p):
    'declaration : LET VAR "=" expression'
    p[0] = [p[1], p[2], p[4]]

def p_math(p):
    ''' expression : expression "+" expression
                   | expression "-" expression
                   | expression "*" expression
                   | expression "/" expression
    '''
    p[0] = [p[2], p[1], p[3]]

def p_expression(p):
    '''expression : num
                  | VAR
    '''
    p[0] = p[1]

def p_num(p):
    '''num : INTEGER
           | float
    '''
    if type(p[1]) == float:
        p[0] = float(p[1])
    else:
        p[0] = int(p[1])

def p_float(p):
    'float : INTEGER "." INTEGER'
    p[0] = float(str(p[1]) + str(p[2]) + str(p[3]))

def p_empty(p):
    'empty : '
    pass

# Error rule for syntax errors
def p_error(p):
    print "Syntax error!! ",p

# Build the parser
# Use this if you want to build the parser using SLR instead of LALR
# yacc.yacc(method="SLR")
yacc.yacc()


