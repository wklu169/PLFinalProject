class calculator(object):
    def f(self):
        operations = {
            'add': lambda x, y: x+y,
            'sub': lambda x, y: x-y,
            'mul': lambda x, y: x*y,
            'div': lambda x, y: x/y
        }
        def cf(self, op):
            if op in operations:
                return operations[op]
            else:
                return None
        return cf
    run = f(0)

import math

class scientific_calculator(calculator):
    #def run(self, a): return super(animal, self).run(a)
    def f(self):
        operations = {
            'sin' : lambda x: math.sin(x),
            'cos' : lambda x: math.cos(x),
            'tan' : lambda x: math.tan(x),
            'pow' : lambda x,y: x**y
        }
        def cf(self, op):
            if op in operations:
                return operations[op]
            else:
                return super(scientific_calculator, self).run(op)
        return cf
    run = f(1)

# c1 = calculator()
# print(c1.run("add")(1, 2))
#
# c2 = scientific_calculator()
# print (c2.run("cos")(math.pi))
# print(c2.run("div")(144, 12))