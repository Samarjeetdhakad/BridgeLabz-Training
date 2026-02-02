package com.lambdaexpression.ecommerce;

public class Product{
private int price;
private int rating;
private int discount;
Product(int price,int rating,int discount){
	this.price=price;
	this.rating=rating;
	this.discount=discount;
}
public int getPrice() {
	return price;	
}
public int getRating() {
	return rating;
}
public int getDiscount() {
	return discount;
}
public String toString() {
	return "price : " + price + "rating :"+ rating+ "discount  :"+discount;
}
}