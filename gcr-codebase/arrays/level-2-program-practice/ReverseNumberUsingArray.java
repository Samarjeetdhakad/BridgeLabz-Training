// Create a program to take a number as input and reverse the number. To do this, store the digits of the number in an array and display the array in reverse order
import java.util.Scanner;

class ReverseNumberUsingArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int temp = number;
        int count = 0;

        // Count number of digits
        while (temp != 0) {
            count++;
            temp = temp / 10;
        }

        // Array to store digits
        int[] digits = new int[count];
        int index = 0;

        // Store digits of the number
        while (number != 0) {
            digits[index] = number % 10;
            number = number / 10;
            index++;
        }

        // Array to store reversed digits
        int[] reverse = new int[count];

        for (int i = 0; i < count; i++) {
            reverse[i] = digits[count - 1 - i];
        }

        // Display reversed number
        System.out.print("Reversed number: ");
        for (int i = 0; i < count; i++) {
            System.out.print(reverse[i]);
        }
    }
}
