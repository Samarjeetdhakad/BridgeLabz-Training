package smartcheckout;

public class Main {
    public static void main(String[] args) {

        SmartCheckout checkout=new SmartCheckout();
        checkout.addItemToStore("Milk", 50, 10);
        checkout.addItemToStore("Bread", 30, 5);
        checkout.addItemToStore("Eggs", 7, 12);
        checkout.addItemToStore("Soap", 40, 2);
        
        Customer c1=new Customer("Suyash");
        c1.addItem("Milk", 2);
        c1.addItem("Bread", 1);

        Customer c2=new Customer("Amit");
        c2.addItem("Eggs", 10);
        c2.addItem("Soap", 1);

        Customer c3=new Customer("Riya");
        c3.addItem("Bread", 4); 

        checkout.addCustomer(c1);
        checkout.addCustomer(c2);
        checkout.addCustomer(c3);
   
        checkout.processNextCustomer();
        checkout.processNextCustomer();
        checkout.processNextCustomer();
  }
}