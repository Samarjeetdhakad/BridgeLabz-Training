package com.collectors.librarybooksystem;

import java.util.List;
import java.util.*;
import java.util.stream.*;
public class Main {
	public static void main(String[]args) {
		List<Book> books = List.of(
			    new Book("Programming", 464),
			    new Book( "Programming", 416),
			    new Book( "Fantasy", 310),
			    new Book( "Fantasy", 500),
			    new Book( "Self-Help", 320)
			);
Map<String, IntSummaryStatistics> statsByGenre = books.stream().collect(Collectors.groupingBy(Book::getGenre, Collectors.summarizingInt(Book::getPages)));
           statsByGenre.forEach((genre, stats) -> {
		    System.out.println("Genre: " + genre);
		    System.out.println("Total Pages   : " + stats.getSum());
		    System.out.println("Average Pages : " + stats.getAverage());
		    System.out.println("Max Pages     : " + stats.getMax());
		
		});

	}

}