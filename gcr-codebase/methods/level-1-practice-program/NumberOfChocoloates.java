//write a program to find the number of chocolates distributed among students and remaining
import java.util.*;
public class NumberOfChocoloates{
	
	public static int[] findChocolates(int chocolates, int students){
		int numberOfChocolate = chocolates/students;
		int remainingChocolate = chocolates%students;
		int result[] = {numberOfChocolate , remainingChocolate};
		return result;
	}
	public static void main(String[]args){
		
		//create scanner object
		Scanner sc = new Scanner(System.in);
		
		//take input of chocolates and students number
		int chocolates = sc.nextInt();
		int students = sc.nextInt();
		
		
		int result[] = findChocolates(chocolates, students);
		System.out.println("number of chocolatesper student " +result[0]);
		System.out.println("number of remaining chocolates" + result[1]);
	}
}