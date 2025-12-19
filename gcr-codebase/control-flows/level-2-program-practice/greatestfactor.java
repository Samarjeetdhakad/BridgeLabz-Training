//finding the greatest factor inside the number itself
import java.util.*;
public class greatestfactor{
	public static void main(String[]args){
		
		//creating the scanner object
		Scanner sc = new Scanner(System.in);
		
		//take input 
		int greatestFactor=1;
		int number = sc.nextInt();
		if(number>0){
			for(int i=number-1; i>=1; i--){
				if(number%i==0){
					greatestFactor=i;
					System.out.println(greatestFactor);
					break;
				}
			}
		}
	}
}