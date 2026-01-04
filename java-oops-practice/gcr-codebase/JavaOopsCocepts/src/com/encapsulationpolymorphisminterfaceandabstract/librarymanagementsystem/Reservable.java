package com.encapsulationpolymorphisminterfaceandabstract.librarymanagementsystem;

interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}