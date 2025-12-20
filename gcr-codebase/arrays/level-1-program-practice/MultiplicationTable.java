//Create a program to print a multiplication table of a number.

import java.util.Scanner;
public class MultiplicationTable{
   public static void main (String[]args){
    
	Scanner sc=new Scanner(System.in);
	int number=sc.nextInt();
	
	int multiplication[]=new int[10];
	
	      for (int i = 1; i <= 10; i++) {
            multiplication[i - 1] = number * i;
        }

       
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " * " + i + " = " + multiplication[i - 1]);
        }
	}
}	