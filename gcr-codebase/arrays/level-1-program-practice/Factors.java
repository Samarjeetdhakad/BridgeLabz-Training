
//Create a program to find the factors of a number taken as user input, store the factors in an array, and display the factors
 import java.util.Scanner;
 public class Factors{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        
        if (number <= 0) {
            System.out.println("enter positive");
           return;
        }

      //initialize the array and create a variable
        int maxFactor = 10;
        int[] factors = new int[maxFactor];
        int index = 0;

        // Find the factors with the help of loop
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {

                
                if (index == maxFactor) {
                    maxFactor*= 2; 
                    int[] temp = new int[maxFactor];

                    // Copy old elements to new array
                    for (int j = 0; j < factors.length; j++) {
                        temp[j] = factors[j];
                   }
                    factors = temp; 
                }
                factors[index] = i;
                index++;
            }
        }

        System.out.println("Factors of " + number + ":");
        for (int i = 0; i < index; i++) {
            System.out.print(factors[i] + " ");
        }
    }
}
