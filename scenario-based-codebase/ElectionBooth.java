// scenario based problem on elcetion booth manager
import java.util.Scanner;
public class ElectionBooth{
	public static void main(String[]args){
		
		Scanner sc = new Scanner(System.in);
		int age;
		int vote;
		
		while(true){
		System.out.println("enter your age: (enter -1 to exit)");
		
		age= sc.nextInt();
		
		if(age==-1){
			System.out.println("exit successfylly");
			break;
		}
		
		if(age  >= 18 ) {
			System.out.println("choose your candidate");
			System.out.println("1. a");
			System.out.println("2. b");
			System.out.println("3. c");
			
			vote =sc.nextInt();
			
			if(vote == 1 || vote == 2 || vote == 3 ){
				System.out.println("successffully voted");
			}
			else{
			System.out.println("invalid voter");
			}
			
		}
		else{
			System.out.println("not eligible");
		}
		}
		}
}