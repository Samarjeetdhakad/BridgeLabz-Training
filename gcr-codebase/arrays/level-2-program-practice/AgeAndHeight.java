//Create a program to find the youngest friends among 3 Amar, Akbar, and Anthony based on their ages and the tallest among the friends based on their heights
import java.util.Scanner;
public class AgeAndHeight{
  public static void main (String[]args){
  
  Scanner sc=new Scanner(System.in);
  int age[]=new int[3];
  int height[]=new int[3];
  for(int i=0;i<3;i++){
  age[i]=sc.nextInt();
  height[i]=sc.nextInt();
}
  int ageIndex=0,heightIndex=0;
  for(int i=0;i<3;i++){
  if(age[i]<age[ageIndex]){
  ageIndex=i;
 }
  if(height[i]>height[heightIndex]){
  heightIndex=i;
    }
  }
    System.out.println("Age: " + age[ageIndex] );

        System.out.println( "Height: " + height[heightIndex]);
		
				}
	}			