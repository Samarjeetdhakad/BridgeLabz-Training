package com.constructor.level1;

class LibraryBookSystem {

    private String title;
    private String author;
    private double price;
    private boolean available;

    LibraryBookSystem(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = true;
    }


    void borrowBook() {
        if (available) {
            available = false;
            System.out.println("You have successfully borrowed \"" + title + "\".");
        } else {
            System.out.println("Sorry, \"" + title + "\" is currently not available.");
        }
    }

    void returnBook() {
        available = true;
        System.out.println("You have returned \"" + title + "\".");
    }

    void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
        System.out.println("Available: " + available);
    }

   
}
