//Write a program to calculate the grade and percentage of students
import java.util.*;

public class StudentGrade{

    // Used Method to calculate grade
    public static char calculateGrade(double percentage) {
        if (percentage >= 80)
            return 'A';
        else if (percentage >= 70)
            return 'B';
        else if (percentage >= 60)
            return 'C';
        else if (percentage >= 50)
            return 'D';
        else if (percentage >= 40)
            return 'E';
        else
            return 'R';
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
		
		//take user input
        int n = sc.nextInt();
        int[] physics = new int[n];
        int[] chemistry = new int[n];
        int[] maths = new int[n];
        double[] percentage = new double[n];
        char[] grade = new char[n];

        for (int i = 0; i < n; i++) {
            physics[i] = sc.nextInt();
            chemistry[i] = sc.nextInt();
            maths[i] = sc.nextInt();

            if (physics[i] < 0 || chemistry[i] < 0 || maths[i] < 0) {
                i--; 
                continue;
            }
            int total = physics[i] + chemistry[i] + maths[i];
            percentage[i] = (total / 300.0) * 100;
            grade[i] = calculateGrade(percentage[i]);
        }

        // showing results
        for (int i = 0; i < n; i++) {
            System.out.println("Student "+(i+1));
            System.out.println("Physics: "+physics[i]);
            System.out.println("Chemistry: "+chemistry[i]);
            System.out.println("Maths: "+maths[i]);
            System.out.printf("Percentage: %.2f%%\n", percentage[i]);
            System.out.println("Grade: "+grade[i]);
        }
    }
}
