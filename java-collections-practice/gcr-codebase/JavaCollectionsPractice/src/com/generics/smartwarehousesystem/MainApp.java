package com.generics.smartwarehousesystem;

public class MainApp {

    public static void main(String[] args) {

        Storage<Electronics> electronicsStore = new Storage<>();
        electronicsStore.addItem(new Electronics("Laptop", 60000));

        Storage<Groceries> groceriesStore = new Storage<>();
        groceriesStore.addItem(new Groceries("Rice", 1200));

        Storage<Furniture> furnitureStore = new Storage<>();
        furnitureStore.addItem(new Furniture("Chair", 3000));

        System.out.println("---- Electronics ----");
        WarehouseUtil.displayItems(electronicsStore.getItems());

        System.out.println("---- Groceries ----");
        WarehouseUtil.displayItems(groceriesStore.getItems());

        System.out.println("---- Furniture ----");
        WarehouseUtil.displayItems(furnitureStore.getItems());
    }
}
