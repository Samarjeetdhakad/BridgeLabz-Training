//write a program to show the countdown of rocket launch from the user input to 1
import java.util.*;
public class CountDownUsingFor{
	public static void main(String[]args){
		
		//take input value of the countdown starting from the user 
		Scanner sc= new Scanner(System.in);
		int counter = sc.nextInt();
		
		//showing the countdown using for loop 
		for (int i=counter; i>=1; i--){
			System.out.println(i);
		}
	}
}