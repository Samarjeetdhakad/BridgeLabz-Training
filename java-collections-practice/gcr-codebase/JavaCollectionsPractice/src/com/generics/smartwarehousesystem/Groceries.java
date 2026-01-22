package com.generics.smartwarehousesystem;

public class Groceries extends WarehouseItem{

	public Groceries(String name, double price) {
		super(name, price);
		
	}
	 public String getCategory() {
	        return "Groceries";
	    }

}
