//Write a program to calculate various trigonometric functions using Math class given an angle in degrees
import java.util.Scanner;
public class Trigonometry{
   public static double[] calculateTrigonometricFunctions(double angle) {
   double radians=Math.toRadians(angle);
   double [] result=new double[3];
       result[0] = Math.sin(radians);   
       result[1] = Math.cos(radians);   
       result[2] = Math.tan(radians);   

        return result;
    }
   public static void main(String[]args){
   
   Scanner sc=new Scanner(System.in);
   double angle=sc.nextInt();
   double [] values=calculateTrigonometricFunctions(angle);
   
   
        System.out.println("Sine = " + values[0]);
        System.out.println("Cosine = " + values[1]);
        System.out.println("Tangent = " + values[2]);
		}
}