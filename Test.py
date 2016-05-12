class calculator(object):
    def arithmetic(self):
        operations = {
            'add': lambda x, y: x+y,
            'sub': lambda x, y: x-y,
            'mul': lambda x, y: x*y,
            'div': lambda x, y: x/y
            }
        def calculate(self, op):
            if op in operations:
                return operations[op]
            else:
                return None
        return calculate
    run = arithmetic(1)
    
c1 = calculator()
print(c1.run('add')(1, 2))


import math
class scientific_calculator(calculator):
    
    def arithmetic(self):
        operations = {
            'sin' : lambda x: math.sin(x),
            'cos' : lambda x: math.cos(x),
            'tan' : lambda x: math.tan(x),
            'pow' : lambda x,y: x**y
            }
        def calculate(self, op):
            if op in operations:
                return operations[op]
            else:
                return super(calculator,self).run(op)
        return calculate
    run = arithmetic(1)

c2 = scientific_calculator()
print (c2.run('sin')(55))

