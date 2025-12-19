// Write a program to check the first number is the smallest number or not ouot of 3
import java.util.*;
public class FirstSmallest{
	public static void main(String[]args){
		
		//take input of numbers
		Scanner sc = new Scanner(System.in);
		int number1 = sc.nextInt();
		int number2 = sc.nextInt();
		int number3 = sc.nextInt();
		
		//showing the output
		if(number1>number2 && number1>number3){
			System.out.println(" Is the first number the smallest? " + " yes");
		}
		else{
			System.out.println(" Is the first number the smallest? " + " no");
		}
	}
	
}