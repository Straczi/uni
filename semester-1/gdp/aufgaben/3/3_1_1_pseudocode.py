#   Idee:
#   1: Größte Karte raussuchen
#   2: Stapel C auf B schieben (Größte liegt jetzt unten)
#   3: Karten 1..len gleichmäßig auf A und C verteilen
#   4: Letzte Karte auf B (größte) auf A legen
#   5: Alle Karten von Stapel C auf A schieben
#   
#   Größte Karte liegt jetzt in der Mitte



#a = [1, 2, 3, 4, 5, 8, 7, 6, 3, 9, 2, 3, 1, 45235243,4]
#a = [1, 2, 3, 4]
a = [241234, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0]
b = []
c = []

if len(a) > 0:
    b.append(a.pop())

# Größte Karte finden
while len(a) > 0:
    if b[0] < a[-1]:
        c.append(b.pop())
        b.append(a.pop())
    else:
        c.append(a.pop())

# Stapel C auf B schieben
b.extend(c)
c.clear()

flip_flop = True
while len(b) > 1:
    if flip_flop:
        a.append(b.pop())
    else:
        c.append(b.pop())
    flip_flop = not flip_flop

a.append(b.pop())
a.extend(c)
c.clear()


print(a)
print(b)
print(c)
