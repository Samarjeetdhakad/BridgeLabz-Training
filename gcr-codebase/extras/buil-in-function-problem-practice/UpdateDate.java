//write to take input of date and convert it by adding days and substracting
import java.time.LocalDate;
import java.util.Scanner;
public class UpdateDate{
	public static void main(String[]args){
		
		Scanner sc =  new Scanner(System.in);
		
		LocalDate date = LocalDate.parse(sc.nextLine());
		
		LocalDate updatedDate = date.plusDays(7).plusMonths(1).plusYears(2);
		
		updatedDate = updatedDate.minusWeeks(3);
		
		System.out.println(updatedDate);
	}
}