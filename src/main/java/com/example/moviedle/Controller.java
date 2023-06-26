package com.example.moviedle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;


public class Controller {
    @FXML
    private Button btnGuess;
    @FXML
    private TextField txtField;
    @FXML
    private VBox vbox;

    private Model model;

    public Controller() {
        this.model = Model.getInstance();
        this.vbox = new VBox();
        this.txtField = new TextField();
    }
    public void setBtnGuess(ActionEvent event) {
        this.model.updateTiles(this.txtField.getText());
        VBox tiles = this.model.getvBox();
        this.vbox.getChildren().addAll(tiles.getChildren());
//        this.txtField.setText("");
    }
    public void onEnterPressed(ActionEvent event) {
        setBtnGuess(event);
    }
    public void restart() {
        this.model.restart();
        this.vbox.getChildren().clear();
        this.txtField.setText("");
    }
}
