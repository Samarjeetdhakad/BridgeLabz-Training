//write a program of finding sunstring occurance
import java.util.Scanner;

public class SubstringCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String mainString = sc.nextLine();
        String subString = sc.nextLine();
        int count = 0;

        for (int i = 0; i <= mainString.length() - subString.length(); i++){
            boolean match = true;

            for (int j = 0; j < subString.length(); j++) {
                if (mainString.charAt(i+j) != subString.charAt(j)){
                    match = false;
                    break;
                }
            }
            if (match) {
                count++;
            }
        }
        System.out.println(count);
    }
}
