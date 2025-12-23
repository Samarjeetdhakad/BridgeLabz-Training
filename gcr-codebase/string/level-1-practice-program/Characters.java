//Write a program to return all the characters in a string using the user-defined method,  compare the result with the String built-in toCharArray() method, and display the result
import java.util.Scanner;
public class Characters{
  
  public static char[] getCharacters(String text){
    char[] characters = new char[text.length()];
    for (int i =0; i<text.length(); i++) {
        characters[i] = text.charAt(i);
    }
  return characters;
}
       //method to compare two string arrays and return a boolean result
    public static boolean comapareString(char arr1[],char arr2[]){
	if(arr1.length!=arr2.length){
	return false;
	}
	for(int i =0;i<arr1.length;i++){
	if(arr1[i]!=arr2[i]){
	return false;
	}
	}
	return true;
	}
	 
   public static void main(String[]args){
   
   Scanner sc=new Scanner(System.in);
   String text=sc.nextLine();
   char [] userdefined=getCharacters(text);
   char [] builtin=text.toCharArray();
   
   //compare both the arrays
   boolean result=comapareString(userdefined,builtin);
 
        for (char c : builtin){
            System.out.print(c + " ");
        }
        System.out.println("Are both character arrays equal? " + result);
		}
	}