import java.util.Scanner;

public class StudentScore {
      public static int[][] generateMarks(int students) {
        int[][] marks = new int[students][3];

        for(int i = 0; i < students; i++) {
            marks[i][0] =(int)(Math.random()*90)+10; 
            marks[i][1] =(int)(Math.random()*90)+10; 
            marks[i][2] =(int)(Math.random()*90)+10; 
      }
        return marks;
    }
    // calculate total, average, percentage
    public static double[][] calculateResult(int[][] marks) {
        int students = marks.length;
        double[][] result=new double[students][3];
        for (int i=0;i<students;i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;
            result[i][0] = total;
            result[i][1] = Math.round(average * 100.0) / 100.0;
            result[i][2] = Math.round(percentage * 100.0) / 100.0;
      }
        return result;
    }
    // Method to find grade
    public static String getGrade(double percentage) {
        if (percentage >= 80) return "A";
         else if (percentage >= 70) return "B";
         else if (percentage >= 60) return "C";
         else if (percentage >= 50) return "D";
         else if (percentage >= 40) return "E";
         else return "R";
   }
    // Method to display scorecard
    public static void displayScoreCard(int[][] marks, double[][] result) {
    for (int i = 0; i < marks.length; i++) {
            System.out.println(  (i + 1) + "\t" +  marks[i][0] + "\t" +   marks[i][1] + "\t" + marks[i][2] + "\t" + (int)result[i][0] + "\t" +
                result[i][1] + "\t" +  result[i][2] + "\t" +  getGrade(result[i][2]));
      }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int students = sc.nextInt();
        int[][] marks = generateMarks(students);
        double[][] result = calculateResult(marks);
        displayScoreCard(marks, result);
  }
}
