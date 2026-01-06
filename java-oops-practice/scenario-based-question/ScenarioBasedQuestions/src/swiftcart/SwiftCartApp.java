package swiftcart;

public class SwiftCartApp {
    public static void main(String[] args) {

        Product milk=new PerishableProduct("Milk", 50, 2);
        Product rice=new NonPerishableProduct("Rice", 60, 5);

        Cart cart=new Cart();
        cart.addProduct(milk);
        cart.addProduct(rice);

        cart.applyDiscount();
        cart.generateBill();
    }
}

