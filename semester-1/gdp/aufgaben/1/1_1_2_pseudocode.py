#!/bin/python3
import random


#a = random.sample(range(0, 1000), 10) 
a = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5, 4, 3, 2, 1]
b = []
c = [a.pop(0)]

for i in range(0, len(a)):
    if c[0] < a[-1]:
        # Move the card on C ontop of B
        b.append(c[0])
        # Move the card ontop of A to C
        c[0] = a.pop()

print(c[0])
