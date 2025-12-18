//write a program to check the number is positive , negative or zero
import java.util.*;
public class PositiveNegative{
	public static void main(String[]args){
		
		//take the input of number
		Scanner sc = new Scanner (System.in);
		int number =  sc.nextInt();
		
		//showing output whether the number is positive, negative or zero
		if(number>0){
			System.out.println("Positive");
		}
		else if (number==0){
			System.out.println("Zero");
		}
		else {
			System.out.println("negative");
		}
	}
}