package com.streamapi.targetmovie;
import java.util.*;
import java.util.stream.*;

public class Main {
	    public static void main(String[] args) {
	        List<Movie> movies=Arrays.asList( new Movie("spider man", 2010, 8.8), new Movie("Avengers Endgame", 2019, 8.4),new Movie("Interstellar", 2014, 8.6),new Movie("Oppenheimer", 2023, 8.9), new Movie("The Dark Knight", 2008, 9.0), new Movie("Dune Part 2", 2024, 8.7), new Movie("Joker", 2019, 8.5),new Movie("Avatar", 2009, 7.8));
	        List<Movie> top5Trending=movies.stream()
	 .filter(movie -> movie.getRating() >= 8.0).sorted(Comparator.comparing(Movie::getRating).reversed().thenComparing(Movie::getReleaseYear, Comparator.reverseOrder())) .limit(5).collect(Collectors.toList());
	        top5Trending.forEach(System.out::println);
	    }
	}

