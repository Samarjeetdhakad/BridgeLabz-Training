import java.util.Scanner;
public class FizzBuzz{
   public static void main(String[]args){
   
   Scanner sc=new Scanner(System.in);
    int number = sc.nextInt();

        // Check for positive integer
        if (number <= 0) {
            System.out.println("Enter a positive integer");
            return;
        }

        // Create String array 
        String[] results = new String[number + 1];

        
        for (int i = 0; i <= number; i++) {
            if (i == 0) {
                results[i] = "0";
            } else if (i % 3 == 0 && i % 5 == 0) {
                results[i] = "FizzBuzz";
            } else if (i % 3 == 0) {
                results[i] = "Fizz";
            } else if (i % 5 == 0) {
                results[i] = "Buzz";
            } else {
                results[i] = String.valueOf(i);
            }
        }

        
        for (int i = 0; i <= number; i++) {
            System.out.println("Position " + i + results[i]);
        }
    }
}
