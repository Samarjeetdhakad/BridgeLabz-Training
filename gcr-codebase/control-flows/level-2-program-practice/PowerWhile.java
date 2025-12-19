//find power of a number
import java.util.*;
public class PowerWhile{
	public static void main(String[]args){
		
		Scanner sc = new Scanner(System.in);
		
		int number , power, result=1;
		number= sc.nextInt();
		power= sc.nextInt();
		int counter = 1;
		if(number>0 && power>0){
			while(power >= counter ){
				result = number * result;
				counter++;
			}
			System.out.println(result);
		}
	}
}