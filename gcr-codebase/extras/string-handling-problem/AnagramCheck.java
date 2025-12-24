//write a program to check anagram string
import java.util.Scanner;
public class AnagramCheck {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str1=sc.nextLine();
        String str2=sc.nextLine();
        str1 =str1.toLowerCase();
        str2=str2.toLowerCase();

        if (str1.length() != str2.length()) {
            System.out.println("Not anagrams");
            return;
        }
        int[] frequency = new int[256]; 
        for (int i = 0; i < str1.length(); i++) {
            frequency[str1.charAt(i)]++;
        }
        for (int i = 0; i < str2.length(); i++) {
            frequency[str2.charAt(i)]--;
        }
        for (int i = 0; i < 256; i++) {
            if (frequency[i] != 0) {
                System.out.println("Not anagrams");
                return;
            }
        }

        System.out.println("Strings are anagrams");
    }
}
