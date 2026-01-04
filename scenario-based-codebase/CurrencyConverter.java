import java.util.Scanner;

public class CurrencyConverter{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		char repeat = 'y';
		while(repeat == 'y'){
		System.out.println("enter the indian amount");
		double INR = sc.nextInt();
		
		System.out.println("select in which currency you want to convert");
		System.out.println("1. DOLLAR");
		System.out.println("2. EURO");
		System.out.println("3.Pound Sterling");
		
		int choice = sc.nextInt();
		
		
		switch(choice){
			case 1:
			System.out.println("INR in dollar : "+ (0.09*INR));
			break;
			
			case 2:
			System.out.println("INR in EURO : "+ (0.009*INR));
			break;
			
			case 3:
			System.out.println("INR in pound : "+ (0.01*INR));
			break;
			
			default :
			System.out.println("choose the correct option  : ");
			break;
			
		}
		
		System.out.println("you want to convert again : y/n");
		repeat = sc.next().charAt(0);
	
		
		
		}
		
	}

}