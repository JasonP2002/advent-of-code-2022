import java.io.FileReader;
import java.io.BufferedReader;

public class DayOne {
    
    final static String INPUT = "day-one-input.txt";

    public static void main(String[] args) {
        int largestCalories = 0;
        int currentCalories = 0;
        int elfID = 0;
        String currentLine;

        try {
            FileReader fr = new FileReader(INPUT);
            BufferedReader br = new BufferedReader(fr);

            while ((currentLine = br.readLine()) != null) {
                if (currentLine.equals("")) {
                    System.out.println("Elf #" + String.valueOf(elfID++) + ": " + String.valueOf(currentCalories));
                    
                    if (currentCalories > largestCalories) {
                        largestCalories = currentCalories;
                    }

                    currentCalories = 0;
                } else {
                    currentCalories += Integer.parseInt(currentLine);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("Elf " + String.valueOf(elfID++) + ": " + String.valueOf(currentCalories));
        
        if (currentCalories > largestCalories) {
            largestCalories = currentCalories;
        }
        
        System.out.println("Total Elves: " + String.valueOf(elfID));
        System.out.println("Largest Calories: " + String.valueOf(largestCalories));
    }

}