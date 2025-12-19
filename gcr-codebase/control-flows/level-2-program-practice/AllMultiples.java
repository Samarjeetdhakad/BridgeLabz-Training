// write a program to find the number of multiples of a number below 100
import java.util.*;
public class AllMultiples{
	public static void main(String[]args){
		
		//crete scanner object
		Scanner sc =new Scanner(System.in);
		
		//take input of numberint number
		int number = sc.nextInt();
		
		//check number is positive or less than 100
		
		if(number>0 && number<100){
			for(int i=100 ; i>=1; i--){
				if(number%i==0){
					System.out.println(i);
				}
				
			}
			
		}
	}
}