// write a program to remove the specific character from the string
import java.util.Scanner;
public class RemoveSpecific{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();
		char specific = sc.next().charAt(0);
		String result = "";
		
		for(int i=0; i<text.length(); i++){
			if(text.charAt(i) != specific){
				result  += text.charAt(i);				
			}
		}
		System.out.println(result);
	}
}