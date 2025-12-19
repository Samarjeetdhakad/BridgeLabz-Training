//Write a LeapYear program that takes a year as input and outputs the Year is a Leap Year or not a Leap Year.
import java.util.Scanner;
public class LeapYear{
  public static void main (String[]args){
  
  
  //take the year as the input
  Scanner sc=new Scanner(System.in);
  int year=sc.nextInt();
  
  if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
   System.out.println(year + " is a leap year");
   }
  else {
      System.out.println(year + "is not a leap year");
	}
	  
   }
}
  
  