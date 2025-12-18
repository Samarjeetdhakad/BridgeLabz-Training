//write a program to find the sum of user input number until it enters the zero 
import java.util.*;
public class SumUsingWhile{
	public static void main(String[]args){
		
		//take the user input value of number
		Scanner sc = new Scanner(System.in);
		double total = 0.0;
		double userInput ;
		userInput= sc.nextDouble();
		
		while(true){
			if(userInput<=0){
				break;
			}
			total=total + userInput;
			System.out.println("input again");
			userInput=sc.nextDouble();
			
		}
		System.out.println(total);
	}
}