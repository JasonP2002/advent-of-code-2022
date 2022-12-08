INPUT = "day-seven-input.txt"

class Tree:
    def __init__(self):
        self.parent = None
        self.name = None
        self.size = None
        self.childs = []

def print_tree(t):
    print(str(t.name) + " - " + str(t.size))
    for x in len(t.childs):
        print("CHILD OF " + str(t.name))
        print_tree(t.childs[x])

currentNode = Tree()
currentNode.name = "/"
currentNode.size = 0


#Create tree structure
for l in open(INPUT):
    x = l.strip().split(" ")

    if len(x) == 3: #Change directory
        dir = str(x[2])
        if dir == "/": #To outermost dir
            while (currentNode.parent != None):
                currentNode = currentNode.parent
        elif dir == "..": #To parent dir
            currentNode = currentNode.parent
        else: #To child dir
            for t in range(len(currentNode.childs)):
                if (str(currentNode.childs[t].name) == dir):
                    currentNode = currentNode.childs[t]
    else: #ls output
        if x[0] != "$":
            newNode = Tree()
            newNode.parent = currentNode
            newNode.name = x[1]
            if (x[0] != "dir"):
                newNode.size = int(x[0])
            else:
                newNode.size = 0
            currentNode.childs.append(newNode)

while (currentNode.parent != None):
    currentNode = currentNode.parent
print_tree(currentNode)
#Use tree structure
