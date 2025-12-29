//write a program to calculate the discount based on the price
import java.util.Scanner;

public class Discount{
	public static void main(String[]args){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the items quantity");
		int items = sc.nextInt();
		
		int[] price = new int[items];
		int totalprice=0;
		
		for(int i=0; i<items; i++){
			System.out.println("enter the price of item");
			price[i]= sc.nextInt();	
			totalprice  += price[i];
			
		}
		
		int discount;
		if(totalprice>500 && totalprice <1000 ){
			System.out.println("you will get 5% discount");
			discount = (int)(totalprice *0.05);			
		}
		else if (totalprice>1000 && totalprice <3000){
			System.out.println("you will get 15% discount");
			discount = (int)(totalprice *0.15);
		}
		else if (totalprice>3000){
			System.out.println("you will get 15% discount");
			discount = (int)(totalprice *0.30);
		}
		else {
			System.out.println("you will not get discount due to low total price");
			discount = 0;
		}
		
		System.out.println(discount);
		System.out.println("total bill is :" +(totalprice-discount));
		
		
	}
}