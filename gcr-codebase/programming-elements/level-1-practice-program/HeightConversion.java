//converting the height into feet and inches
import java.util.*;
public class HeightConversion{
	public static void main(String[]args){
		
		//taking the user input of height in cm
		double heightCm;
		Scanner input = new Scanner(System.in);
		heightCm = input.nextDouble();
		double heightInches = heightCm / 2.54;
		double heightFeet = heightInches / 12;
		
		System.out.println(" Your Height in cm is" + heightCm +"while in feet is " + heightFeet + "  and inches is  " + heightInches);
		
	
	}

}