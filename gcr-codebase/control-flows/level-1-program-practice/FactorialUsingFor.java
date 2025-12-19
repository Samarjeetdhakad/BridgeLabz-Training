//write a program to find the factoril of a number given by user
import java.util.*;
public class FactorialUsingFor{
	public static void main(String[]args){
		
		//take the user input value of number
		Scanner sc = new Scanner(System.in);
		int value ;
	    value = sc.nextInt();
		int factorial=1;
		if(value>0){
			for(int i=value; i>0; i--){
				factorial=factorial*i;
			}
		}
		System.out.println(factorial);
	}
}