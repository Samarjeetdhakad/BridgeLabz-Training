import java.util.Scanner;
public class IllegalArgumentException {
    public static void generateIllegalArgumentException(String text) {
        System.out.println( text.substring(5, 2));
    }
    public static void handleIllegalArgumentException(String text) {
        try{
         } 
		catch(IllegalArgumentException e){
            System.out.println("Caught IllegalArgumentException " + e.getMessage());
           } 
		catch(RuntimeException e){
            System.out.println("Caught RuntimeException " + e);
      }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        try {
            generateIllegalArgumentException(text);
        } 
		catch (RuntimeException e){
            System.out.println("Exception occurred " + e);
        }
        handleIllegalArgumentException(text);
       }
}
