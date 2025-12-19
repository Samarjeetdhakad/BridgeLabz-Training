import java.util.*;
public class FizzBuzzUsingFor{
	public static void main(String[]args){
		
		//create scanner object
		Scanner sc=new Scanner(System.in);
		
		//take i=user input of number
		int number = sc.nextInt();
		
		//check if number is positive or not 
		if (number<=0){
			System.out.println("Enter a valid positive number");
		}
		else{
			
			for (int i=1; i<=number; i++){
			if(i%3==0 && i%5==0){
				System.out.println("FizzBuzz");
			}
			else if(i%3==0){
				System.out.println("Fizz");
			}
			else if (i%5==0){
				System.out.println("Buzz");
			}
			else{
				System.out.println(i);
			}
			}
		}
	}
}