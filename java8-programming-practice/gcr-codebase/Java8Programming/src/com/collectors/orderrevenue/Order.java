package com.collectors.orderrevenue;

public class Order {
private String customerName;
private double amount;

Order(String customerName,double amount){
	this.customerName=customerName;
	this.amount=amount;
}
public String getCustomerName() {
	return customerName;
}
public double getAmount() {
	return amount;
}
@Override
public String toString() {
	return customerName+ " "+ amount;
}
}