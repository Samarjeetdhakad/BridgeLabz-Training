//Write a program to find the quotient and remainder of two numbers
import java.util.*;
public class QuotientRemainder{
	public static void main(String[]args){
		
		//take input of numbers from user
		Scanner sc = new Scanner(System.in);
		int number1 = sc.nextInt();
		int number2 = sc.nextInt();
		int quotient = number1/number2;
		int remainder = number1%number2;
		
		//showing the output 
		System.out.println("The quotient is"+quotient+" the remainder is "+ remainder + " of two number " + number1 + "and"+number2);
	
	}
}