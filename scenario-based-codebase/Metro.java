//scenario based question for metro fare
import java.util.Scanner;
public class Metro{
	public static void main(String[]args){
		
		Scanner sc = new Scanner(System.in);
		int balance = 100;
		int distance;
		int fare;
		
		while(balance>0){
			
			distance = sc.nextInt();
			
			if(distance ==-1){
				System.out.println("exit");
				break;
			}
			
			fare = (distance <= 5) ? 10 : 20 ;
			
			if(balance >= fare ){
				balance -= fare;
				
				 System.out.println("Fare deducted: " + fare);
                System.out.println("Remaining balance: " + balance);
			}
			
			else {
				System.out.println("insufficient");
				break;
			}
			
			if(balance ==0 ) {
				System.out.println("recharge balance is 0");
			}
				
			}

			
	}
}