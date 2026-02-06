package com.designpattern.smartuniversitylibrarymanagementsystem;

class LibraryUser implements Observer {

    private String name;

    public LibraryUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String bookTitle) {
        System.out.println(name + " notified: Book available -> " + bookTitle);
    }
}