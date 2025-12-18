//Write a program to find the sum of n natural numbers using while loop and formula 
import java.util.*;
public class CompareSum{
	public static void main(String[]args){
	
	//take the user input value
	Scanner sc= new Scanner(System.in);
	int total=0;
	int totalUsingFormula=0;
	int number = Integer .parseInt(args[0]);
	System.out.println("hee");
	if(number>0){
		int n=number;
		while(n>0){
			total = total+ n;
			n--;
		}
		totalUsingFormula= number*(number+1)/2;
		
	}
	else{
		System.out.println("number is  not natural");
	}
	if(total==totalUsingFormula){
		System.out.println("both are same " + total + "and" + totalUsingFormula);
	}
	else{
		System.out.println("values are not same "   + total+ ","+ totalUsingFormula);
	}
	
}
}
