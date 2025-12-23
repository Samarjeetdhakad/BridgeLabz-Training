import java.util.Scanner;
public class SubstringComparison {
  
    public static String SubstringUsingCharAt(String text,int start,int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result = result + text.charAt(i);
      }
       return result;
    }
    //compare two strings using charAt()
    public static boolean compareStringsUsingCharAt(String s1,String s2){
        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        int start = sc.nextInt();
        int end = sc.nextInt();

        // Substring using charAt()
        String manualSubstring = SubstringUsingCharAt(text, start, end);

        // Substring using builtin method
        String builtInSubstring = text.substring(start, end);

        // Compare both substrings
        boolean isSame = compareStringsUsingCharAt(manualSubstring,builtInSubstring);

       System.out.println("Substring using charAt(): " + manualSubstring);
       System.out.println("Substring using substring(): " + builtInSubstring);
      System.out.println("Are both substrings equal? " + isSame);
       
  }
}
