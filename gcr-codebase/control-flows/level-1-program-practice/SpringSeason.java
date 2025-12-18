//Write a program to find the season is spring or not
import java.util.*;
public class SpringSeason{
	public static void main(String[]args){
		
		//Take input of the month and day
		Scanner sc = new Scanner(System.in);
		int day, month;
		month= sc.nextInt();
		day= sc.nextInt();
		if((month==3 && day>=20) || month == 4 ||month==5 || (month ==6 && day <=20)){
			System.out.println("Its a Spring Season");
			
		}
		else {
			System.out.println("Not a Spring Season");
		}
		
	}
}