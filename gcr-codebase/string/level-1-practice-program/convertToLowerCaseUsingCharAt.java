//Write a program to convert the complete text to lowercase and compare the results
import java.util.Scanner;
 public class LowerCase{
   
   public static String convertToLowerCaseUsingCharAt(String text) {
        String result = "";

        for(int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            //Check if character is Uppercase
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char)(ch + 32); 
            }
            result = result + ch;
          }
        return result;
        }
		
		   // compare two strings 
    public static boolean compareStringsUsingCharAt(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }

        for(int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
              return false;
         }
        }
          return true;
        }
		
    public static void main(String[]args){
	Scanner sc=new Scanner(System.in);
	String text=sc.nextLine();
	
	String userLowerCase = convertToLowerCaseUsingCharAt(text);
        String builtInLowerCase = text.toLowerCase();

        // Compare results
        boolean isSame = compareStringsUsingCharAt( userLowerCase,builtInLowerCase );  
        System.out.println(userLowerCase);
        System.out.println(builtInLowerCase);
        System.out.println("Are both results equal? " + isSame);
		}
	}	