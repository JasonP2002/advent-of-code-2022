INPUT = "day-five-input.txt"
one = ["B", "G", "S", "C"]
two = ["T", "M", "W", "H", "J", "N", "V", "G"]
three = ["M", "Q", "S"]
four = ["B", "S", "L", "T", "W", "N", "M"]
five = ["J", "Z", "F", "T", "V", "G", "W", "P"]
six = ["C", "T", "B", "G", "Q", "H", "S"]
seven = ["T", "J", "P", "B", "W"]
eight = ["G", "D", "C", "Z", "F", "T", "Q", "M"]
nine = ["N", "S", "H", "B", "P", "F"]

stacks = [one, two, three, four, five, six, seven, eight, nine]

for l in open(INPUT):
    move = l.strip().split(" ")

    if (move[0] == "move"):
        for x in range(int(move[1])):
            stacks[int(move[5]) - 1].append(stacks[int(move[3]) - 1].pop())

for x in range(len(stacks)):
    print(stacks[x].pop())