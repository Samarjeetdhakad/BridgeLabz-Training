package com.objectmodelling.assistedproblem;

	import java.util.ArrayList;

	class Library {
	    String libraryName;
	    ArrayList<Book> books;

	    Library(String libraryName) {
	        this.libraryName = libraryName;
	        books = new ArrayList<>();
	    }

	    // Adding existing book to library (Aggregation)
	    void addBook(Book book) {
	        books.add(book);
	    }

	    void showBooks() {
	        System.out.println("Books in " + libraryName + ":");
	        for (Book book : books) {
	            book.showBook();
	        }
	    }
	}


