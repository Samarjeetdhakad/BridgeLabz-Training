//Write a program to take user input for the age of all 10 students in a class and check whether the student can vote depending on his/her age is greater or equal to 18.
import java.util.Scanner;
import java.util.Random;
public class Voting{

    public static int[] generateStudentAges(int n) {
        int[] ages = new int[n];
        Random random = new Random();   
        for(int i=0; i<n;i++){
            ages[i]=random.nextInt(90)+10;
        }
        return ages;
       }
	   
	   public static String[][] canVote(int[] age){
	   String result[][]=new String[age.length][2];
	   for(int i=0;i<age.length;i++){
	   result[i][0] = String.valueOf(age[i]);
	   
	   if(age[i]<0){
	  result[i][1]="false";
	   }
	   else if(age[i]>=18){
	    result[i][1]="true";
	   }
	   else{
	   result[i][1]= "false";
	   }
	  }
	  return result;
	  }
	  
	  public static void displayTable(String[][] data) {
    for(int i = 0; i < data.length; i++) {
        for (int j = 0; j < data[i].length; j++) {
            System.out.print(data[i][j] + "\t");
      }
        System.out.println();
  }
}
   public static void main(String[]args){
   
   Scanner sc=new Scanner(System.in);
   
   int n=sc.nextInt();
   
     int[]ages = generateStudentAges(n);
        String[][]votingStatus = canVote(ages);
        displayTable(votingStatus);
		}
	}	