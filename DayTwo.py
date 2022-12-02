INPUT = "day-two-input.txt"
LOSE_SCORE = 0
DRAW_SCORE = 3
WIN_SCORE = 6
ROCK_SCORE = 1
PAPER_SCORE = 2
SCISSORS_SCORE = 3
score = 0

for line in open(INPUT):
    round = line.split(" ")
    round[1] = round[1].replace('\n', '')
    if round[0] == "A":
    
        if round[1] == "X":
            score += (LOSE_SCORE + SCISSORS_SCORE)
        elif round[1] == "Y":
            score += (DRAW_SCORE + ROCK_SCORE)
        elif round[1] == "Z":
            score += (WIN_SCORE + PAPER_SCORE)

    elif round[0] == "B":

        if round[1] == "X":
            score += (LOSE_SCORE + ROCK_SCORE)
        elif round[1] == "Y":
            score += (DRAW_SCORE + PAPER_SCORE)
        elif round[1] == "Z":
            score += (WIN_SCORE + SCISSORS_SCORE)

    elif round[0] == "C":

        if round[1] == "X":
            score += (LOSE_SCORE + PAPER_SCORE)
        elif round[1] == "Y":
            score += (DRAW_SCORE + SCISSORS_SCORE)
        elif round[1] == "Z":
            score += (WIN_SCORE + ROCK_SCORE)
    
print(score)
