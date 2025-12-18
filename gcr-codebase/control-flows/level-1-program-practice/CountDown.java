//write a program to show the countdown of rocket launch from the user input to 1
import java.util.*;
public class CountDown{
	public static void main(String[]args){
		
		//take input value of the countdown starting from the user 
		Scanner sc= new Scanner(System.in);
		int counter = sc.nextInt();
		
		//showing the countdown
		while(counter>=1){
			System.out.println(counter);
			counter--;
		}
	}
}