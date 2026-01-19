package smartcheckout;

import java.util.*;

class SmartCheckout {
   private Queue<Customer>queue=new LinkedList<>();
   private HashMap<String, Integer>priceMap=new HashMap<>();
   private HashMap<String, Integer> stockMap=new HashMap<>();
   public void addItemToStore(String item, int price, int stock){
   priceMap.put(item, price);
    stockMap.put(item, stock);
    }
  public void addCustomer(Customer c) {
    queue.add(c);
    System.out.println(c.customerName + "joined the queue");
    }
  public void processNextCustomer() {
     if (queue.isEmpty()) {
       System.out.println("No customers in queue");
        return;
    }
      Customer c=queue.poll();
      int totalBill=0;
      System.out.println(" Billing for" + c.customerName);
      for (Item item:c.cart){
        if (!priceMap.containsKey(item.name)){
       System.out.println(item.name + "not available");
       continue;
       }
      int stock=stockMap.get(item.name);
      if (stock<item.qty) {
       System.out.println("Not enough stock for" + item.name + "(Available:" + stock + ")");
        continue;
        }
        int price=priceMap.get(item.name);
        int cost=price*item.qty;
        totalBill+=cost;
        stockMap.put(item.name, stock-item.qty);
        System.out.println(item.name + "x" + item.qty + "=" + cost);
     }
        System.out.println("Total Bill " + totalBill);
  }
}