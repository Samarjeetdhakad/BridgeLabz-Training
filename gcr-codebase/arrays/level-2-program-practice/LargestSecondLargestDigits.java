// Create a program to store the digits of the number in an array and find the largest and second largest element of the array.

import java.util.Scanner;

class LargestSecondLargestDigits {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        // Take user input
        System.out.print("Enter a number: ");
        int number=sc.nextInt();
        int maxDigit = 10;
        int[] digits=new int[maxDigit];
        int index = 0;
        while (number!=0) {
            if (index==maxDigit) {
                break;
            }
            digits[index]=number%10;
            number= number/10;
            index++;
        }
        int largest = 0;
        int secondLargest = 0;

        // Find largest and second largest digit
        for (int i=0;i< index;i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest=digits[i];
            } 
            else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        // showing result
        System.out.println("Largest digit="+largest);
        System.out.println("Second largest digit = "+secondLargest);
    }
}

