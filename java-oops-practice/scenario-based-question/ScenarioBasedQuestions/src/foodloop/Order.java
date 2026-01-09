package foodloop;

import java.util.ArrayList;
import java.util.List;

public class Order implements IOrderable {

    private List<FoodItem> items = new ArrayList<>();
    private double total;

   
    Order(List<FoodItem> items) {
        this.items = items;
        calculateTotal();
    }

    private void calculateTotal() {
        total = 0;
        for (FoodItem item : items) {
            total += item.getPrice(); 
            item.reduceStock();
        }
        total = applyDiscount(total);
    }

    // Polymorphism target
    protected double applyDiscount(double amount) {
        if (amount > 1000) {
            return amount * 0.85;   
        } else if (amount > 500) {
            return amount * 0.90;  
        }
        return amount;
    }

    @Override
    public void placeOrder() {
        System.out.println("Order placed. Total amount: " + total);
    }

    @Override
    public void cancelOrder() {
        System.out.println("Order cancelled");
    }
}
