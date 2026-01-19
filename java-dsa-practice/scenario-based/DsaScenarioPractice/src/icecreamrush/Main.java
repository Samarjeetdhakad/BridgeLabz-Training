package icecreamrush;

public class Main {
    public static void main(String[] args) {
        // Creating the data for 8 flavors
        Flavor[] weeklySales = {
            new Flavor("Vanilla", 15),
            new Flavor("Chocolate", 42),
            new Flavor("Strawberry", 10),
            new Flavor("Butterscotch", 28),
            new Flavor("Mango", 5),
            new Flavor("Pista", 30),
            new Flavor("Coffee", 18),
            new Flavor("Rocky Road", 22)
        };

        System.out.println("Weekly Sales (Unsorted)");
        display(weeklySales);

        // Calling the sorting logic from the other class
        BubbleSortProvider.sortFlavors(weeklySales);

        System.out.println("\nPopularity Report (Sorted)");
        display(weeklySales);
    }

    public static void display(Flavor[] flavors) {
        for (Flavor f : flavors) {
            System.out.println(f);
        }
    }
}