import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

       
        double base = sc.nextDouble();
        double height = sc.nextDouble();

        // Area in square centimeters
        double areaSqCm = 0.5 * base * height;

        
        double baseInInches = base / 2.54;
        double heightInInches = height / 2.54;

        // take the area in square inches
        double areaSqIn = 0.5 * baseInInches * heightInInches;

        
        System.out.println(
            "The Area of the triangle in sq in is " + areaSqIn +
            " and sq cm is " + areaSqCm);

        
    }
}
