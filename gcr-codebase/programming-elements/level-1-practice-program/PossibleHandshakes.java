//Write the program to find the possible number of handshakes among the students input given by the user
import java.util.*;
public class PossibleHandshakes{
	public static void main(String[]args){
		
		//take input
		Scanner sc=new Scanner(System.in);
		int numberOfStudents=sc.nextInt();
		int posssibleHandshakes = (numberOfStudents*(numberOfStudents-1))/2;
		
		//showing the number  of handshakes
		System.out.println(posssibleHandshakes);
	}
}