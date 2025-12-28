package com.constructor.level1;

public class BookLibrary {
	    public String ISBN;        
	    protected String title;   
	    private String author;     

	    BookLibrary(String ISBN, String title, String author) {
	        this.ISBN=ISBN;
	        this.title=title;
	        this.author=author;
	    }

	    public void setAuthor(String author) {
	        this.author=author;
	    }
	    public String getAuthor() {
	        return author;
	    }
	}



