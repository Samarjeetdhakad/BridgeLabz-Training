//find the factors of a number
import java.util.*;
public class Factor{
	public static void main(String[]args){
		
		//create scanner object
		Scanner sc = new Scanner(System.in);
		
		//take input of number
		int number = sc.nextInt();
		
		//checking the number is positive or not and printing the factors
		if(number>0){
			for(int i=1;i<number;i++){
				if(number%i==0){
					System.out.println(i + " ");
				}
			}
		}
	}
}