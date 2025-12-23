//Write a program to convert the complete text to uppercase and compare the results
import java.util.Scanner;
public class UpperCase{
    public static String convertToUpperCaseUsingCharAt(String text) {
        String result = "";

        for(int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            //Check if character is lowercase
            if (ch >= 'a' && ch <= 'z') {
                ch = (char)(ch - 32); 
            }
            result = result + ch;
          }
        return result;
        }
	
	   // compare two strings 
    public static boolean compareStringsUsingCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
         }
        }
          return true;
        }


   public static void main(String[]args){
         Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        
        String userUpperCase = convertToUpperCaseUsingCharAt(text);
        String builtInUpperCase = text.toUpperCase();

        // Compare results
        boolean isSame = compareStringsUsingCharAt(userUpperCase, builtInUpperCase);  
        System.out.println(userUpperCase);
        System.out.println(builtInUpperCase);
        System.out.println("Are both results equal? " + isSame);
		}
	}	

   