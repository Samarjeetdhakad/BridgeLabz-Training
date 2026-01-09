package medistore;

import java.time.LocalDate;

public abstract class Medicine implements ISellable {

    private String name;
    private double price;          
    private int quantity;           
    protected LocalDate expiryDate;

    // Default quantity constructor
     Medicine(String name, double price, LocalDate expiryDate){
        this(name, price, expiryDate, 10);
    }

    // Parameterized constructor
     Medicine(String name, double price, LocalDate expiryDate, int quantity){
        this.name = name;
        this.price = price;
        this.expiryDate = expiryDate;
        this.quantity = quantity;
    }

    // Encapsulation: stock not directly modifiable
    public int getQuantity() {
        return quantity;
    }

    protected void reduceStock(int qty) {
        if (qty <= quantity) {
            quantity -= qty;
        } else {
            throw new IllegalArgumentException("Insufficient stock");
        }
    }

    // Sensitive pricing logic hidden
    private double applyDiscount(double total) {
        return total > 500 ? total * 0.90 : total;
    }

    @Override
    public double sell(int qty) {
        reduceStock(qty);                       
        double total = price * qty;               
        return applyDiscount(total);
    }
}
