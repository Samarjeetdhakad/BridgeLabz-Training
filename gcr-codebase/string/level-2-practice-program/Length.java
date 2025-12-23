//Write a program to find and return the length of a string without using the length() method 
import java.util.Scanner;
public class Length{
 public static int findLength(String s){
 int count=0;
          try{
            while(true) {
                s.charAt(count); 
                count++;
            }
        } 
		catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }
    
   public static void main(String[]args){
    
	Scanner sc=new Scanner(System.in);
	String s=sc.nextLine();
	
	int userdefined=findLength(s);
	int builtin=s.length();
	
	System.out.println("length of string in userdefined" + userdefined);
	System.out.println("length of string in builtin" + builtin);
	}
}	
	
	