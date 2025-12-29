//write a program of phone recharge simulator 
import java.util.Scanner;

public class PhoneSimulator{
	public static void main(String[]args){
	Scanner sc = new Scanner(System.in);
	
	double balance ;
	System.out.println("enter the balance amount in your account");
	balance = sc.nextDouble();
	char choice = 'y';
	int operator ;
	
	while(choice == 'y' && balance>50 ){
		System.out.println("choose mobile operator");
		System.out.println("1. jio");
		System.out.println("2. airtel");
		System.out.println("3. VI");
		
		operator = sc.nextInt();
		
		
		switch(operator){
			case 1:
			System.out.println("jio offer : extrra 1 gb");
			break;
			
			case 2:
			System.out.println("Airtel Offer: Free Hello Tunes");
			break;
		    case 3:
			 System.out.println("Vi Offer: Weekend Data Rollover");
            break;
			 
			default :
		    System.out.println("Invalid Operator!");
            continue;
            }
			
			System.out.print("Enter recharge amount");
            double amount = sc.nextDouble(); 
			
			balance -=  amount;
		    System.out.print("Do you want to recharge again?(y/n)");
			choice = sc.next().toLowerCase().charAt(0);
		
		
	}
	System.out.println("Thank you for using Phone Recharge Simulator");
	
	
	
	
	

	
}}