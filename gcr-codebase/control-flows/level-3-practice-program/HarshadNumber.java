//Create a program to check if a number taken from the user is a Harshad Number.
import java.util.Scanner;
public class HarshadNumber{
  public static void main(String[]args){
  
  Scanner sc=new Scanner(System.in);
  int number=sc.nextInt();
  
  //create another variable sum and initialize it with 0
  int sum=0;
  
  while(number!=0){
  sum+=number%10;
  number/=10;
  }
  if(number%sum==0){
  System.out.println("Harshad number");
  }
  else{
  System.out.println(" Not Harshad number");
     }
   }
 }