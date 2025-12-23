//Write a program that generates five 4 digit random values and then finds their average value, and their minimum and maximum value. Use Math.random(), Math.min(), and Math.max().
import java.util.Scanner;
  public class Random{
  //method to generate random values
  public int[] generate4DigitRandomArray(int size){
   int numbers[]=new int[size];
   for(int i=0;i<size;i++){
   numbers[i]=(int) (Math.random)()*9000)+1000;
   }
   return numbers;
   }
   public double[] findAverageMinMax(int[] numbers) {
   if(numbers.length==0){
   return new double [] {0,0,0};
   
   int min=numbers[0];
   int max=numbers[0];
   int sum=0;
   
        for(int num : numbers) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            sum += num;
           }
		   double average=(double)sum/numbers.length;
		    return new double[]{average, min, max};
}

     public static void main(String[]args){
	 
	 Scanner sc=new Scanner(System.in);
	 int size=sc.nextInt();
	 int randomNumbers[]=generate4DigitRandomArray(size);
	 double[] avg=findAverageMinMax(randomNumbers);
	 System.out.println("Average: " + avg[0]);
        System.out.println("Minimum: " + (int) avg[1]);
        System.out.println("Maximum: " + (int) avg[2]);
		}
	}
	 