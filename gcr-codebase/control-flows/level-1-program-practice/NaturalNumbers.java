// Finding the natural number and sum of alll natural numbers
import java.util.*;
public class NaturalNumbers{
public static void main(String[]args){
	
	//take input the number 
	Scanner sc = new Scanner(System.in);
	int number= sc.nextInt();
	int sum;
	if(number>=0){
		sum= number*(number+1)/2;
		System.out.println("The sum of "+ number + "natural numbers is " + sum );
	
		}
		else{
			System.out.println("The number " + number +" is not a natural number");

		} 
	
	}
}