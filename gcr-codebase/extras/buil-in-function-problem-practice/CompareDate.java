//write a program to compare two dates
import java.util.Scanner;
import java.time.LocalDate;
public class CompareDate{
	public static void main(String[]args){
		
		Scanner sc = new Scanner(System.in);
		
		LocalDate date1 = LocalDate.parse(sc.nextLine());
		
		LocalDate date2 = LocalDate.parse(sc.nextLine());
		
		if(date1.isBefore(date2)){
			System.out.println("date1 is before date2");
		}
		else if(date1.isAfter(date2)){
			System.out.println("date1 is after date2");
		}
		else{
			System.out.println("both date are same");
		}
		
		
		
	}
}