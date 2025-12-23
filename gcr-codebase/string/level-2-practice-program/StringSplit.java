import java.util.Scanner;
public class StringSplit{
    public static int findLength(String text){
        int count = 0;
        try{
            while(true) {
                text.charAt(count);
                count++;
        }
        } 
		catch(StringIndexOutOfBoundsException e){
           
        }
        return count;
       }

    public static int countWords(String text){
        int length = findLength(text);
        int words = 1;
        for(int i = 0; i < length; i++){
            if (text.charAt(i) == ' '){
                words++;
         }
      }
        return words;
    }
    public static String[] customSplit(String text) {
        int length = findLength(text);
        int wordCount = countWords(text);
        int[] spaceIndexes = new int[wordCount - 1];
        int index = 0;
        for(int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[index++] = i;
         }
        }
        String[] words = new String[wordCount];
        int start = 0;

        for (int i = 0; i < wordCount - 1; i++) {
            words[i] = text.substring(start, spaceIndexes[i]);
            start = spaceIndexes[i] + 1;
        }
        words[wordCount - 1] = text.substring(start);
        return words;
     }
    public static boolean compareArrays(String[] arr1, String[] arr2){
        if(arr1.length != arr2.length) {
            return false;
          }

        for(int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
        }
      }
        return true;
       }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] customWords = customSplit(input);
        String[] builtInWords = input.split(" ");
        for (String word : customWords) {
            System.out.println(word);
        }
        for(String word: builtInWords) {
            System.out.println(word);
        }
        boolean result =compareArrays(customWords, builtInWords);
        System.out.println("Are both results same? " + result);
    }
}
