package com.example.moviedle;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.util.List;


public class TileView {
    private HBox row;
    private List<String> movieInfo;
    private List<String> randomMovie;

    public TileView(Movie movieInfo, Movie randomMovie) {
        row = new HBox();
        row.setVisible(true);
        row.setSpacing(5);
        this.movieInfo = movieInfo.asList();
        this.randomMovie = randomMovie.asList();
    }
    public HBox getTileRow() {
        for (int i = 0; i < movieInfo.size(); i++) {
            Label tile = new Label();
            tile.setPrefSize(100, 80);
            tile.wrapTextProperty().set(true);
            tile.paddingProperty().set(new Insets(5));
            tile.setText(movieInfo.get(i));

            // TODO: Add arrow for year
            if (movieInfo.get(i).equalsIgnoreCase(randomMovie.get(i)))
                tile.setStyle("-fx-background-color: #00FF00");
            else {
                tile.setStyle("-fx-background-color: #FF0000");
                /*if (i == 1){
                    if (Integer.parseInt(movieInfo.get(i)) < Integer.parseInt(randomMovie.get(i))){
                        tile.setStyle("-fx-background-image: url('img/up.png')");
//                        tile.setText(tile.getText() + " (greater)");
                    }
                    else {
                        tile.setStyle("-fx-background-image: url('img/down.png')");
//                        tile.setText(tile.getText() + " (less)");
                    }
                }*/
            }
            this.row.getChildren().add(tile);
        }
        return this.row;
    }
    public boolean allTrue() {
        return movieInfo.equals(randomMovie);
    }
}
