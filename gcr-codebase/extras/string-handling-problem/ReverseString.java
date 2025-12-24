// write a program of reversing a  string
import java.util.Scanner;
public class ReverseString{
public static void main(String[]args){
	Scanner sc = new Scanner(System.in);
	
	String name = sc.nextLine();
	String reversed = "";
	
	for(int i = name.length()-1 ;i >= 0 ; i--){
		char  ch = name.charAt(i);
		reversed = reversed + ch;
	}
	System.out.println(reversed);
}
}