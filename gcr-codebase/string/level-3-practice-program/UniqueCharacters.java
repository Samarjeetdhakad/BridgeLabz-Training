// Find unique characters in a string using the charAt() method and display the result
import java.util.Scanner;

public class UniqueCharacters{

public static int findLength(String text){
      int count = 0;
        try {
           while(true){
                text.charAt(count);
                count++;
            }
        }
		catch(Exception e){
        }
        return count;
    }
   public static char[] findUniqueChars(String text) {
        int length = findLength(text);
     char[] temp = new char[length];
        int index = 0;
    for(int i = 0; i < length; i++){
     char current = text.charAt(i);
   boolean isUnique = true;

     for(int j = 0; j < i; j++){
              if (current == text.charAt(j)){
           isUnique = false;
                    break;
                }
            }
    if(isUnique){
         temp[index] = current;
          index++;
       }
        }
   char[] result = new char[index];
        for(int i = 0; i < index; i++){
            result[i] = temp[i];
        }
        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
    String text = sc.nextLine();

     char[] uniqueChars = findUniqueChars(text);

   System.out.print("Unique characters are: ");
     for(int i = 0; i < uniqueChars.length; i++){
            System.out.print(uniqueChars[i] + " ");
      }
    }
   }
