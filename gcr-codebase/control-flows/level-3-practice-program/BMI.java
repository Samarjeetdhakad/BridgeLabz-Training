//Create a program to find the BMI of a person
import java.util.Scanner;
public class BMI{
   public static void main(String[]args){
   
   Scanner sc=new Scanner(System.in);
   double weight=sc.nextInt();
   double height=sc.nextInt();
   
   //convert the height in meter
   double heightMeter = height / 100;

    // Calculate BMI using formula
    double bmi = weight / (heightMeter * heightMeter);
	
	System.out.println("BMI :" + bmi);
	}
}	