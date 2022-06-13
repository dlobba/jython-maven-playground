from it.dlobba.mavenjython import StringConcatenator

def main():
    sc = StringConcatenator()
    print(sc.concat(*list("awesome".upper()) + [0.5, 1.2e-2, 42]))

