package com.constructor.level1;

class Book {
    private String title;
    private String author;
    private double price;
    Book() {
        this.title="Unknown";
        this.author="Unknown";
        this.price=0.0;
    }
    Book(String title, String author, double price) {
        this.title=title;
        this.author=author;
        this.price=price;
    }
    void displayDetails() {
        System.out.println("Title: "+title);
        System.out.println("Author: "+author);
        System.out.println("Price: "+price);
    }

    public static void main(String[] args) {
        Book b1=new Book(); 
        Book b2=new Book("Clean Code", "Robert C. Martin", 450.0);

        System.out.println("Book 1 Details:");
        b1.displayDetails();

        System.out.println("\nBook 2 Details:");
        b2.displayDetails();
    }
}
