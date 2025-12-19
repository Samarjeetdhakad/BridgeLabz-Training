//find power of a number
import java.util.*;
public class Power{
	public static void main(String[]args){
		
		Scanner sc = new Scanner(System.in);
		
		int number , power, result=1;
		number= sc.nextInt();
		power= sc.nextInt();
		
		if(number>0 && power>0){
			for (int i=1; i<=power; i++){
				result = number * result;
			}
			System.out.println(result);
		}
	}
}