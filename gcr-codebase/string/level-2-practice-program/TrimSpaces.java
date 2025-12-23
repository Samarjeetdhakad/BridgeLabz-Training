import java.util.Scanner;
public class TrimSpaces{
    public static int[]findTrimIndexes(String text){
        int start=0;
        int end=text.length()-1;
        while(start<=end && text.charAt(start) == ' '){
            start++;
        }
        while(end >=start && text.charAt(end)== ' '){
            end--;
      }
        return new int[]{start, end};
    }
    public static String customSubstring(String text, int start, int end){
        String result = "";
        for(int i=start; i<=end;i++) {
            result=result+text.charAt(i);
        }
        return result;
        }

    public static boolean compareStrings(String s1, String s2){
        if(s1.length()!=s2.length()){
            return false;
          }
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                return false;
        }
        }
          return true;
       }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        int[]indexes = findTrimIndexes(text);
        String custom = customSubstring(text, indexes[0], indexes[1]);
        String builtIn = text.trim();
        boolean isSame = compareStrings(custom, builtIn);

          System.out.println( custom );
         System.out.println( builtIn );
        System.out.println("Are both results same  " + isSame);
  }
}
   