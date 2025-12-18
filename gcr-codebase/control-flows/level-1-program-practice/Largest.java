//Write a progrsm to check if the first,second, or third number is the largest of the three.
import java.util.*;
public class Largest{
	public static void main(String[]args){
		
		//Take input of three numbers
		Scanner sc = new Scanner(System.in);
		double number1, number2, number3;
		number1=sc.nextDouble();
		number2=sc.nextDouble();
		number3=sc.nextDouble();
		if(number1>number2 && number1>number3){
		System.out.println("Is the first number the largest? yes" +  "Is the second number the largest? no" + "Is the third number the largest? no " );
		}
		else if(number2>number1 && number2>number3){
			System.out.println("Is the first number the largest? no "+"Is the second number the largest? yes" + "Is the third number the largest? no " );
		}
		else{
			System.out.println("Is the first number the largest? no "+ "Is the second number the largest? no" +"Is the third number the largest? yes ");
		}
		
			
	}
}
