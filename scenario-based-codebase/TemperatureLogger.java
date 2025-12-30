// write a scenario based question of temperature logger

import java.util.Scanner;

public class TemperatureLogger{
	public static void main(String[]args){
		
		Scanner sc = new Scanner (System.in);
		
		double [] temp = new double[7];
		double total = 0;
		double max = 0;
		for(int i=0; i<7; i++){
			temp[i] = sc.nextDouble();
			total += temp [i];
			if(max < temp[i]){
				max = temp[i];
			}			
		}
		
		double averageTemp = total / 7;
		System.out.println("average temperature is: " + averageTemp);
		System.out.println("max temperature is: " + max);
		
		
	}

}