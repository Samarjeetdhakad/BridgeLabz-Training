//Write a program to find the youngest and tallest person among three friends
import java.util.*;
public class YoungestTallest{
	public static void main(String[]args){
		
		//create scanner object
		Scanner sc = new Scanner(System.in);
		
		//take input of ages and heights
		int age1, age2, age3,height1, height2, height3;
		age1 = sc.nextInt();
		age2 = sc.nextInt();
		age3 = sc.nextInt();
		height1 = sc.nextInt();
		height2 = sc.nextInt();
		height3 = sc.nextInt();
		
		//calculate the youngest and tallest
		
		if(age1<=age2 && age1<=age3){
        System.out.println("Amar is youngest");
        }
        else if(age2<=age1 && age2<=age3){
        System.out.println("Akbar is youngest");
        }
        else{
        System.out.println("Anthony is youngest");
		}
		
		if(height1>=height2 && height1>=height3){
	    System.out.println("Amar is tallest");
	    }
	    else if (height2>=height1 && height2>=height3){
	    System.out.println("Akbar is tallest");
	    }
	    else{
	    System.out.println("Anthony is tallest");
	    }
	}
}
