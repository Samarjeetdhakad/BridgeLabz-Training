package com.constructor.level1;

public class BookLibraryMain {
    public static void main(String[] args) {

        EBook ebook = new EBook("978-0135166307","Effective Java","Joshua Bloch",5.2);

        ebook.displayDetails();
        ebook.setAuthor("J.Bloch");

        System.out.println("Updated Author:"+ebook.getAuthor());
    }
}
