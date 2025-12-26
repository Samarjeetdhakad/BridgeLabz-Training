import java.util.Scanner;
 public class Bmi{
 public static String bmiCheck(double weight,double height){
  double bmi=weight/(height*height);
	 
 if(bmi<18){
 return "underweight";
 }
 else if(bmi>=18 && bmi<25){
 return "normal";
 }
 else if(bmi>=25 && bmi<30){
 return "overweight";
 }
 else{
 return " obese";
 }
 }
 public static void main(String[]args){
    Scanner sc=new Scanner(System.in);
	
	double height=sc.nextDouble();
	double weight =sc.nextDouble();
	
	 String result=bmiCheck(weight,height);
	 
	 System.out.println("Bmi status : " +result);
	 }
	 }
	 