import java.util.Scanner;
public class Number {
    // check if a number is positive
    public static boolean isPositive(int num) {
        return num >= 0;
   }
    // check if a positive number is even
    public static boolean isEven(int num) {
        return num % 2 == 0;
    }
  
    public static int compare(int num1, int num2) {
        if (num1 > num2) return 1;
        else if (num1 == num2) return 0;
        else return -1;
    }
   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        // Take input from the user
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }
        for (int i = 0; i < numbers.length; i++) {
            if (isPositive(numbers[i])) {
                if (isEven(numbers[i])) {
                    System.out.println(numbers[i] + " is positive and even.");
                } 
				else {
                    System.out.println(numbers[i] + " is positive and odd.");
                }
            } else
			{
                System.out.println(numbers[i] + " is negative.");
          }
        }

        // Comparision
        int comparison = compare(numbers[0], numbers[numbers.length - 1]);
        if (comparison == 1) {
            System.out.println("The first element is greater than the last element.");
        } 
		else if (comparison == 0) {
            System.out.println("The first and last elements are equal.");
        } else
		{
            System.out.println("The first element is less than the last element.");
        }
   }
}
