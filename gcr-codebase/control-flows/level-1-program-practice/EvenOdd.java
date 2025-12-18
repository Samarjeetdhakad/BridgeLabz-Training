//checking and printing if the number is natural number or not
import java.util.*;
public class EvenOdd{
	public static void main(String[]args){
		
		//take input the number value
		Scanner sc= new Scanner(System.in);
		int number = sc.nextInt();
		
		//Checking the number is natural number and printing the odd and even numbers from 1
		if(number>0){
			for(int i=1;i<=number;i++){
			if(i%2==0){
				System.out.println("number"+i+"is even");
			}
			else{
				System.out.println("number" +i+"is odd");
			}
		}}

		
	}
}