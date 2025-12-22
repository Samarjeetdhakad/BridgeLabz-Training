////Write a program to take user input for the age of all 10 students in a class and check whether the student can vote depending on his/her age is greater or equal to 18.
import java.util.Scanner;
public class StudentVoteChecker{
     public boolean canStudentVote(int age){
	 if(age<0){
	 System.out.println("Invalid age entered.");
	 return false;
	 }
	 else if(age>=18){
	
	 return true;
	 }
	 else{
	 return false;
	 
	 }
	 }
   
     public static void main(String[]args){
   
   
     Scanner sc=new Scanner(System.in);
     StudentVoteChecker checker = new StudentVoteChecker();
   
   int studentAge[]=new int[10];
   for(int i=0;i<10;i++){
   studentAge[i]=sc.nextInt();
   
        if (checker.canStudentVote(studentAge[i])) {
                System.out.println("Student " + (i + 1) + " can vote.");
            } else {
                System.out.println("Student " + (i + 1) + " cannot vote.");
            }
   }
   
 }
} 