public class DiscountedAmount{
public static void main(String[]args){
double fee = 125000 , discountPercent =10 ;
double discount = (125000*10)/100;
double feeToPay= 125000-discount;
System.out.println("The discount amount is INR" + discount + "and final discounted fee is INR " + feeToPay);
}
}