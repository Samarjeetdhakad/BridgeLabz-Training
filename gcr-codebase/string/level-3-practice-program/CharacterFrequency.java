// Write a program to find the frequency of characters in a string using the charAt() method and display the result

import java.util.Scanner;
public class CharacterFrequency{

  public static String[][] findCharacterFrequency(String text){
      int[] freq = new int[256];
   for(int i= 0; i < text.length(); i++){
        char ch = text.charAt(i);
            freq[ch]++;
        }

     int count = 0;
  for(int i = 0; i < text.length(); i++){
        if(freq[text.charAt(i)] != 0){
              count++;
        freq[text.charAt(i)] = -1; 
            }
        }
   freq = new int[256];
  for(int i = 0; i < text.length(); i++){
            freq[text.charAt(i)]++;
       }

   String[][] result = new String[count][2];
     int index = 0;

  for(int i = 0; i < text.length(); i++){
      char ch = text.charAt(i);
      if (freq[ch] != -1) {
	  result[index][0] = String.valueOf(ch);
         result[index][1] = String.valueOf(freq[ch]);
          freq[ch] = -1;
          index++;
            }
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
