package com.encapsulationpolymorphisminterfaceandabstract.librarymanagementsystem;

abstract class LibraryItem {

    private int itemId;
    private String title;
    private String author;

    private String borrowerName;
    private boolean isAvailable = true;

    public LibraryItem(int itemId, String title, String author) {
        this.itemId= itemId;
        this.title =title;
        this.author = author;
    }

    public abstract int getLoanDuration();

    public void getItemDetails() {
        System.out.println("Item ID : " +itemId);
        System.out.println("Title: " +title);
        System.out.println("Author: "+ author);
        System.out.println("Loan Days: "+ getLoanDuration());
    }

    protected void setBorrower(String name) {
        this.borrowerName=name;
        this.isAvailable=false;
    }

    protected boolean isAvailable() {
        return isAvailable;
    }
}