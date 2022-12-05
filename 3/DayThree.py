INPUT = "day-three-input.txt"
priority_sum = 0
i = 0

elfone = ""
elftwo = ""
elfthree = ""

lines = open(INPUT).readlines()

while i < len(lines):
    elfone = [char for char in lines[i]]
    elftwo = [char for char in lines[i+1]]
    elfthree = [char for char in lines[i+2]]

    elfone.remove('\n')
    elftwo.remove('\n')
    if(elfthree[len(elfthree)-1] == '\n'):
        elfthree.remove('\n')
    
    i = i + 3
    found = False
    for x in range(len(elfone)):

        if  (found != True):
            for y in range(len(elftwo)):

                if (found != True):
                    if (elfone[x] == elftwo[y]):
                        for z in range(len(elfthree)):

                            if (elfone[x] == elfthree[z]):
                                if (elfone[x].isupper()):
                                    priority_sum += (ord(elfone[x]) - 38)
                                else:
                                    priority_sum += (ord(elfone[x]) - 96)
                                found = True
                                break

print(priority_sum)
