//Write a program to count the number of vowels and consonant in a given string
import java.util.Scanner;
public class CountVowelConsonant{
	public static void main(String[]args){
	
	Scanner sc = new Scanner(System.in);
	
	String name = sc.nextLine().toLowerCase();
	int vowels= 0;
	int consonant = 0;
	
	for (int i = 0 ; i < name.length(); i++){
		char ch = name.charAt(i);
		if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
			vowels++;
		}
		else {
			consonant++;
		}
	}
	
	
	System.out.println("vowels :"    + vowels);
	System.out.println("consonant :"    + consonant);
	}
}