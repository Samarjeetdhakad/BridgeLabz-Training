package com.generics.smartwarehousesystem;

public class Electronics extends WarehouseItem{
	
	public Electronics(String name, double price) {
		super(name, price);
	}
	
	public String getCategory() {
        return "Electronics";
    }
}
