//Create a program to find the shortest, tallest, and mean height of players present in a football team.
import java.util.Scanner;
import java.util.Random;

public class FootballTeam{
   public static int findSum(int []arr){
   int sum=0;
   for(int height:arr){
   sum+=height;
   }
   return sum;
   }
   public static double findMean(int arr[]){
   int sum=findSum(arr);
   return (double) sum/arr.length;
   }
   
   public static int shortest(int arr[]){
   int min=arr[0];
   for(int height:arr){
   if(height<min){
   min=height;
   }
  }
return min;
}

   public static int tallest(int arr[]){
  int max=arr[0];
  for(int height:arr){
   if(height>max){
max=height;
}
}
return max;
  }
 
   public static void main(String[]args){
   
   Scanner sc=new Scanner(System.in);
   int heights[]=new int[11];
    Random random=new Random();
	
	for(int i=0;i<heights.length;i++){
	heights[i]=150+random.nextInt(101);
	}
	
	for(int h:heights){
	System.out.print(h+" ");
}	
System.out.println();
   
   int sum=findSum(heights);
   double mean=findMean(heights);
   int shortest=shortest(heights);
   int tallest=tallest(heights);
   
           System.out.println("Sum of heights " + sum + " cm");
        System.out.println("Mean height " + mean + " cm");
        System.out.println("Shortest player " + shortest + " cm");
        System.out.println("Tallest player " + tallest + " cm");
		}
	}	