package com.multithreading.restaurantorder;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Chef c1=new Chef("chef1","pizza",3000);
		Chef c2=new Chef("chef2","pizza",2000);
		Chef c3=new Chef("chef3","pizza",1000);
		Chef c4=new Chef("chef4","pizza",1500);		
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		
		c1.join();
		c2.join();
		c3.join();
		c4.join();
		System.out.println("Kitchen closed");
		
	}

}