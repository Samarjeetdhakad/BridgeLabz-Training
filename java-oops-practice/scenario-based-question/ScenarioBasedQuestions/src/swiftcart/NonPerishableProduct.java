package swiftcart;

class NonPerishableProduct extends Product {

    public NonPerishableProduct(String name, double price, int quantity) {
        super(name, price, "Non-Perishable", quantity);
    }

    @Override
    double getDiscount() {
        return getTotalPrice() * 0.05;
    }
}
