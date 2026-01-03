package com.inheritance.hybridinheritance.RestaurantManagementSystem;

class Waiter extends Person implements Worker {

    @Override
    public void performDuties() {
        System.out.println("Waiter is serving customers.");
    }
}
