// write a progrma to check the string lexicographically 
import java.util.Scanner;
public class Lexicographically{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		String text1 = sc.nextLine();
		String text2 = sc.nextLine();
		
		int i=0;
		while(i<text1.length() && i<text2.length()){
			if(text1.charAt(i) != text2.charAt(i)){
				if(text1.charAt(i)>text2.charAt(i)){
					System.out.println(text2+ "come before" + text2 );
				}
				else{
					System.out.println(text1 + " come before" + text1);
				}
				return ;
			}
			i++;
		}
		
		if(text1.length() == text2.length()){
			System.out.println("both string are equal");
			
		}
		else if(text1.length()>text2.length()){
			System.out.println("string 1 is greater");
			
		}
		else{
			System.out.println("string 2 is greater");
		}
	}
}