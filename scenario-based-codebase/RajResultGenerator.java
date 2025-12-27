//write a program for rajas coaching result
import java.util.Scanner;

public class RajResultGenerator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] marks = new int[5];
        int total = 0;
        double average;
        char grade;
		
        System.out.println("Enter marks for 5 subjects:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
            total += marks[i];
        }
        average = total / 5.0;
        System.out.println("Average Marks: " + average);

        switch ((int) average / 10) {
            case 10:
            case 9:
                grade = 'A';
                break;
            case 8:
            case 7:
                grade = 'B';
                break;
            case 6:
                grade = 'C';
                break;
            case 5:
            case 4:
                grade = 'D';
                break;
            default:
                grade = 'F';
        }

        System.out.println("Grade: " + grade);

    }
}
