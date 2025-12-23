import java.util.Scanner;
public class NumberCheckerFourth {

    // check if a number is Prime
    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
         }
        }
      return true;
    }

    //check if a number is Neon
    public static boolean isNeonNumber(int number) {
        int square = number * number;
        int sum = 0;

        while(square > 0) {
            sum += square % 10;
            square /= 10;
     }
           return sum == number;
    }

    //  check if number is Spy
    public static boolean isSpyNumber(int number) {
        int sum = 0;
        int product = 1;
        int temp = number;
        while(temp > 0) {
            int digit = temp % 10;
            sum += digit;
            product *= digit;
            temp /= 10;
     }
           return sum == product;
    }

    //  check if number is Automorphic
    public static boolean isAutomorphicNumber(int number) {
        int square = number * number;
        int temp = number;
        while(temp > 0) {
            if (square % 10 != temp % 10) {
                return false;
            }
            square /= 10;
            temp /= 10;
        }
        return true;
  }

    // check if a number is Buzz
    public static boolean isBuzzNumber(int number) {
        return number % 7 == 0 || number % 10 == 7;
   }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        System.out.println( isPrime(number));
        System.out.println( isNeonNumber(number));
        System.out.println( isSpyNumber(number));
        System.out.println( isAutomorphicNumber(number));
        System.out.println( isBuzzNumber(number));
  }
}
