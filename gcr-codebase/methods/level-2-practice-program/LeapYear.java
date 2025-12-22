//Write a program that takes a year as input and outputs the Year is a Leap Year or not 
import java.util.Scanner;
public class LeapYear{
   public static boolean checkLeapYear(int number){
   if((number%4==0 && number%100!=0) || number%400==0){
   return true;
   }
   else{
   return false;
   }
   }
   public static void main(String[]args){
   
   Scanner sc=new Scanner(System.in);
   int number=sc.nextInt();
   
   boolean isLeapYear=checkLeapYear(number);
       if (isLeapYear) {
            System.out.println("Year is a Leap Year");
        } else {
            System.out.println("Year is not a Leap Year");
        }
    
   }
  } 