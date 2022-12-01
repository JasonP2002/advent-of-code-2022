import java.io.FileReader;
import java.io.BufferedReader;

public class DayOne {
    
    final static String INPUT = "day-one-input.txt";

    public static void main(String[] args) {
        int[] largestCalories = {0, 0, 0};
        int currentCalories = 0;
        int elfID = 0;
        String currentLine;

        try {
            FileReader fr = new FileReader(INPUT);
            BufferedReader br = new BufferedReader(fr);

            while ((currentLine = br.readLine()) != null) {
                if (currentLine.equals("")) {
                    System.out.println("Elf #" + String.valueOf(elfID++) + ": " + String.valueOf(currentCalories));
                    
                    if (currentCalories > largestCalories[0]) {
                    	largestCalories[2] = largestCalories[1];
                    	largestCalories[1] = largestCalories[0];
                    	largestCalories[0] = currentCalories;
                    	
                    } else if (currentCalories > largestCalories[1]) {
                    	largestCalories[2] = largestCalories[1];
                    	largestCalories[1] = currentCalories;
                    	
                    } else if (currentCalories > largestCalories[2]) {
                    	largestCalories[2] = currentCalories;
                    }

                    currentCalories = 0;
                } else {
                    currentCalories += Integer.parseInt(currentLine);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("Elf #" + String.valueOf(elfID++) + ": " + String.valueOf(currentCalories));
        
        if (currentCalories > largestCalories[0]) {
        	largestCalories[2] = largestCalories[1];
        	largestCalories[1] = largestCalories[0];
        	largestCalories[0] = currentCalories;
        	
        } else if (currentCalories > largestCalories[1]) {
        	largestCalories[2] = largestCalories[1];
        	largestCalories[1] = currentCalories;
        	
        } else if (currentCalories > largestCalories[2]) {
        	largestCalories[2] = currentCalories;
        }
        
        System.out.println("Total Elves           : " + String.valueOf(elfID));
        System.out.println("1st Largest Calories  : " + String.valueOf(largestCalories[0]));
        System.out.println("2nd Largest Calories  : " + String.valueOf(largestCalories[1]));
        System.out.println("3rd Largest Calories  : " + String.valueOf(largestCalories[2]));
        System.out.println("Total Largest Calories: " + String.valueOf(largestCalories[0] + largestCalories[1] + largestCalories[2]));
    }

}