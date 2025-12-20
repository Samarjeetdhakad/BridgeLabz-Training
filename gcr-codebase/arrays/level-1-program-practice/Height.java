//Create a program to find the mean height of players present in a football team.
import java.util.Scanner;
public class Height{
   public static void main(String[]args){
	   Scanner sc=new Scanner(System.in);
   double height[]=new double[11];
   
   for(int i=0;i<height.length;i++){
   height[i]=sc.nextDouble();
   }
   double sum=0.0;
   for(int i=0;i<height.length;i++){
   sum+=height[i];
   }
   double meanHeight=sum/height.length;
   System.out.println(meanHeight);
   }
}   