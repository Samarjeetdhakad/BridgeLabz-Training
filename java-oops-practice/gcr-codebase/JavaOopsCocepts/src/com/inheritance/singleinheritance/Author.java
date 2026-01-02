package com.inheritance.singleinheritance;

public class Author extends Book{
	String name;
	 String bio;
	 Author(String title, int publicationYear, String name, String bio){
		 super(title, publicationYear);
		 this.name=name;
		 this.bio=bio;
	 }
	 void displayInfo() {
			super.displayInfo();
			System.out.println("Author Name:"+name);
			System.out.println("Author Bio :"+bio);
		}
	 
	 
}