// write a program to find the number of multiples of a number below 100
import java.util.*;
public class AllMultiplesWhile{
	public static void main(String[]args){
		
		//crete scanner object
		Scanner sc =new Scanner(System.in);
		
		//take input of numberint number
		int number = sc.nextInt();
		
		//check number is positive or less than 100
		
		int counter = number-1;
		if(number>0 && number<100){
			while(counter>1){
				if(number%counter==0){
					System.out.println(counter);
				}
				counter--;
				
			}
			
		}
	}
}