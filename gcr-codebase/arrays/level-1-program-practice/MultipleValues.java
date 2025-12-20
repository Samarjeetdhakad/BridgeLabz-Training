//Write a program to store multiple values in an array up to a maximum of 10 or until the user enters a 0 or a negative number. Show all the numbers as well as the sum of all numbers 
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
