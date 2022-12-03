INPUT = "day-three-input.txt"
priority_sum = 0
found = False

for line in open(INPUT):
    found = False
    arr = [char for char in line]
    for x in range(len(arr)//2):
        if (found == False):
            for y in range(len(arr)//2, len(arr)):

                if (arr[x] == arr[y]):
                    found = True
                    if (arr[x].isupper()):
                        priority_sum += (ord(arr[x]) - 38)
                    else:
                        priority_sum += (ord(arr[x]) - 96)
                    break
        else:
            break

print(priority_sum)