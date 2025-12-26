import java.util.Scanner;
public class CoffeeCounter{
  public static void main(String[]args){ 
   Scanner sc= new Scanner(System.in);
   String coffeeType;
  double gstRate = 0.18;

    while (true) {
            System.out.println("Enter coffee type (espresso / latte / hotchocolate) or type 'exit' to stop");
            coffeeType = sc.next().toLowerCase();

            if (coffeeType.equals("exit")) {
                System.out.println("Thank you! Coffee shop closed");
                break;
            }
   
   double price=0.0;
   switch (coffeeType){
   case "espresso":
   price=120;
   break;
   
   case "latte":
   price=140;
   break;
   
   case "hotchocolate":
   price=180;
   break;
   
   default:
   System.out.println("Invalid coffee type");
    continue;
    }

    int quantity=sc.nextInt();
	double total=price*quantity;
	double gst = total * gstRate;
    double finalBill = total + gst;
			
			
            System.out.println("Bill Details");
            System.out.println("Coffee Type : " + coffeeType);
            System.out.println("Price : " + price);
            System.out.println("Quantity : " + quantity);
            System.out.println("Total : " + total);
            System.out.println("GST : " + gst);
            System.out.println("Final Bill: " + finalBill);
	}
  }
}