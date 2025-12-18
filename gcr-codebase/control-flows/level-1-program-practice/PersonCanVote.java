// Write a program to check whether 
import java.util.*;
public class PersonCanVote{
	public static void main(String[]args){
		
		//tske input of age 
		Scanner sc =  new Scanner(System.in);
		int age = sc.nextInt();
		
		if(age>=18){
			System.out.println("The person's age is " + age+ " and can vote");			
		}
		else{
			System.out.println("The person's age is " + age + " and cannot vote");
		}
	}
}