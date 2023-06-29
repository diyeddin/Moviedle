package com.example.moviedle;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.util.List;


public class TileView {
    private HBox row;
    private Movie movieInfo;
    private Movie randomMovie;

    public TileView(Movie movieInfo, Movie randomMovie) {
        row = new HBox();
        row.setVisible(true);
        row.setSpacing(5);
        this.movieInfo = movieInfo;
        this.randomMovie = randomMovie;
    }
    public HBox getTileRow() {
        ImageView poster = new ImageView(new Image(movieInfo.moviePosterLink));
        poster.setFitWidth(100);
        poster.setFitHeight(80);
        this.row.getChildren().add(poster);

        List<String> movieInfoList = movieInfo.asList();
        List<String> randomMovieList = randomMovie.asList();
        for (int i = 0; i < movieInfoList.size(); i++) {
            Label tile = new Label();
            tile.setPrefSize(120, 80);
            tile.wrapTextProperty().set(true);
            tile.paddingProperty().set(new Insets(5));
            tile.setText(movieInfoList.get(i));

            if (movieInfoList.get(i).equalsIgnoreCase(randomMovieList.get(i)))
                tile.setStyle("-fx-background-color: #00FF00");
            else {
                tile.setStyle("-fx-background-color: #FF0000");
            }
            this.row.getChildren().add(tile);
        }
        return this.row;
    }
    public boolean allTrue() {
        return movieInfo.equals(randomMovie);
    }
}
