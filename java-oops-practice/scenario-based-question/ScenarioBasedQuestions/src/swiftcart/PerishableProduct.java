package swiftcart;

class PerishableProduct extends Product {

    public PerishableProduct(String name, double price, int quantity) {
        super(name, price, "Perishable",quantity);
    }

    @Override
    double getDiscount() {
        return getTotalPrice()*0.10; 
    }
}
