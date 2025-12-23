import java.util.Scanner;
public class NumberCheckerThree {
    public static int countDigits(int number) {
        if (number == 0) return 1;
        int count = 0;
        number = Math.abs(number);
        while (number > 0) {
            count++;
            number /= 10;
        }
    return count;
    }

    // store digits in array
    public static int[] getDigitsArray(int number) {
        int count = countDigits(number);
        int[] digits = new int[count];
		
        number = Math.abs(number);
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
      return digits;
    }
    //reverse digits array
    public static int[] reverseArray(int[] digits) {
        int[] reversed = new int[digits.length];

     for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
    }
        return reversed;
    }

    //compare two arrays
    public static boolean areArraysEqual(int[] arr1, int[] arr2) {
     if (arr1.length != arr2.length) return false;

    for (int i = 0; i < arr1.length; i++) {
        if (arr1[i] != arr2[i]) {
          return false;
         }
    }
       return true;
    }

    // check if number is palindrome
    public static boolean isPalindrome(int[] digits) {
        int[] reversed = reverseArray(digits);
        return areArraysEqual(digits, reversed);
   }

    public static boolean isDuckNumber(int[] digits) {
        for (int d : digits) {
            if (d != 0) {
                return true;
       }
      }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        int number = sc.nextInt();
      int[] digits = getDigitsArray(number);
        for (int d : digits) {
            System.out.print(d + " ");
        }

        int[] reversed = reverseArray(digits);
        for (int d : reversed) {
            System.out.print(d + " ");
      }
        System.out.println( areArraysEqual(digits, reversed));

       
        	   if (isPalindrome(digits)) {
            System.out.println(number + " is a Palindrome number");
          } else {
            System.out.println(number + " is NOT a Palindrome number");
        }
           if (isDuckNumber(digits)) {
            System.out.println(number + " is a Duck number");
        } 
		else {
            System.out.println(number + " is NOT a Duck number");
}
    }
}
