package com.example.moviedle;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Movie {
    public String title;
    public String year;
    public String genre;
    public String origin;
    public String director;
    public String star;
    public String imdbLink;
    public BooleanProperty found = new SimpleBooleanProperty(false);

    public Movie() {

    }
    public Movie(String line) {
        List<String> parts = partsFromLine(line);
        this.title = parts.get(1);
        this.year = parts.get(2);
        this.genre = parts.get(3);
        this.origin = parts.get(4);
        this.director = parts.get(5);
        this.star = parts.get(6);
        this.imdbLink = parts.get(7);
    }
//    public Movie(String title, String year, String genre, String origin, String director, String star, String imdbLink) {
//        this.title = title;
//        this.year = year;
//        this.genre = genre;
//        this.origin = origin;
//        this.director = director;
//        this.star = star;
//        this.imdbLink = imdbLink;
//    }
    public List<String> asList() {
        List<String> list = new ArrayList<>();
        list.add(title);
        list.add(year);
        list.add(genre);
        list.add(origin);
        list.add(director);
        list.add(star);

        return list;
    }
    private List<String> partsFromLine(String line) {
        return Arrays.asList(line.split(";"));
    }
//    public boolean isEmpty() {
//        return
//    }
}
