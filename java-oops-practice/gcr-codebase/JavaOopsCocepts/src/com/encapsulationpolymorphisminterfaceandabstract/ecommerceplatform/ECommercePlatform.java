package com.encapsulationpolymorphisminterfaceandabstract.ecommerceplatform;

public class ECommercePlatform {

    public static void printFinalPrice(Product product) {

        double price = product.getPrice();
        double discount = product.calculateDiscount();
        double tax = 0;

        if (product instanceof Taxable) {
            Taxable t = (Taxable) product;
            tax = t.calculateTax();
            System.out.println(t.getTaxDetails());
        }

        double finalPrice=price+tax-discount;

        product.displayProduct();
        System.out.println("Discount: "+discount);
        System.out.println("Tax: "+tax);
        System.out.println("Final Price: "+finalPrice);
    }

    public static void main(String[] args) {

        Product p1 = new Electronics(201, "Laptop", 60000);
        Product p2 = new Clothing(202, "Jacket", 3000);
        Product p3 = new Groceries(203,"Rice",1200);

        Product[] products = { p1, p2, p3 };

        for (Product p : products) {
            printFinalPrice(p);
        }
    }
}