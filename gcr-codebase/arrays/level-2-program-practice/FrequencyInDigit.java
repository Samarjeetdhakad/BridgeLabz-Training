//write a program to find the frequency of digits in a number
import java.util.*;
public class FrequencyInDigit{
	public static void main (String[]args){
		
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int count = 0;
		int temp = number;
		
		while(temp!=0){
			count++;
			temp=temp/10;
		}
		int digits[] = new int[count];
		for(int i=0; i<count; i++){
			digits[i]=number % 10;
			number = number/10;
		}
		int frequency[] = new int[10];
		
		for(int i=0; i<count; i++){
			frequency[digits[i]]++;
		}
		
		//showing the frequency of digits
		for (int i =0; i<10; i++){
			if(frequency[i]>0){
				System.out.println("digit"+i+"frequency is" + frequency[i] +"\n");
			}
		}
	}
}
