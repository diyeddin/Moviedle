package com.example.moviedle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.util.List;


public class Controller {
    @FXML
    private TextField txtField;
    @FXML
    private VBox vbox;
    @FXML
    private ListView<String> listView;

    private Model model;

    public Controller() {
        this.model = Model.getInstance();
    }
    public void setBtnGuess(ActionEvent event) {
        this.model.updateTiles(this.txtField.getText());
        this.vbox.getChildren().addAll(this.model.getvBox().getChildren());
        this.txtField.setText("");
    }
    public void onEnterPressed(ActionEvent event) {
        setBtnGuess(event);
    }
    public void onTextEdited() {
        List<String> suggestions = this.model.getSuggestions(txtField.getText());
        listView.setItems(FXCollections.observableArrayList(suggestions));
    }
    public void onMouseClicked() {
        txtField.setText(listView.getSelectionModel().selectedItemProperty().get());
    }
    public void restart() {
        this.model.restart();
        this.vbox.getChildren().clear();
        this.txtField.setText("");
        this.listView.getItems().clear();
    }
}
