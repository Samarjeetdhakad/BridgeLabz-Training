package com.objectmodelling.assistedproblem;

class Book {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    void showBook() {
        System.out.println("Title: " + title + ", Author: " + author);
    }
}
