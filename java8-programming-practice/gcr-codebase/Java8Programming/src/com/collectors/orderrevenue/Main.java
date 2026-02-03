
package com.collectors.orderrevenue;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
public static void main(String[]args) {
	List<Order> orders=List.of(
		    new Order("Amit", 1200.50),
		    new Order("Neha", 800.00),
		    new Order("Amit", 500.75),
		    new Order("Neha", 300.25),
		    new Order("Rahul", 1500.00)
		);
	Map<String , Double> sum=orders.stream().collect(Collectors.groupingBy(Order:: getCustomerName,Collectors.summingDouble(Order::getAmount)));
	System.out.println(sum);
}
}