package com.generics.dynamiconlinemaplace;
class DiscountService {

    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {

        double discount = product.getPrice() * (percentage / 100);
        double finalPrice = product.getPrice() - discount;

        product.setPrice(finalPrice);
    }
}
