package week3.movie_database;

import java.util.*;

public class Actor {
    private String name;
    private ArrayList<Movie> movies;

    public Actor(String name, ArrayList<Movie> movies) {
        this.name = name;
        this.movies = movies;
    }

    public Actor(String name) {
        this.name = name;
        this.movies = new ArrayList<>();
    }

    public Actor() {
        this.name = "";
        this.movies = new ArrayList<>();;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public void addMovie(Movie movie) {
        this.movies.add(movie);
    }

    public double averageRating() {
        double sum = 0;
        for (Movie movie : movies) {
            sum += movie.getRating();
        }
        return sum / movies.size();
    }

}

