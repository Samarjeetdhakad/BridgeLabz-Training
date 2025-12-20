//Working with Multi-Dimensional Arrays. Write a Java program to create a 2D Array and Copy the 2D Array into a single dimension array
import java.util.Scanner;
public class //Write a program to store multiple values in an array up to a maximum of 10 or until the user enters a 0 or a negative number. Show all the numbers as well as the sum of all numbers 
import java.util.Scanner;
public class MultipleValues{
   public static void main (String[] args){
   
   Scanner sc=new Scanner(System.in);
   double numbers[] =new double[10];
   double total=0.0;
   int index=0;
    
	
	while (true) {

            double input = sc.nextDouble();

            // Break if input is 0 or negative
            if (input <= 0) {
                break;
            }

            // Break if array size limit is reached
            if (index == 10) {
                break;
            }
            numbers[index] = input;
            index++;
        }

        
        for (int i = 0; i < index; i++) {
            System.out.println(numbers[i]);
            total = total + numbers[i];
        }

      
        System.out.println("Total = " + total);
    }
}
{
   public static void main(String[]args){
   
   Scanner sc=new Scanner(System.in);
   
   //Take two variables input
   int rows=sc.nextInt();
   int columns=sc.nextInt();
   
   //create two dimensional array
   int matrix[][]=new int[rows][columns];
   for(int i=0;i<rows;i++){
      for(int j=0;j<columns;j++){
	  matrix[i][j]=sc.nextInt();
	  }
	}  
	int array[]=new int[rows*columns];
	int index=0;
	
	// Copy elements from 2D array to 1D array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[index] = matrix[i][j];
                index++;
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
	}
}
         