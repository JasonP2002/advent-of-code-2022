INPUT = "day-eight-input.txt"

trees = []

for l in open(INPUT):
    trees.append(l.strip())
    print(l.strip())

visibleTrees = (2 * (len(trees[0]) - 2)) + (2 * (len(trees))) ##Account for edges

#Check if tree above or below is blocking
def checkRow(x, y, minBound, maxBound):
    for z in range(minBound, maxBound):
            if int((trees[z])[y]) >= int((trees[x][y])): ##If tree[x][y] is blocked
                return False
    return True

#Check if tree left or right is blocking
def checkColumn(x, y, minBound, maxBound):
    for z in range(minBound, maxBound):
            if int((trees[x])[z]) >= int((trees[x][y])): ##If tree[x][y] is blocked
                return False
    return True

for x in range(1, len(trees) - 1): ##For every row (excluding edges)
    for y in range(1, len(trees[x]) - 1): ##For every column(tree) in row (excluding edges)  
        visible = [] #[Up, Right, Down, Left]
                    
        visible.append(checkRow(x, y, 0, x)) ##Check UP
        visible.append(checkColumn(x, y, y+1, len(trees[x]))) #Check RIGHT
        visible.append(checkRow(x, y, x+1, len(trees))) ##Check DOWN
        visible.append(checkColumn(x, y, 0, y)) ##Check LEFT

        if visible[0] == True or visible[1] == True or visible[2] == True or visible[3] == True:
            visibleTrees += 1
print("Part One: " + str(visibleTrees))
