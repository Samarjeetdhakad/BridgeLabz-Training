import java.util.Scanner;

public class BMIProgram {

    // Method to calculate BMI
    public static double calculateBMI(double weight, double height) {
        return weight/(height * height);
    }

    public static String getStatus(double bmi) {
        if (bmi <=18.4) {
            return "Underweight";
        } else if (bmi <=24.9) {
            return "Normal";
        } else if (bmi <= 39.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double[] weight=new double[n];
        double[] height=new double[n];
        double[] bmi=new double[n];
        String[] status=new String[n];

        for (int i=0;i<n;i++) {
            weight[i]=sc.nextDouble();
            height[i]=sc.nextDouble();
            bmi[i]=calculateBMI(weight[i], height[i]);
            status[i]=getStatus(bmi[i]);
        }

        for (int i=0;i<n;i++) {
          System.out.printf("%.2f\t%.2f\t%.2f\t%s%n", height[i], weight[i], bmi[i], status[i]);

        }

        sc.close();
    }
}
