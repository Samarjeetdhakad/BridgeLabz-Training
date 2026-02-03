package com.streamapi.targetmovie;
class Movie {
    private String name;
    private int releaseYear;
    private double rating;
   Movie(String name, int releaseYear, double rating) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return name + " (" + releaseYear + ") - Rating: " + rating;
    }
}