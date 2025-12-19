//Write the program to check if the number is divisible by 5
import java.util.*;
public class DivisibleByFive{
	public static void main(String[]args){
		
		//take inout of number
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		
		//showing the number is divisible by 5 or not
		if(number%5==0){
			System.out.println("Is the number"+number+" divisible by 5?"+"yes");
		}
		else{
			System.out.println("Is the number"+number+" divisible by 5?"+"no");
			
		}
	}
}