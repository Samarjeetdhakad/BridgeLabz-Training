// Write a program that takes three integer inputs from the user and finds the
//maximum of the three numbers.
import java.util.Scanner;
public class MaximumNumber{
 public static int findMaxNumber(int number1,int number2,int number3){
     int max=number1;
	 if(number2>max){
	 max=number2;
	 }
	 if(number3>max){
	 max=number3;
	 }
	 return max;
	 }
   public static void main(String[]args){
   Scanner sc=new Scanner(System.in);
   int number1=sc.nextInt();
    int number2=sc.nextInt();
    int number3=sc.nextInt();
	
	int max=findMaxNumber(number1,number2,number3);
	System.out.println(max);
	}
	}
   