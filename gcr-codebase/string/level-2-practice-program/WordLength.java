import java.util.Scanner;
public class WordLength {
    public static int findLength(String text) {
        int count = 0;
        try{
            while(true) {
                text.charAt(count);
                count++;
         }
        } 
		catch (StringIndexOutOfBoundsException e) {
 
      }
        return count;
    }
    public static String[] splitWords(String text) {
        int length = findLength(text);
        int wordCount = 1;
        for(int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
        }
        }
        int[] spaceIndex = new int[wordCount - 1];
        int index = 0;
        for(int i = 0; i < length; i++) {
            if(text.charAt(i) == ' ') {
                spaceIndex[index++] = i;
         }
        }
        String[] words = new String[wordCount];
        int start = 0;
        for(int i = 0; i < wordCount - 1; i++) {
            words[i] = text.substring(start, spaceIndex[i]);
            start = spaceIndex[i] + 1;
          }
        words[wordCount - 1] = text.substring(start);
        return words;
    }
    public static String[][]createWordLengthTable(String[] words) {
        String[][] table = new String[words.length][2];

        for(int i = 0; i < words.length; i++) {
            table[i][0] = words[i]; // Word
            table[i][1] = String.valueOf(findLength(words[i])); 
      }
        return table;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] words = splitWords(input);
        String[][] result = createWordLengthTable(words);

        for(int i = 0; i < result.length; i++) {
            int length = Integer.parseInt(result[i][1]);
            System.out.println(result[i][0] + length);
     }
    }
}
