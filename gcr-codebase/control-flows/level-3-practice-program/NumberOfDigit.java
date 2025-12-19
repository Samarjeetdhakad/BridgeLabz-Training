//Create a program to count the number of digits in an integer.
import java.util.Scanner;
public class NumberOfDigit{
  public static void main(String[]args){
  
  Scanner sc=new Scanner(System.in);
  int number=sc.nextInt();
  int count=0;
  
  while(number!=0){
  number=number/10;
  count++;
  }
  System.out.println("The count of the" + number+ ":" + count); 
  }
}  