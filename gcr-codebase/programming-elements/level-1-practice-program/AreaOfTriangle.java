//finding area of traingle by taking user input
import java.util.*;
public class AreaOfTriangle{
	public static void main(String[]args){
		
		//take the input from the user in inches
		double height , base;
		Scanner input = new Scanner (System.in);
		base = input.nextDouble();
		height = input.nextDouble();
		double areaInInches = 0.5 * base * height;
		double areaInCm = 0.5 * ( base*2.54 )* (height * 2.54);
		
		//showing the area of tringle in cm and inches
		System.out.println("Your area in sqcm is " + areaInCm + " area in sqinches is " + areaInInches );
		
	}
}