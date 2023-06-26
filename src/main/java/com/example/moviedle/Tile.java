package com.example.moviedle;

import javafx.scene.shape.Rectangle;

public class Tile {

    // TODO: maybe delete later :)

    private String text;
    private String style;
    private Rectangle tile;
    private double height;
    private double width;
    public void setText(String text) {
        this.text = text;
    }
    public void setSize(double height, double width){
        this.height = height;
        this.width = width;
    }
    public void setStyle(String style) {
        this.style = style;
    }
    public Rectangle getTile(){
        this.tile.setStyle(this.style);
        this.tile.setHeight(this.height);
        this.tile.setWidth(this.width);
        return this.tile;
    }
}
