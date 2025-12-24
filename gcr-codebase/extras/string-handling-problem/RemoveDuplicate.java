// write a program to remove duplicate 
import java.util.Scanner;
public class RemoveDuplicate{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		
		String text = sc.nextLine();
		
		String result = "";
		
		for(int i=0; i<text.length(); i++){
			boolean isDuplicate = false;
			char currentChar = text.charAt(i);
			
			for (int j=0; j<result.length(); j++){
				if(currentChar == result.charAt(j)){
					isDuplicate = true;
					break;
				}
				
			}
			if(!isDuplicate){
				result += currentChar;
			}
		}
		System.out.println(result);
	}

}