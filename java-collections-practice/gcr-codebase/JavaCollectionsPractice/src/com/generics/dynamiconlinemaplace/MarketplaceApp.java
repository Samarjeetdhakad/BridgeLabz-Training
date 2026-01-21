package com.generics.dynamiconlinemaplace;
public class MarketplaceApp {

    public static void main(String[] args) {

        Product<BookCategory> book =
                new Product<>("Java Programming", 500, new BookCategory());

        Product<ClothingCategory> shirt =
                new Product<>("T-Shirt", 800, new ClothingCategory());

        Product<GadgetCategory> phone =
                new Product<>("Smartphone", 15000, new GadgetCategory());

        ProductCatalog catalog = new ProductCatalog();

        catalog.addProduct(book);
        catalog.addProduct(shirt);
        catalog.addProduct(phone);

        DiscountService.applyDiscount(book, 10);
        DiscountService.applyDiscount(phone, 5);

        catalog.showCatalog();
    }
}
