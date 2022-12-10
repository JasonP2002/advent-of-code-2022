INPUT = "day-eight-input.txt"
COLUMNS = 99

def initialize_trees():
    trees = []
    zero_row = []
    for i in range(COLUMNS + 2):
        zero_row.append(0)

    trees.append(zero_row)
    for l in open(INPUT):
        current_row = []
        current_row.append(0)
        for x in l.strip():
            current_row.append(int(x))
        current_row.append(0)
        trees.append(current_row)
    trees.append(zero_row)

    return trees
trees = initialize_trees()

#Check if tree left or right is blocking
def horizontalView(x, y, trees):
    left = True
    right = True
    for z in range(0, y): #LEFT
            if (trees[x])[z] >= (trees[x][y]): ##If tree[x][y] is blocked
                left = False
                break
    for z in range(y + 1, len(trees)): #RIGHT
        if (trees[x])[z] >= (trees[x][y]): ##If tree[x][y] is blocked
                right = False
                break
    return (left or right)

#Check if tree above or below is blocking
def verticalView(x, y, trees):
    up = True
    down = True
    for z in range(0, x): #UP
            if (trees[z])[y] >= (trees[x][y]): ##If tree[x][y] is blocked
                up = False
                break
    for z in range(x + 1, len(trees)): #DOWN
        if (trees[z])[y] >= (trees[x][y]): ##If tree[x][y] is blocked
                down = False
                break
    return (up or down)

#Calculate horiztonal scenic score
def horizontalScenic(x, y, trees):
    dist_l = 0
    dist_r = 0
    for a in range(1, y): #LEFT
        if (trees[x])[a] >= (trees[x])[y]:
            dist_l = 1
        else:
            dist_l += 1
    for a in range(y + 1, len(trees[0]) - 1): #RIGHT
        dist_r += 1
        if (trees[x])[a] >= (trees[x])[y]:
            break
    return dist_l * dist_r

#Calculate vertical scenic score
def verticalScenic(x, y, trees):
    dist_u = 0
    dist_d = 0
    for a in range(1, x): #UP
        if (trees[a])[y] >= (trees[x])[y]:
            dist_u = 1
        else:
            dist_u += 1
    for a in range(x + 1, len(trees[0]) - 1): #DOWN
        dist_d += 1
        if (trees[a])[y] >= (trees[x])[y]:
            break
    return dist_u * dist_d

def partOne():
    visibleTrees = (2 * (len(trees[0]) - 2)) + (2 * (len(trees) - 4)) ##Account for edges
    for x in range(2, len(trees) - 2): ##For every row (excluding edges)
        for y in range(2, len(trees[x]) - 2): ##For every column(tree) in row (excluding edges)  
            if verticalView(x, y, trees) or horizontalView(x, y, trees) or verticalView(x, y, trees)  or horizontalView(x, y, trees):
                visibleTrees += 1
    print("Part One: " + str(visibleTrees))

def partTwo():
    scenicScores = []
    #Consider every tree
    for x in range(2, len(trees[0]) - 2):
        for y in range(2, len(trees) - 2):
            #(UP * RIGHT * DOWN * LEFT)
            scenicScores.append(horizontalScenic(x, y, trees) * verticalScenic(x, y, trees))
    print("Part Two: " + str(max(scenicScores)))

partOne()
partTwo()