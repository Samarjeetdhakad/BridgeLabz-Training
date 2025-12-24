//write a program of findign the logest characterr in string
import java.util.Scanner;
public class LongestChararter{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();
		String currentChar = "";
		String longestChar = "";
		
		for(int i=0; i<text.length(); i++){
			char ch = text.charAt(i);
			if(ch != ' '){
				currentChar += ch;
			}
			else{
				if(currentChar.length() > longestChar.length()){
					longestChar = currentChar;
				}
				currentChar="";
			}
		}
		
		if(currentChar.length() > longestChar.length()){
			longestChar = currentChar;
		}
		System.out.println(longestChar);
}
}
