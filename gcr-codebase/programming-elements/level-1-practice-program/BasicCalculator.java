//program to perform basic mathematical ooperations 
import java.util.*;
public class BasicCalculator {
	public static void main (String[]args){
		
		//declairing and taking input of two numbers
		double number1, number2;
		Scanner input =  new Scanner (System.in);
		number1 = input.nextDouble();
		number2 = input.nextDouble();
		double addition = number1 + number2;
		double substraction = number1-number2;
		double multiplication  = number1 * number2;
		double division   = number1 / number2;
		
		
		//printing the calculated values
		System.out.println("The addition, subtraction, multiplication and division value of 2 numbers " + number1+ "and "+ number2 +  " is " + addition + ", " + substraction + ", " + multiplication + " and " + division );

		
		

		
		
		
	}

}