//Write a program to take user input for 5 numbers and check whether a number is positive,  negative, or zero. Further for positive numbers check if the number is even or odd. Finally compare the first and last elements of the array and display if they equal, greater or less
import java.util.Scanner;
public class EqualGreater{
   public static void main(String[]args){
   
   Scanner sc=new Scanner(System.in);
   int number[]=new int[5];
   for(int i=0;i<number.length;i++){
   number[i]=sc.nextInt();
   }
   
   //check if the number is positive and check for even or odd
   for(int i=0;i<number.length;i++){
   if(number[i]<0){
   System.out.println("Enter a valid nuber");
   }
   else{
   if(number[i]%2==0){
   System.out.println("even");
   }
   else if(number[i]%2!=0){
    System.out.println("odd");
	}
   else{
   System.out.println("zero");
   }
 }
   }
   
   //check if the first and last element is equal, or less
   if(number[0] == number[number.length-1]){
   System.out.println("equal");
   }
   else if (number[0] < number[number.length-1]){
   System.out.println("less");
   }
   else{
   System.out.println("greater");
       }
     
   
   }
}   