//Write a program to demonstrate StringIndexOutOfBoundsException
import java.util.Scanner;
public class StringIndexOutOfBoundsException{
   public static void StringIndexOutOfBoundsException(){
       System.out.println(text.charAt(10));
	   }
	    public static void handleStringIndexOutOfBoundsException(String text){
        try{
            System.out.println("Character at index 10 " + text.charAt(10));
        }
		catch(StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException " + e.getMessage());
      }
    }
   
public static void main(String[]args){
  
  Scanner sc=new Scanner(System.in);
  String text=sc.nextLine();
  
      try{
          StringIndexOutOfBoundsException(text);
        } 
		catch(StringIndexOutOfBoundsException e) {
            System.out.println("Exception occurred " + e);
        }
        handleStringIndexOutOfBoundsException(text);
		}
	}
  
  