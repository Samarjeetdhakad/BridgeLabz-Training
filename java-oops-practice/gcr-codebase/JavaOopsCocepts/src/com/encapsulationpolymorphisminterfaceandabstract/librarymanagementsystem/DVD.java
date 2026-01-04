package com.encapsulationpolymorphisminterfaceandabstract.librarymanagementsystem;


class DVD extends LibraryItem implements Reservable {

    public DVD(int id,String title,String author) {
        super(id,title,author);
    }

    @Override
    public int getLoanDuration() {
        return 3; 
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (checkAvailability()) {
            setBorrower(borrowerName);
            System.out.println("DVD reserved by"+borrowerName);
        } else {
            System.out.println("DVD not available");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}