//Write a Java program where the user thinks of a number between 1 and 100, and

import java.util.Random;
import java.util.Scanner;
public class GuessGame {
    public static int generateGuess(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
        }
    public static String getUserFeedback(Scanner sc){
        System.out.print("Enter feedback (high / low / correct): ");
        return sc.next().toLowerCase();
        }
    public static int[] updateRange(String feedback, int guess, int min, int max){
        if(feedback.equals("high")){
            max = guess - 1;
        } 
		else if(feedback.equals("low")){
            min = guess + 1;
    }
        return new int[]{min, max};
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int min=1;
        int max=100;
        int guess;
        String feedback;

        System.out.println("Think of a number between 1 and 100.");
        System.out.println("I will try to guess it!");
        System.out.println("Respond with 'high', 'low', or 'correct'.\n");
        while(true){
            guess=generateGuess(min, max);
            System.out.println("My guess is " + guess);

            feedback = getUserFeedback(sc);
            if(feedback.equals("correct")){
                System.out.println(" number is correct");
                break;
            }
			else if(feedback.equals("high") || feedback.equals("low")){
                int[]range=updateRange(feedback, guess, min, max);
                min=range[0];
                max=range[1];
            }
			else {
                System.out.println("Invalid input! Please enter high, low, or correct.");
       }
     }
    }
}

   