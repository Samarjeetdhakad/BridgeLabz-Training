//Write a program to find vowels and consonants in a string and display the character type - Vowel, Consonant, or Not a Letter
import java.util.Scanner;
 public class VowelsConsonants{
   public static String checkChar(String s){
   for(int i=0;i<s.length;i++){
   char ch=s.charAt(i):
   if(ch>='A' && ch<='Z'){
   ch=(char) (ch+32);
   }
    if (ch >= 'a' && ch <= 'z') {
   if(ch='a'|| ch=='e'|| ch=='i'||ch=='u'||ch=='o')
   return "vowel";
   }
   else{
   return "consonant";
   }
  }
return "not a letter"
}  
   public static String[][] findVowelsConsonants(String s){
   int length=s.length();
   String[][] result=new String[length][2];
   for(int i=0;i<length;i++){
   char c=s.charAt(i);
   result[i][0]=String.valueOf(ch);
      result[i][1]=checkChar(ch);
	  }
	  return result;
	  }
	    
    public static void displayTable(String[][] table) {

        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i][0] + "\t\t" + table[i][1]);
        }
    }
   
   public static void main(Strings []args){
   
    Scanner sc=new Scanner(System.in);
	String s=sc.nextLine();
	
	 String[][] result = findVowelsConsonants(s);
        displayTable(result);
		}
	}	