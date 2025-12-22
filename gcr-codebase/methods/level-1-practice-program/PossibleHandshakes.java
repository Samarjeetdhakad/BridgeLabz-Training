//Write a program to find the possible handshakes
import java.util.*;
public class PossibleHandshakes{
	
	public static int getHandshakes	(int n){
		int handshakes = (n*(n-1))/2 ;
		return handshakes;
	}
	public static void main(String[]args){
		//create scnanner object 
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		// method to get number of handshakes
		int handshakes = getHandshakes(number);
		
		System.out.println(handshakes);
	}
	
}