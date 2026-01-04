package com.encapsulationpolymorphisminterfaceandabstract.onilinefooddeliverysystem;

public class OnlineFoodDeliverySystem {

    public static void processOrder(FoodItem item) {

        item.getItemDetails();

        double totalPrice = item.calculateTotalPrice();
        double discount = 0;

        if (item instanceof Discountable) {
            Discountable d = (Discountable) item;
            discount = d.applyDiscount();
            System.out.println(d.getDiscountDetails());
        }

        double finalAmount = totalPrice - discount;

        System.out.println("Total Price : " + totalPrice);
        System.out.println("Discount    : " + discount);
        System.out.println("Final Amount: " + finalAmount);
    }

    public static void main(String[] args) {

        FoodItem item1=new VegItem("Paneer Burger", 120, 2);
        FoodItem item2=new NonVegItem("Chicken Biryani", 250, 1);

        FoodItem[] order={ item1, item2 };

        for (FoodItem item : order) {
            processOrder(item);
        }
    }
}
