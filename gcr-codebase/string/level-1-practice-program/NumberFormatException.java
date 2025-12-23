import java.util.Scanner;
public class NumberFormatException{
    public static void generateNumberFormatException(String text) {
        int number = Integer.parseInt(text);
        System.out.println("Converted number: " + number);
    }

    public static void handleNumberFormatException(String text) {
        try{
            int number = Integer.parseInt(text);
       
        }
		catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException " + e.getMessage());
        }
		catch (RuntimeException e) {        
            System.out.println("Caught RuntimeException " + e);
        }
      }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        try{
            generateNumberFormatException(text);
        } 
		catch (RuntimeException e) {
            System.out.println("Exception occurred " + e);
            }
        handleNumberFormatException(text);
  }
}
