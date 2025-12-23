import java.util.Scanner;
public class CollinearPoints{
    public static boolean checkCollinearUsingSlope( double x1, double y1,double x2, double y2,
      double x3,double y3){

  
           if((x2-x1)==0&&(x3-x2)==0){
            return true;
           }
          if((x2 - x1) == 0||(x3 - x2)== 0||(x3 - x1)== 0){
            return false;
        }
        double slopeAB = (y2 - y1) / (x2 - x1);
        double slopeBC = (y3 - y2) / (x3 - x2);
        double slopeAC = (y3 - y1) / (x3 - x1);
        return slopeAB == slopeBC && slopeAB == slopeAC;
      }

    // area of triangle
    public static boolean checkCollinearUsingArea(
            double x1, double y1,
            double x2, double y2,
            double x3, double y3) {

        double area = 0.5 * (
                x1 * (y2 - y3) +
                x2 * (y3 - y1) +
                x3 * (y1 - y2)
        );
        return area == 0;
  }
    public static void main(String[] args) {
	
        Scanner sc = new Scanner(System.in);
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();
        double x3 = sc.nextDouble();
        double y3 = sc.nextDouble();

          boolean slopeResult = checkCollinearUsingSlope(x1, y1, x2, y2, x3, y3);
          boolean areaResult = checkCollinearUsingArea(x1, y1, x2, y2, x3, y3);
        System.out.println(slopeResult ? "Points are Collinear" : "Points are not Collinear");

  }
}
