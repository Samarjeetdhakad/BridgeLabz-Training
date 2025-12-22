//write a program to find quotient and remainder
import java.util.*;
public class QuotientRemainder{
	
	public static int[] findRemainderAndQuotient(int number, int divisor){
		
		int quotient = number/divisor;
		int remainder = number% divisor;
		int result[] = {quotient, remainder};
		
		return result;
		
		
	}
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
	
		int number = sc.nextInt();
		int divisor = sc.nextInt();
		
		
		
		int [] quotientRemainder = findRemainderAndQuotient(number, divisor);
		System.out.println(quotientRemainder[0]);
				System.out.println(quotientRemainder[1]);

		
	}
}