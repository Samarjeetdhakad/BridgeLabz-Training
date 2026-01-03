package com.inheritance.hybridinheritance.RestaurantManagementSystem;

public class RestaurantDemo {
    public static void main(String[] args) {

        Chef chef=new Chef();
        chef.name="Rahul";
        chef.id=101;

        chef.displayPerson();
        chef.performDuties();

        System.out.println();

        Waiter waiter=new Waiter();
        waiter.name="Amit";
        waiter.id=102;

        waiter.displayPerson();
        waiter.performDuties();
    }
}
