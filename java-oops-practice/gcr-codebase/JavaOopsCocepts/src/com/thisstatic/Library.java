package com.thisstatic;

public class Library {
	   public static void main(String[] args) {

	       Book.setLibraryName("Egmore Library");
	       Book.displayLibraryName();

	       Book book1 = new Book("Effective Java", "Joshua Bloch", "978-0134685991");

	       book1.displayBookDetails();
	   }
	}
