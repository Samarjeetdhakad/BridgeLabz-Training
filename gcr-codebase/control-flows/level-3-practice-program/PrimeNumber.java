//Write a Program to check if the given number is a prime number or not

import java.util.Scanner;
public class PrimeNumber{
  public static void main(String[]args){
  
   Scanner sc=new Scanner(System.in);
   int number =sc.nextInt();
   
   //take the boolean variable
   boolean isPrime=true;
   
   //check if the number is greater than 1 or not
   if(number<=1){
   isPrime=false;
   }
   else{
   for(int i=2;i<=number/2;i++){
   if(number%i==0){
   isPrime=false;
   
  }
} 
if(isPrime){
System.out.println(number + "is a prime number");
}
else{
System.out.println(number + "is not a prime number");
}
}
}
}