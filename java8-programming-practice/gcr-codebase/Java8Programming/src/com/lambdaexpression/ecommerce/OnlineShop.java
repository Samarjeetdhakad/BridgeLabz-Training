package com.lambdaexpression.ecommerce;
	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.List;
	public class OnlineShop {
	    public static void main(String[] args) {
	        List<Product> products=new ArrayList<>();
	        products.add(new Product(60000, 5, 10));
	        products.add(new Product(30000,3, 15));
	        products.add(new Product( 2000,4, 25));
	        Collections.sort(products,(p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
	        System.out.println("Sorted by Price");
	        print(products);
	        Collections.sort(products,(p1, p2) -> Double.compare(p2.getRating(), p1.getRating()));
	        System.out.println(" Sorted by Rating");
	        print(products);
	        Collections.sort(products,(p1, p2) -> Double.compare(p2.getDiscount(), p1.getDiscount()));
	        System.out.println(" Sorted by Discount");
	        print(products);
	    }
	    private static void print(List<Product>products) {
	        for (Product p:products) {
	            System.out.println(p);
	        }
	    }
	}

