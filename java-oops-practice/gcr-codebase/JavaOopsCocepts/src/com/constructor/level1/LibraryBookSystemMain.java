package com.constructor.level1;

public class LibraryBookSystemMain {
	 public static void main(String[] args) {

		 LibraryBookSystem b1 = new LibraryBookSystem("Effective Java", "Joshua Bloch", 550);

	        b1.displayDetails();

	        b1.borrowBook();  
	        b1.borrowBook();  
	        b1.returnBook();   
	        b1.borrowBook();  
	    }
}