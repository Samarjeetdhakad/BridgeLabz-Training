package icecreamrush;

public class Flavor {
    String name;
    int sales;

    public Flavor(String name, int sales) {
        this.name = name;
        this.sales = sales;
    }

    @Override
    public String toString() {
        return String.format("%-15s |Sales: %d", name, sales);
    }
}