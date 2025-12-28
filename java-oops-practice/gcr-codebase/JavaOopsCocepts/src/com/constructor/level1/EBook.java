package com.constructor.level1;

class EBook extends BookLibrary {
    double fileSize; 
    EBook(String ISBN, String title, String author, double fileSize) {
        super(ISBN,title,author);
        this.fileSize=fileSize;
    }

    void displayDetails() {
        System.out.println("ISBN:"+ISBN);        
        System.out.println("Title:"+title);     
        System.out.println("Author:"+getAuthor()); 
        System.out.println("File Size:"+fileSize+" MB");
    }
}
