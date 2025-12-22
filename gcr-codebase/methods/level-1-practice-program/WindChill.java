//write a program to find the wind chill temperature with the help of method
import java.util.*;
public class WindChill{
	
	public static double findWindchillTemperature(double temperature, double speed){
		double windChill;
		windChill = 35.74 + 0.6215 *temperature + (0.4275*temperature - 35.75) * Math.pow(speed, 0.16);
		return windChill;
	}
	public static void main(String[]args){
		
		Scanner sc = new Scanner(System.in);
		
		double temperature= sc.nextDouble();
		double windSpeed = sc.nextDouble();
		
		double windchillTemperature ;
		
		windchillTemperature = findWindchillTemperature (temperature, windSpeed);
		System.out.println(windchillTemperature);
		
	}
}