//write a program to find the factoril of a number given by user
import java.util.*;
public class FactorialUsingWhile{
	public static void main(String[]args){
		
		//take the user input value of number
		Scanner sc = new Scanner(System.in);
		int value ;
	    value = sc.nextInt();
		int factorial=1;
		if(value>0){
			while(value>0){
				factorial=factorial*value;
				value--;
			}
		}
		System.out.println(factorial);
	}
}