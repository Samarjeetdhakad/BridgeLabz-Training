package com.encapsulationpolymorphisminterfaceandabstract.librarymanagementsystem;

public class LibraryManagementSystem {

    public static void main(String[] args) {

        LibraryItem item1=new Book(1,"Java Programming", "James Gosling");
        LibraryItem item2=new Magazine(2,"Tech Today", "Editorial Team");
        LibraryItem item3=new DVD(3,"Inception", "Christopher Nolan");

        LibraryItem[] items={ item1, item2, item3 };

        for (LibraryItem item:items) {
            item.getItemDetails();

            if (item instanceof Reservable) {
                Reservable r=(Reservable) item;
                r.reserveItem("Rahul");
            }

        }
    }
}