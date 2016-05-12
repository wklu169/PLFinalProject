#------------------------------------------------------------
# lex.py
#
# tokenizer
# ------------------------------------------------------------

import ply.lex as lex

# List of token names
tokens = ('LET', 'QUOTETEXT', 'SQUOTETEXT', 'INTEGER', 'VAR')

literals = ['=', '+', '/', '*', '-', '(', ')', '.']

# Reserved words
reserved = ['LET']

# Regular expression rules for simple tokens
t_QUOTETEXT = r'\".*?\"'
t_SQUOTETEXT = r'\'.*?\''


def t_INTEGER(t):
    r'\d+'
    try:
        t.value = int(t.value)    
    except ValueError:
        print "Line %d: Number %s is too large!" % (t.lineno,t.value)
        t.value = 0
    return t

def t_VAR(t):
    r'[A-Za-z_][A-Za-z0-9_]*'
    if t.value.upper() in reserved:
        t.type = t.value.upper()
    return t

# Define a rule so we can track line numbers
def t_newline(t):
    r'\n+'
    t.lexer.lineno += len(t.value)

# A string containing ignored characters (spaces and tabs)
t_ignore  = ' \t'

# Error handling rule
def t_error(t):
    print "Illegal character '%s'" % t.value[0]
    t.lexer.skip(1)

# Build the lexer
lex.lex()

if __name__ == '__main__':
    lex.runmain()
