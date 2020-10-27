package week3.movie_database;

import java.io.*;
import java.util.*;

public class MovieDatabase {
    private ArrayList<Movie> movieList;
    private ArrayList<Actor> actorList;

    /**
     * a constructor that just creates a new movieList and a new actorList.
     * At the time of construction, both of these lists will be empty.
     */
    public MovieDatabase() {
        movieList = new ArrayList<> ();
        actorList = new ArrayList<> ();
    }

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    public ArrayList<Actor> getActorList() {
        return actorList;
    }

    public ArrayList<String> movieNameList() {
        ArrayList<String> mNames = new ArrayList<>();
        for (Movie movie : movieList) {
            mNames.add(movie.getName());
        }
        return mNames;
    }

    public ArrayList<String> actorNameList() {
        ArrayList<String> acNames = new ArrayList<>();
        for (Actor actor : actorList) {
            acNames.add(actor.getName());
        }
        return acNames;
    }

    /**
     * This method takes in the name of a movie that is not currently in the database along with a list of actors for that movie.
     * If the movie is already in the database, ignore this request (this specification is an oversimplification).
     * If the movie is a new movie, a movie object is created and added to the movieList.
     * If any of the actors happen to be new, they will be added to the actorList.
     * @param name
     * @param actors
     */
    public void addMovie(String name, String[] actors) {
        if (! this.movieNameList().contains(name)) {
            Movie newMovie = new Movie(name);
            for (String acName : actors) {
                Actor actor = new Actor(acName);
                if (this.actorNameList().contains(acName)) {
                    for (Actor a : actorList){
                        if (a.getName().equals(acName)) {
                            a.addMovie(newMovie);
                        }
                    }
                    newMovie.addActor(actor);
                } else {
                    actor.addMovie(newMovie);
                    newMovie.addActor(actor);
                    actorList.add(actor);
                }
            }
            movieList.add(newMovie);
        }else {

            for (String acName : actors) {
                if (!this.actorNameList().contains(acName)) {
                    Actor actor = new Actor(acName);
                    for (Movie m : movieList) {
                        if (m.getName().equals(name)) {
                            actor.addMovie(m);
                            m.addActor(actor);
                        }
                    }
                    actorList.add(actor);
                }
            }
        }

    }

    /**
     *
     * @param name
     * @param rating
     * Add a rating for this movie.
     * Assume that the name argument will definitely be a name that is currently in the database.
     */
    public void addRating(String name, double rating) {
        for (Movie m : movieList) {
            if (m.getName().equals(name)) {
                m.setRating(rating);
            }
        }
    }

    /**
     * Overwrite the current rating of a movie with this new rating.
     * Again, assume that the name argument will definitely be a name that is currently in the database.
     * @param name
     * @param newRating
     */
    public void updateRating(String name, double newRating) {
        this.addRating(name, newRating);

    }

    /**
     * @return the name of the actor that has the best average rating for their movies.
     * In the case of a tie, return any one of the best actors.
     */
    public String getBestActor() {
        String bestActor = "";
        double average = 0.0;
        for (Actor actor : actorList) {
            if (actor.averageRating() >= average) {
                average = actor.averageRating();
                bestActor = actor.getName();
            }
        }
        return bestActor;
    }

    /**
     * @return the name of the movie with the highest rating
     */
    public String getBestMovie() {
        String bestMovie = "";
        double tempRating = 0.0;
        for (Movie movie : movieList) {
            if (movie.getRating() >= tempRating) {
                tempRating = movie.getRating();
                bestMovie = movie.getName();
            }
        }
        return bestMovie;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
//        MovieDatabase test = new MovieDatabase();
//        String[] s1 = {"Brad"};
//        String[] s2 = {"Amy"};
//        test.addMovie("Movie A",s1);
//        System.out.println(test.actorNameList() + "\n"+ test.movieNameList());
//        System.out.println(test.getMovieList().size());
//        System.out.println(test.getMovieList().indexOf("Movie A"));
//
//        test.addMovie("Movie A",s2);
//        System.out.println(test.actorNameList() + "\n"+ test.movieNameList());
//
//        test.addMovie("Movie B",s2);
//        System.out.println(test.actorNameList() + "\n"+ test.movieNameList());



        MovieDatabase movieDB = new MovieDatabase();
        //Map<String, ArrayList<String>> movieActorsDic = new HashMap<String, ArrayList<String>>();

        try {
            File fileMovies = new File("./predefined_files/movies.txt");

            if(fileMovies.isFile() && fileMovies.exists()) {
                InputStreamReader isr = new InputStreamReader(new FileInputStream(fileMovies), "utf-8");
                BufferedReader br = new BufferedReader(isr);
                String lineTxt = null;

                while ((lineTxt = br.readLine()) != null) {
                    //System.out.println(lineTxt);
                    String[] movieFileArr = lineTxt.split(",");
                    String[] tempActorList = {movieFileArr[0]};
                    for (int i = 1; i < movieFileArr.length; i++) {
                        movieDB.addMovie(movieFileArr[i].trim(), tempActorList);
                    }
                }

//                for (Movie m: movieDB.movieList) {
//                   System.out.println(m.getName() + m.getActors());
//                }
//                for (Actor a : movieDB.actorList) {
//                    System.out.println(a.getName() + a.getMovies());
//                }
                br.close();
            } else {
                System.out.println("File doesn't exist!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }


        try {
            File fileRatings = new File ("./predefined_files/ratings.txt");

            if(fileRatings.isFile() && fileRatings.exists()) {
                InputStreamReader isr = new InputStreamReader(new FileInputStream(fileRatings), "utf-8");
                BufferedReader br = new BufferedReader(isr);
                String lineTxt = null;

                //Map<String, Double> movieRatingDic = new HashMap<>();

                while ((lineTxt = br.readLine()) != null) {
                    //System.out.println(lineTxt);
                    String[] ratingFileArr = lineTxt.split("\\t");
                    if (ratingFileArr[1].equals("critic_score")){
                        continue;
                    }
                    movieDB.addRating(ratingFileArr[0], Double.parseDouble(ratingFileArr[1]));
                }
//                for (Movie m: movieDB.movieList) {
//                    System.out.println(m.getRating());
//                }

//                for (Actor a : movieDB.actorList) {
//                    double sum = 0;
//                    for (Movie movie : a.getMovies()) {
//                        System.out.println(movie);
//                        sum += movie.getRating();
//                    }
//                    System.out.println(sum / a.getMovies().size());
//                    System.out.println(a.getName() + a.getMovies());
//                }
                br.close();
            } else {
                System.out.println("File doesn't exist!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }


        System.out.println(movieDB.actorNameList() + "\n" + movieDB.movieNameList());
        System.out.println(movieDB.getBestActor() + "\n" + movieDB.getBestMovie());

    }


//    You create a new instance of a movieDatabase.
//
//    Add all the movies in the file movies.txt.
//
//    Go through the ratings of the movies in the file ratings.txt and add the ratings for the movies.
//
//    Now call the methods that you created and print out the name of the best actor and the name of the highest rated movie.


}
