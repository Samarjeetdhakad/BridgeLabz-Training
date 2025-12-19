//Create a program to check if a number is an Abundant Number.
import java.util.Scanner;
public class AbundantNumber{
   public static void main(String[]args){
   
   //create a scanner 
   Scanner sc=new Scanner(System.in);
   int number=sc.nextInt();
   int sum=0;
   
   //create a loop
   for(int i=1;i<number;i++){
   if(number%i==0){
   sum+=i;
   }
   }
   
   //showing the output of the number
   if(sum>number){
   System.out.println("AbundantNumber");
   }
   else{
    System.out.println("Not AbundantNumber");
	}
  }   
}