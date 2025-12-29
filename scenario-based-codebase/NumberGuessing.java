// write a scenario based problem of guessing number
import java.util.Scanner;
import java.lang.Math;

public class NumberGuessing{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		
		int random;
		int guess;
		int attempts = 0;
		random = (int)(Math.random()*100) + 1;
		
		
		
		do{
			guess = sc.nextInt();
			
			 if((guess ) > random){
				System.out.println("to high");
				attempts++;
			}
			else if(guess < random ){
				System.out.println("too low");
				attempts++;
			}
			else{
				attempts++;
				System.out.println("conograts : you guess right in " + attempts + "attempts");				
				return ;
			}
				
		}while(attempts<5);
		System.out.println("total number of attempts" + attempts);
		System.out.println("lose the game coreect answer is " + random);
		
	
	}
	}