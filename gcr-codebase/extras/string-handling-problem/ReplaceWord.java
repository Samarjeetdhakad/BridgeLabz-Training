//write  a program to to replace a old word to new word in a string
import java.util.Scanner;
public class ReplaceWord {
    public static String replaceWord(String sentence, String oldWord, String newWord) {
        String result = "";
        String currentWord = "";
        for (int i=0;i<sentence.length();i++) {
            char ch = sentence.charAt(i);

            if (ch != ' '){
                currentWord += ch;
            } else {
                if (currentWord.equals(oldWord)){
                    result += newWord;
                } else {
                    result += currentWord;
                }
                result +=" ";
                currentWord = "";
            }
        }
        if (currentWord.equals(oldWord)){
            result +=newWord;
        } else {
            result +=currentWord;
        }
        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        String oldWord = sc.next();
        String newWord = sc.next();
        String modifiedSentence = replaceWord(sentence, oldWord, newWord);

        System.out.println(modifiedSentence);
    }
}
