//write a program to find the sum of user input number until it enters the zero 
import java.util.*;
public class SumOfNumbers{
	public static void main(String[]args){
		
		//take the user input value of number
		Scanner sc = new Scanner(System.in);
		double total = 0.0;
		double userInput ;
		userInput= sc.nextDouble();
		
		while(userInput != 0 ){
			total=total + userInput;
			System.out.println("input again");
			userInput=sc.nextDouble();
			
		}
		System.out.println(total);
	}
}