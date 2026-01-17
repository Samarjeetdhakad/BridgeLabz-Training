package callcenter;


public class Main {
	public static void main(String[]args) {
	
	CallCenterManager center=new CallCenterManager();
    Customer c1=new Customer("1", "Suyash", true);
    Customer c2=new Customer("2", "Neha", true);
    Customer c3=new Customer("3", "Arjun", false);
    Customer c4=new Customer("2", "Neha", true); 

    center.receiveCall(c1);
    center.receiveCall(c2);
    center.receiveCall(c3);
    center.receiveCall(c4);

    center.printQueues();

    center.serveNextCustomer();
    center.serveNextCustomer();
    center.serveNextCustomer();
    center.serveNextCustomer();
}
}