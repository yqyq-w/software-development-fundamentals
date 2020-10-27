package week3.movie_database;

import java.util.*;

public class Movie {
    private String name;
    private ArrayList<Actor> actors;
    private double rating;

    public Movie(String name, ArrayList<Actor> actors, double rating) {
        this.name = name;
        this.actors = actors;
        this.rating = rating;
    }

    public Movie(String name) {
        this.name = name;
        this.actors = new ArrayList<>();
        this.rating = 0.0;
    }

    public Movie() {
        this.name = "";
        this.actors = new ArrayList<>();
        this.rating = 0.0;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Actor> getActors() {
//        for (Actor a : actors) {
//            System.out.println(a.getName());
//        }
        return actors;
    }

    public double getRating() {
        return rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void addActor(Actor actor) {
        this.actors.add(actor);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", actors=" + actors +
                ", rating=" + rating +
                '}';
    }
}
