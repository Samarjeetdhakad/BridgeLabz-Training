// write a program to find the number of students present and absent
import java.util.Scanner;
public class BusAttendance{
	public static void main(String[]args){
		Scanner sc = new Scanner (System.in);
		String[] names = new String[10];
		int present=0, absent=0;
		for(int i=0; i<10; i++){
			System.out.println("enter the name");
			names[i] = sc.next();			
		}
		for(String name :names){
			System.out.println(name + "Is presents or absents");
			String attendance = sc.next();
			if(attendance.toLowerCase().equals("presents")){
				present++;
			}
			else{
				absent++;
			}
			
		}
		
		System.out.println("present students are " + present);
		System.out.println("absent students are " + absent);
		
	}
}