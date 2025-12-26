import java.util.Scanner;
public class PrimeNumber{
public static boolean checkPrime(int number){
 
      if(number<=1){
	  return false;
	  }
	  for(int i=2;i<number/2;i++){
	  if(number%i==0){
	  return false;
	  }
	  }
	  return true;  
	  } 
	  
  public static void main(String[]args){
  Scanner sc=new Scanner(System.in);
  int number=sc.nextInt();
  boolean primenumber=checkPrime(number);
  if(primenumber){
  System.out.println(number + " is a Prime Number");
  }
  else{
      System.out.println(number + " is Not a Prime Number");
      }
  }
  }