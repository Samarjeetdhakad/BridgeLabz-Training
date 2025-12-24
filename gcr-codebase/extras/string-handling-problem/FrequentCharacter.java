// write a program to find the most frequent character in the string
import java.util.Scanner;
public class FrequentCharacter{
public static void main(String[]args){
	Scanner sc = new Scanner(System.in);
	String text = sc.nextLine();
	int[] frequency = new int[256];
	
	for(int i=0; i<text.length(); i++){
		char ch = text.charAt(i);
		frequency[ch]++;
	}
	
	int maxcount =0;
	char mostFrequent= 0;
	
	for(int i=0; i<text.length(); i++){
		char ch = text.charAt(i);
		if(frequency[ch]>maxcount){
			maxcount = frequency[ch];
			mostFrequent = ch;
			}
	}
	System.out.println(mostFrequent + " is " + maxcount+ "times");

}
}