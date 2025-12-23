import java.util.Scanner;
public class NumberCheckerFifth {
    public static int sumOfProperDivisors(int number) {
        int sum = 0;
        for(int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
             
			   sum += i;
      }
      }
        return sum;
    }

    // number is Perfect
    public static boolean isPerfectNumber(int number) {
        return number > 0 && sumOfProperDivisors(number) == number;
    }

    // check if number is Abundant
    public static boolean isAbundantNumber(int number) {
        return number > 0 && sumOfProperDivisors(number) > number;
    }

    // Method to check if number is Deficient
    public static boolean isDeficientNumber(int number) {
        return number > 0 && sumOfProperDivisors(number) < number;
    }

    // find factorial of a digit
    public static int factorial(int digit) {
        int fact = 1;
        for(int i = 1; i <= digit; i++) {
            fact *= i;
        }
          return fact;
    }

    //  check if number is Strong
    public static boolean isStrongNumber(int number) {
        int temp = number;
        int sum = 0;

        while(temp > 0) {
            int digit = temp % 10;
            sum += factorial(digit);
            temp /= 10;
     }
           return sum == number;
   }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        System.out.println("\nPerfect Number: " + isPerfectNumber(number));
        System.out.println("Abundant Number: " + isAbundantNumber(number));
        System.out.println("Deficient Number: " + isDeficientNumber(number));
        System.out.println("Strong Number: " + isStrongNumber(number));
    }
}
