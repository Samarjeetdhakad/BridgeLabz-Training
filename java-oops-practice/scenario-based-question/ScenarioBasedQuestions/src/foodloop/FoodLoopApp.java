package foodloop;

import java.util.List;

public class FoodLoopApp {
    public static void main(String[] args) {

        FoodItem burger = new VegItems("Veg Burger", 150, 10);
        FoodItem chicken = new NonVegItem("Chicken Roll", 250, 5);

        Order order = new Order(List.of(burger, chicken));
        order.placeOrder();
    }
}
