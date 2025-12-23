//Write a program for Euclidean distance between two points as well as the equation of the line using those two points. Use Math functions Math.pow() and Math.sqrt()

import java.util.Scanner;
public class Bonus{
   public static double findDistance(double x1,double y1,double x2,double y2){
   
        double dx = Math.pow(x2 - x1, 2);
        double dy = Math.pow(y2 - y1, 2);

        return Math.sqrt(dx + dy);
		}
    public static double[] findEquation(double x1, double y1,
                                            double x2, double y2) {
        double m = (y2 - y1)/(x2 - x1);   
        double b = y1 - m * x1;           
        return new double[] { m, b };
    }
  public static void main(String[]args){
    Scanner sc=new Scanner(System.in);
	double x1=sc.nextInt();
    double y1=sc.nextInt();
	double x2=sc.nextInt();
  double y2=sc.nextInt();;
	
	    double[] line = findEquation(x1, y1, x2, y2);
        System.out.println( line[0]);
        System.out.println( line[1]);
        System.out.println("y = " + line[0] + "x + " + line[1]);

}
}