package smartcheckout;

import java.util.*;
class Customer {
    String customerName;
    ArrayList<Item>cart=new ArrayList<>();
    Customer(String customerName) {
        this.customerName=customerName;
 }
    public void addItem(String item, int qty) {
        cart.add(new Item(item, qty));
}
}