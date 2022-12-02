import java.io.FileReader;
import java.io.BufferedReader;

public class DayTwo {
    
    final static String INPUT = "day-two-input.txt";
    static int totalScore = 0;
    static String[] round;

    static final int WIN_SCORE = 6;
    static final int LOSE_SCORE = 0;
    static final int DRAW_SCORE = 3;

    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader(INPUT);
            BufferedReader br = new BufferedReader(fr);
            String currentLine;
            
            while ((currentLine = br.readLine()) != null) {
                round = currentLine.split(" ");

                switch (round[1]) {
                    case "X":
                        totalScore++;
                        
                        switch (round[0]) {
                            case "A":
                                totalScore += DRAW_SCORE;
                                break;
                            case "B":
                                totalScore += LOSE_SCORE;
                                break;
                            default:
                                totalScore += WIN_SCORE;
                        }

                        break;
                    case "Y":
                        totalScore += 2;
                        
                        switch (round[0]) {
                            case "A":
                                totalScore += WIN_SCORE;
                                break;
                            case "B":
                                totalScore += DRAW_SCORE;
                                break;
                            case "C":
                                totalScore += LOSE_SCORE;
                        }

                        break;
                    default:
                        totalScore += 3;
                        
                        switch (round[0]) {
                            case "A":
                                totalScore += LOSE_SCORE;
                                break;
                            case "B":
                                totalScore += WIN_SCORE;
                                break;
                            default:
                                totalScore += DRAW_SCORE;
                        }
                }

            }

            System.out.println("Final score: " + String.valueOf(totalScore));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}