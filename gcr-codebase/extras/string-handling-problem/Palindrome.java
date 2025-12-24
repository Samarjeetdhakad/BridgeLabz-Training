//write a program to check a string is palindrome or not
import java.util.Scanner;
public class Palindrome{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		
		String text = sc.nextLine();
		int start = 0;
		int end = text.length()-1;
		boolean ispalindrome = true ;
		while(start < end){
			if(text.charAt(start)==text.charAt(end)){
				start++;
				end--;
				continue;
			}
			else{
				ispalindrome=false;
				
				break;
				
			}
		}
		if(ispalindrome){
			System.out.println("string is palindrome");
		}
		else{
		System.out.println("string is not palindrome");
	}}
}