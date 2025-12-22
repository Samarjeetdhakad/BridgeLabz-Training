//write a program to check for positive , negative and zero numbers
import java.util.*;
public class CheckNumber{
	
	public static int checkNumber(int n){
		if(n<0){
			return -1;
		}
		else if(n==0){
			return 0;
		}
		else{
			return 1;
		}
	}
	public static void main(String[]args){
		
		Scanner sc= new Scanner(System.in);
		int number = sc.nextInt();
		
		int status = checkNumber(number);
		System.out.println(status);
	}
}