import java.util.Scanner;
public class UniqueCharFrequency {
    public static char[] uniqueCharacters(String text){
        int length=text.length();
        char[] temp=new char[length];
        int index=0;

        for(int i=0;i<length;i++){
            char current=text.charAt(i);
            boolean isUnique=true;

            for(int j=0;j<i;j++){
                if(current==text.charAt(j)){
                    isUnique=false;
                    break;
              }
            }

            if(isUnique){
                temp[index]=current;
                index++;
         }
        }
        char[] result=new char[index];
        for(int i=0;i<index;i++){
            result[i]=temp[i];
        }
 return result;
    }
    public static String[][] charFrequency(String text) {
        char[]uniqueChars=uniqueCharacters(text);
        int[]freq=new int[256];
        // Count frequency 
        for(int i=0;i<text.length();i++){
            char ch=text.charAt(i);
            freq[ch]++;
        }
        String[][]result=new String[uniqueChars.length][2];
        for(int i=0; i<uniqueChars.length;i++){
            char ch=uniqueChars[i];
            result[i][0]=String.valueOf(ch);
              result[i][1]=String.valueOf(freq[ch]);
      }
     return result;
    }

    // array in tabular format
    public static void displayTable(String[][] data){
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t\t" + data[i][1]);
     }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text=sc.nextLine();
        String[][] result=charFrequency(text);
        displayTable(result);
   }
}