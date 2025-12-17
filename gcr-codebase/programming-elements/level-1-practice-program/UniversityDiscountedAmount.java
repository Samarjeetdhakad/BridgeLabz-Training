// program to find univerity discount by tsking user input 
import java.util.*;
public class DiscountedAmount{
	public static void main(String[]args){
	
	//initializing and taking user input for university fee
	double fee;
	Scanner input = new Scanner(system.in);
	fee = input.nextdouble();
	double discountPercent;
	discountPercent = input.nextdouble():
	double discount = fee * discountPercent/ 100;
	double discoutedFee= fee-discount;
	
	
	System.out.println("The discount amount is INR" + discount + "and final discounted fee is INR " + discoutedFee);
	
	}
}