package com.objectmodelling.assistedproblem;



public class LibraryMain {
    public static void main(String[] args) {

        // Books exist independently
        Book b1 = new Book("Java Programming", "James Gosling");
        Book b2 = new Book("Clean Code", "Robert C. Martin");
        Book b3 = new Book("Data Structures", "Mark Allen Weiss");

        // Libraries
        Library lib1 = new Library("Central Library");
        Library lib2 = new Library("College Library");

        // Aggregation: same book can be added to different libraries
        lib1.addBook(b1);
        lib1.addBook(b2);

        lib2.addBook(b2);
        lib2.addBook(b3);

        lib1.showBooks();
        System.out.println();
        lib2.showBooks();
    }
}


