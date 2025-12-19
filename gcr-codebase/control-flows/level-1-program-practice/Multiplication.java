//write a program of finding the multiplication table of a number from 6to 9
import java.util.*;
public class Multiplication{
	public static void main(String[]args){
		
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
		
		for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + (number * i));
        }
		
	}
}