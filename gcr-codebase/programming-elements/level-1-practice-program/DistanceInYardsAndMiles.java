// Finding the distance in yards and miles 
import java.util.*;
public class DistanceInYardsAndMiles{
	public static void main(String[]args){
		
		// Take input of distance in feet
		Scanner input = new Scanner(System.in);
		double distanceInFeet = input.nextDouble();
		double distanceInYards =(1.0/3.0) * distanceInFeet; 
		double distanceInMiles =  (1.0/1760.0) * distanceInYards;
		
		//showing the distance in yards and miles
		System.out.println("your distance in yards" + distanceInYards + "while in feet" + distanceInFeet + "and miles is " + distanceInMiles);
	}
}