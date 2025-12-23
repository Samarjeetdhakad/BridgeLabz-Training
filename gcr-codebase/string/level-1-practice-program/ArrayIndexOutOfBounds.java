////Write a program to find and return the length of a string without using the length() method Write a program to find and return the length of a string without using the length() method
import java.util.Scanner;
public class ArrayIndexOutOfBounds {
    public static void generateArrayIndexOutOfBoundsException(String[] names){
        System.out.println(names[10]);
    }
    public static void handleArrayIndexOutOfBoundsException(String[] names) {
        try {
            System.out.println(names[10]);
        }
		catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException " + e.getMessage());
        } 
		catch (RuntimeException e) {
            System.out.println("Caught RuntimeException " + e);
     }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.nextLine();
        String[] names = new String[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter name " + (i + 1));
            names[i] = sc.nextLine();
      }
        try{
            generateArrayIndexOutOfBoundsException(names);
        }
		catch (RuntimeException e) {
            System.out.println("Exception occurred: " + e);
     }
        handleArrayIndexOutOfBoundsException(names);
  }
}
