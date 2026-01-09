package foodloop;

public abstract class FoodItem {

    protected String name;
    protected String category;
    protected double price;

    // stock hidden
    private int stock;

    FoodItem(String name, String category, double price, int stock) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    public boolean isAvailable() {
        return stock > 0;
    }

    protected void reduceStock() {
        if (stock > 0) {
            stock--;
        } else {
            throw new IllegalStateException("Item out of stock");
        }
    }

    public double getPrice() {
        return price;
    }
}
