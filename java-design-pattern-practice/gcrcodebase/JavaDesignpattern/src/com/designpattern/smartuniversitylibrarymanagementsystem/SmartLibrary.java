package com.designpattern.smartuniversitylibrarymanagementsystem;

public class SmartLibrary {

    public static void main(String[] args) {

        // Singleton Catalog
        LibraryCatalog catalog = LibraryCatalog.getInstance();

        // Factory Users
        User u1 = UserFactory.createUser("student");
        User u2 = UserFactory.createUser("faculty");

        u1.getRole();
        u2.getRole();

        // Observer Registration
        LibraryUser student = new LibraryUser("Alice");
        LibraryUser faculty = new LibraryUser("Dr. Smith");

        catalog.registerObserver(student);
        catalog.registerObserver(faculty);

        // Builder Book Creation
        Book book = new Book.BookBuilder("Data Structures by Cormen")
                .authors("Cormen et al.")
                .edition("3rd Edition")
                .genre("Computer Science")
                .publisher("MIT Press")
                .build();

        // Add book → triggers notification
        catalog.addBook(book);
    }
}