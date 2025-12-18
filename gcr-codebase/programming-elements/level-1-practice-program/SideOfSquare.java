// finding side of square whose parameter is taken from the user 
import java.util.*;
public class SideOfSquare{
	public static void main(String[]args){
		
		//take input from the user
		double parameter, side;
		Scanner input = new Scanner(System.in);
		parameter = input.nextDouble();
		side = parameter/4;
		
		//showing the side of square
System.out.println("The length of the side is " + side + " whose perimeter is" + parameter);
}
}