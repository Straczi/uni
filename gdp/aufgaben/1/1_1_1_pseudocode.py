#!/bin/python3

def wurzel(a):
    x = a / 2

    while True:
        z = (a / x + x) / 2
        d = (z - x) * (z - x)
        
        if d < 0.000_000_1:
            break
        
        x = z

    return x


a = input("Number a: ")
a = int(a)
print(wurzel(a))

