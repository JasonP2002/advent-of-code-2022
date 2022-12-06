INPUT = "day-six-input.txt"
line = open(INPUT).readline()
chars = 0
c = []
m = []

def shift_c(c, x):
    print("shift")
    new_c = []
    for y in range(len(c)):
        if c[y] == x:
            for z in range (y + 1, len(c)):
                new_c.append(c[z])
    print(str(new_c))
    return new_c

for x in range(len(line)):
    print("Position: " + str(x))
    if len(c) != 4: #Find start-of-packet marker
        if c.count(line[x]) == 0:
            print("packet")
            c.append(line[x])
            print(str(c))
        else:
            c = shift_c(c, line[x])
            c.append(line[x])
        chars += 1
    elif len(m) != 14: #Find start-of-message marker
        if m.count(line[x]) == 0:
            print("message")
            m.append(line[x])
            print(str(m))
        else:
            m = shift_c(m, line[x])
            m.append(line[x])
        chars += 1
    else:
        print("FINISHED")
        print(str(c))
        print(str(m))
        print(str(chars))
        break
