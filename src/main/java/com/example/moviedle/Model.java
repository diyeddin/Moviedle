package com.example.moviedle;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.layout.VBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Model {
    private List<Movie> data = new ArrayList<>();
    private Path path = Paths.get("res/imdb_top_250.csv");
    private VBox vBox;
    private Movie randomMovie;
    public IntegerProperty counter;
    public BooleanProperty isWinning;
    private static final Model instance = new Model();

    private Model() {
        this.loadData(this.path);
//        this.data = data.subList(1, data.size());
        this.randomMovie = this.selectRandomMovie();
        this.vBox = new VBox();
        this.counter = new SimpleIntegerProperty(0);
        isWinning = new SimpleBooleanProperty(false);
    }
    public static Model getInstance() { // Singleton Design Pattern
        return instance;
    }
    public void restart() {
        this.randomMovie = this.selectRandomMovie();
        this.vBox.getChildren().clear();
        this.counter.set(0);
        this.isWinning.set(false);
    }

    private void loadData(Path path){
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String header = br.readLine(); // header
            String line = br.readLine();

            while (line != null) {
                Movie movie = new Movie(line);
                this.data.add(movie);

                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private Movie selectRandomMovie(){
        Movie rndMovie;
        Random random = new Random();

        rndMovie = this.data.get(random.nextInt(0, this.data.size()));
        System.out.println(rndMovie.title); // TEMPORARY
        return rndMovie;
    }
    private Movie getMovieInfo(String movieTitle){
        Movie movieInfo = new Movie();

        for (Movie movie: this.data)
            if (movie.title.equalsIgnoreCase(movieTitle)) {
                movieInfo = movie;
                movieInfo.found.set(true);
            }

        return movieInfo;
    }
    public void updateTiles(String userGuess) {
        Movie guessedMovie = this.getMovieInfo(userGuess);
        if (guessedMovie.found.get()) {
            TileView tileView = new TileView(guessedMovie, this.randomMovie);
            this.vBox.getChildren().add(tileView.getTileRow());

            this.isWinning.set(tileView.allTrue());
            this.counter.set(this.counter.get() + 1);
        } else System.out.println("entered movie title not found");
    }
    public VBox getvBox() {
        return vBox;
    }

//    public List<String> getSuggestions(String search) {
//        List<String> suggestions = new ArrayList<>();
//
//        for (List<String> movie: this.data)
//            if (movie.get(colNames.indexOf("Title")).toLowerCase().startsWith(search.toLowerCase()))
//                suggestions.add(movie.get(colNames.indexOf("Title")));
//        return suggestions;
//    }
}
