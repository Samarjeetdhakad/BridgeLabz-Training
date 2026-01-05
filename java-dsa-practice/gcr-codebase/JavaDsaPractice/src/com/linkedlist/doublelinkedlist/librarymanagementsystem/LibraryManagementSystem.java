package com.linkedlist.doublelinkedlist.librarymanagementsystem;

public class LibraryManagementSystem {
    public static void main(String[] args) {

        LibraryDoublyLinkedList library = new LibraryDoublyLinkedList();

        library.addAtEnd(101, "Java Programming", "James Gosling", "Programming", true);
        library.addAtBeginning(102, "Clean Code", "Robert Martin", "Software", true);
        library.addAtEnd(103, "Data Structures", "Mark Allen", "CS", false);
        library.addAtPosition(2, 104, "Algorithms", "CLRS", "CS", true);

        library.displayForward();
        library.displayReverse();

        System.out.println("\nSearch by Author ");
        library.searchByAuthor("CLRS");

        System.out.println("\n Update Availability ");
        library.updateAvailability(103, true);
        library.displayForward();

        System.out.println("\n Remove Book");
        library.removeByBookId(102);
        library.displayForward();

       
        library.countBooks();
    }
}