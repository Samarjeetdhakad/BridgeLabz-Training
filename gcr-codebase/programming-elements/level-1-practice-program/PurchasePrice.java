//Write a program to take the input of unitprice and quantity to be bought and show total price
import java.util.*;
public class PurchasePrice{
	public static void main(String[]args){
		
		//take input from user
		 Scanner sc = new Scanner(System.in);
		 int unitPrice = sc.nextInt();
		 int quantity = sc.nextInt();
		 int totalPrice = unitPrice * quantity;
		 System.out.println("The total purchase price is INR" + totalPrice +" if the quantity "  + quantity+" and unit price is INR"+unitPrice);

	}
}