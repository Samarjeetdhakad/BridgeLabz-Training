import java.util.*;
public class SimpleInterest{
	
	public static double getSimpleInterest(double principle, double rate, double time){
		double simpleInterest;
		return simpleInterest= principle*rate*time/100;
	}
	public static void main(String[]args){
		
		Scanner sc= new Scanner(System.in);
		
		double principle=sc.nextDouble();
		double rate=sc.nextDouble();
		double time=sc.nextDouble();
		
		double simpleInterest;
		simpleInterest=getSimpleInterest( principle,  rate,  time);
		
		System.out.println("The Simple Interest is " + simpleInterest + "for Principal " + principle +", Rate of Interest " + rate + "and Time" +time);
		
		
		
	}
}