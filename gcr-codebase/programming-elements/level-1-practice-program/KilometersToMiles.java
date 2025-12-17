// program to convert distance in kilometers to miles
import java.util.*;
public class KilometersToMiles{
	public static void main(String[]args){
		
		// creating variables 
		double km,miles ;
		Scanner input = new Scanner(System.in);
		km=input.nextDouble();
		miles=km/1.6;
		
		//showing the conversion of distance
		System.out.println(" The total miles is" + miles + "mile for the given" + km+ "km");
		
	}
}