//write a program to calculate the average and total of sandeeps number of pushups

import java.util.Scanner;

public class FitnessTracker{
	public static void main(String[]args){
		
		Scanner sc = new Scanner (System.in);
		
		int count[] = new int[7];
		int num=0;
		
		for(int i=0; i<7; i++){
			System.out.println("enter the number of pushups");
			count[i] = sc.nextInt();
			
		}
		
		double total=0;
		
		for(int counts : count){
			if(counts>0){
				total += counts;
				num++;
			}
			continue;			
		}
		double average = (total / num) ;
		
		System.out.println("total : " + total);
		System.out.println("average : " + average);
		
	}
}