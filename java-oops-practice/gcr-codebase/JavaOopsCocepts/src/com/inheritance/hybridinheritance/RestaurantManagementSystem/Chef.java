package com.inheritance.hybridinheritance.RestaurantManagementSystem;

class Chef extends Person implements Worker {

    @Override
    public void performDuties() {
        System.out.println("Chef is cooking food.");
    }
}
