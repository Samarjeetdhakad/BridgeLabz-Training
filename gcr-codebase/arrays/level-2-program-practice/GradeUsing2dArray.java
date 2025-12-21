//write a program to calculate grade and percentaeg using 2d array
import java.util.Scanner;

public class GradeUsing2dArray {

    public static char calculateGrade(double percentage) {
        if (percentage>=80)
            return 'A';
        else if (percentage>=70)
            return 'B';
        else if (percentage>=60)
            return 'C';
        else if (percentage>=50)
            return 'D';
        else if (percentage>=40)
            return 'E';
        else
            return 'R';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] marks = new int[n][3]; 
        double[] percentage = new double[n];
        char[] grade = new char[n];
        for (int i=0;i<n;i++) {
            marks[i][0]=sc.nextInt();
            marks[i][1]=sc.nextInt();
            marks[i][2]=sc.nextInt();
            if (marks[i][0]<0||marks[i][1]<0||marks[i][2] < 0) {
                i--; 
                continue;
            }
            int total = marks[i][0]+marks[i][1]+marks[i][2];
            percentage[i] = (total / 300.0) * 100;
            grade[i] = calculateGrade(percentage[i]);
        }

        // Display result
        for (int i = 0; i < n; i++) {
            System.out.println("Student "+(i + 1));
            System.out.println("Physics: "+marks[i][0]);
            System.out.println("Chemistry: "+marks[i][1]);
            System.out.println("Maths: "+marks[i][2]);
            System.out.printf("Percentage: %.2f%%\n", percentage[i]);
            System.out.println("Grade: "+grade[i]);
        }

        sc.close();
    }
}
