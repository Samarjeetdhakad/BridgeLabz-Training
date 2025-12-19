//Write the program to check the number is positive and print the fizzbuzz
import java.util.Scanner;
public class FizzBuzzProgram{
  public static void main(String[]args){
  
    //Take the input from the user and make the scanner object
    Scanner sc=new Scanner(System.in);
    int number=sc.nextInt();
	
	//check whether the number is positive or not
	
        if (number <= 0) {
            System.out.println("Enter a valid positive number");
        } else {
		int i=1;
            while (i<=number) {
                if (i % 3 == 0 && i % 5 == 0) {
                    System.out.println("FizzBuzz");
                } else if (i % 3 == 0) {
                    System.out.println("Fizz");
                } else if (i % 5 == 0) {
                    System.out.println("Buzz");
                } else {
                    System.out.println(i);
                }
				i++;
            }
        }
  }
}