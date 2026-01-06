package swiftcart;

import java.util.ArrayList;

class Cart implements ICheckout {

    private ArrayList<Product> products;
    private double totalPrice;  

    
    public Cart() {
        this.products = new ArrayList<>();
        this.totalPrice = 0;
    }
  
    public Cart(ArrayList<Product> products) {
        this.products = products;
        calculateTotal();
    }

    public void addProduct(Product p) {
        products.add(p);
        totalPrice += p.getTotalPrice(); 
    }

    private void calculateTotal() {
        totalPrice = 0;
        for (Product p : products) {
            totalPrice += p.getTotalPrice();
        }
    }

    @Override
    public void applyDiscount() {
        double discount = 0;
        for (Product p : products) {
            discount += p.getDiscount();   
        }
        totalPrice = totalPrice - discount; 
    }

    @Override
    public void generateBill() {
        System.out.println("SwiftCart Bill");
        for (Product p : products) {
            System.out.println(p.name + " | Qty: " + p.quantity + " | ₹" + p.getTotalPrice());
        }
        System.out.println("Final Amount: ₹" + totalPrice);
    }
}
