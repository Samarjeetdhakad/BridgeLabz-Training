//find the factors of a number using while loop
import java.util.*;
public class FactorUsingWhile{
	public static void main(String[]args){
		
		//create scanner object
		Scanner sc = new Scanner(System.in);
		
		//take input of number
		int number = sc.nextInt();
		
		//checking the number is positive or not and printing the factors
		if(number>0){
			int i=1;
			while(i<number){
				if(number%i==0){
					System.out.println(i + " ");
				}
				i++;
			}
		}
	}
}