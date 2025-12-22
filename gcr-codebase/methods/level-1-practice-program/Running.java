//Write a program to find the number of rounds will have to do to complete the 5 km running 
import java.util.*;
public class Running{
	public static double getRound(double parameter, int distance){
		double rounds = distance / parameter;
		return rounds;
	}
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		
		int distance = 5;
		double side1 = sc.nextDouble();
		double side2 = sc.nextDouble();
		double side3 = sc.nextDouble();
		
		double parameter = side1+ side2 + side3;
		double rounds = getRound(parameter, distance);
		
		System.out.println(rounds);
	}
}