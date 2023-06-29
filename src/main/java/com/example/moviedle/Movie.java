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
    public String moviePosterLink;
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
        this.moviePosterLink = parts.get(8);
    }

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
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Movie){
            return this.title.equals(((Movie) obj).title) && this.star.equals(((Movie) obj).star) && this.director.equals(((Movie) obj).director);
        }
        return false;
    }
}
