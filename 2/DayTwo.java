import java.io.FileReader;
import java.io.BufferedReader;

public class DayTwo {
    
    final static String INPUT = "day-two-input.txt";
    static int totalScore = 0;
    static String[] round;

    static final int WIN_SCORE = 6;
    static final int LOSE_SCORE = 0;
    static final int DRAW_SCORE = 3;

    static final int ROCK_SCORE = 1;
    static final int PAPER_SCORE = 2;
    static final int SCISSORS_SCORE = 3;

    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader(INPUT);
            BufferedReader br = new BufferedReader(fr);
            String currentLine;
            
            while ((currentLine = br.readLine()) != null) {
                round = currentLine.split(" ");

                switch (round[0]) {
                    case "A":
                        switch (round[1]) {
	            	        case "X":
	            	            totalScore += (LOSE_SCORE + SCISSORS_SCORE);
	            	            break;
	            	        case "Y":
	            	            totalScore += (DRAW_SCORE + ROCK_SCORE);
	            	            break;
	            	        default:
	            	            totalScore += (WIN_SCORE + PAPER_SCORE);
                        }

                        
                        break;
                    case "B":
                        switch (round[1]) {
	            	        case "X":
	            	            totalScore += (LOSE_SCORE + ROCK_SCORE);
	            	            break;
	            	        case "Y":
	            	            totalScore += (DRAW_SCORE + PAPER_SCORE);
	            	            break;
	            	        default:
	            	            totalScore += (WIN_SCORE + SCISSORS_SCORE);
                	}

                        break;
                    default:
                        switch (round[1]) {
	            	        case "X":
	            	            totalScore += (LOSE_SCORE + PAPER_SCORE);
	            	            break;
	            	        case "Y":
	            	            totalScore += (DRAW_SCORE + SCISSORS_SCORE);
	            	            break;
	            	        default:
	            	            totalScore += (WIN_SCORE + ROCK_SCORE);
                	}

                }
            }

            System.out.println("Final score: " + String.valueOf(totalScore));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}