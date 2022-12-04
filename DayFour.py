INPUT = "day-four-input.txt"  
pairs = 0

for l in open(INPUT):
    pair = l.strip().split(",")
    one = pair[0].split("-")
    two = pair[1].split("-")

    one_one = int(one[0])
    one_two = int(one[1])
    two_one = int(two[0])
    two_two = int(two[1])
    if (two_one <= one_one <= two_two) or (two_one <= one_two <= two_two) or (one_one <= two_one <= one_two) or (one_one <= two_two <= one_two):
        pairs += 1

print(str(pairs))