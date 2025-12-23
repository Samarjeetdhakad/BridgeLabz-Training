// Write a program to find the frequency of characters in a string using unique characters and display the result
import java.util.Scanner;

public class CharacterFrequencyUsingUnique{
    public static char[] uniqueCharacters(String text){

    char[] temp = new char[text.length()];
      int index = 0;

    for(int i = 0; i < text.length(); i++){
            char ch = text.charAt(i);
            boolean isUnique = true;

   for(int j = 0; j < i; j++){
          if (ch == text.charAt(j)) {
                isUnique = false;
                    break;
 }
      }
    if (isUnique){
                temp[index] = ch;
                index++;
         }
        }

   char[] uniqueChars = new char[index];
       for (int i = 0; i < index; i++){
            uniqueChars[i] = temp[i];
        }
        return uniqueChars;
    }

    public static String[][] findCharacterFrequency(String text){

        int[] freq = new int[256];

        for (int i = 0; i < text.length(); i++){
            freq[text.charAt(i)]++;
  
        char[] uniqueChars = uniqueCharacters(text);

     String[][] result = new String[uniqueChars.length][2];

    for(int i = 0; i < uniqueChars.length; i++){
            result[i][0] = String.valueOf(uniqueChars[i]);
            result[i][1] = String.valueOf(freq[uniqueChars[i]]);
        }

    return result;
    }

  public static void displayResult(String[][] arr){

      System.out.println("\nCharacter\tFrequency");
        for(int i = 0; i < arr.length; i++){
     System.out.println(arr[i][0] + "\t\t" + arr[i][1]);
       }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // User input
    System.out.print("Enter a string: ");
    String text = sc.nextLine();
     String[][] result = findCharacterFrequency(text);
     displayResult(result);

    }
}
