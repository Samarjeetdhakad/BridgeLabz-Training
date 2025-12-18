//write a program to find the bonus amount 
import java.util.*;
public class BonusAmount{
	public static void main(String[]args){
		
		//take input of salary and year of service
		Scanner sc = new Scanner (System.in);
		double salary=sc.nextDouble();
		int years=sc.nextInt();
		double bonus = 0;
		 if (years > 5) {
            bonus = salary * 0.05;  
        }
		
		//printing the bonus amount
		System.out.println("Bonus amount: " + bonus);

		
		
	}
}