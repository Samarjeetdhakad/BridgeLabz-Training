import java.util.Scanner;
public class LibraryReminder{
  public static void main(String[]args){
  
  Scanner sc=new Scanner(System.in);
  	int finePerDay=5;
  for(int i=1;i<=5;i++){
  
  System.out.println("enter return date");
  int returnDate=sc.nextInt();
    System.out.println("enter due date");
	int dueDate=sc.nextInt();
	

	if(returnDate>dueDate){
	int lateDays=returnDate-dueDate;
	int fine=lateDays*finePerDay;
	           System.out.println("Book returned late by "+ lateDays + " days");
                System.out.println("Fine" + fine);
            }
			else {
                System.out.println(" No fine");
        }
        }
        System.out.println("Thank you for using the Library Reminder App");
}
}