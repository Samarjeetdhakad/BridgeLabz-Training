package callcenter;

import java.util.*;
public class CallCenterManager {

    private Queue<Customer>normalQueue=new LinkedList<>();
    private Queue<Customer>vipQueue= new LinkedList<>();
    private HashMap<String,Integer> callCount=new HashMap<>();
    
    public void receiveCall(Customer c){
        int count=callCount.containsKey(c.getId())?callCount.get(c.getId()):0;
        callCount.put(c.getId(),count+1);
        if (c.getVip()){
            vipQueue.add(c);
            System.out.println("VIP " + c);
        }
        else {
            normalQueue.add(c);   
            System.out.println("Normal " + c);
    }
    }
    private Customer getHighestPriorityVIP() {
        if (vipQueue.isEmpty()) return null;
        Customer highest=null;
        int highestCount=-1;
        for (Customer c:vipQueue) {
            int count=callCount.get(c.getId());
            if (count>highestCount){
                highestCount=count;
                highest=c;
         }
        }
        vipQueue.remove(highest);
        return highest;
    }
    public Customer serveNextCustomer() {
        if (!vipQueue.isEmpty()) {
            Customer c=getHighestPriorityVIP();
            System.out.println("Serving VIP " + c);
            return c;
        }
        if (!normalQueue.isEmpty()) {
            Customer c=normalQueue.poll();
            System.out.println("Serving Normal " + c);
            return c;
        }

        System.out.println("No customers in queue");
        return null;
    }
    public void printQueues() {
        System.out.println("VIP Queue " +vipQueue);
        System.out.println("Normal Queue " +normalQueue);
  }
}