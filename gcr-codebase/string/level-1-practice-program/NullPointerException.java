//Write a program to demonstrate NullPointerException.
import java.util.Scanner;
public class NullPointerException{
    
	  public static void generateNullPointerException() {
        //throw NullPointerException
		String text=null;
        System.out.println("Length of text " + text.length());
        }

    //handle NullPointerException
    public static void handleNullPointerException() {
        String text = null; 

       //use try catch block
        try {
            System.out.println("Length of text " + text.length());
        }
		catch (NullPointerException e) {
            System.out.println("Caught NullPointerException " + e.getMessage());
       }
    }
   public static void main(String[]args){
   String text=null;
     try{
            generateNullPointerException();
        } 
		catch (NullPointerException e) {
            System.out.println("Exception occurred " + e);
        }
        handleNullPointerException();
		}
	}	