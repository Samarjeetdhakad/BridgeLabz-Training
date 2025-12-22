//Write a program to find the sum of n natural numbers using recursive method and compare the result with the formulae n*(n+1)/2 and show the result from both computations is correct. 
import java.util.Scanner;
public class NaturalNumbers{
//create method for sum using recursion
  public static int sumRecursion(int number){
  if(number==0){
  return 0;
  }
  return number+ sumRecursion(number-1);
  }
  
  //create method to check sum using formula
  public static int sumFormula(int number){
  int sum=number*(number+1)/2;
  return sum;
  }
  
   public static void main(String[]args){
   
   Scanner sc=new Scanner(System.in);
   int number=sc.nextInt();
   int recursion=sumRecursion(number);
   int formula=sumFormula(number);
   
	    System.out.println("Sum using recursion: " + recursion);
        System.out.println("Sum using formula: " + formula);
		
  //check whether both the results are equal or not
   if(recursion==formula){
   System.out.println("equal");
   }
   else{
    System.out.println(" not equal");
	}
  }
}	