// Rework the program 2, especially the Hint f where if index equals maxDigit, we break from the loop. Here we want to modify to Increase the size of the array i,e maxDigit by 10 if the index is equal to maxDigit. This is done to consider all digits to find the largest and second-largest number 
import java.util.Scanner;

public class LargestSecondLargestDynamic {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a number: ");
        int number=sc.nextInt();
        int maxDigit=10;
        int[] digits=new int[maxDigit];
        int index = 0;

        // Store all digits of the number
        while (number != 0) {
            if (index == maxDigit) {
                maxDigit=maxDigit + 10;
                int[] temp=new int[maxDigit];

                for (int i=0;i<index;i++) {
                    temp[i]=digits[i];
                }
                digits=temp;
            }
            digits[index]=number % 10;
            number=number/10;
            index++;
        }

        int largest = 0;
        int secondLargest = 0;

        //Find largest and second largest digit
        for (int i=0;i<index;i++) {
            if (digits[i] > largest) {
                secondLargest= largest;
                largest =digits[i];
            } 
            else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        //Display result
        System.out.println("Largest digit = " + largest);
        System.out.println("Second largest digit = " + secondLargest);
    }
}
