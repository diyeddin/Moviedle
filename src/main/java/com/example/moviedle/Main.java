package com.example.moviedle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicBoolean;


public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Model model = Model.getInstance();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 550);
        Controller controller = fxmlLoader.getController();

        model.counter.addListener((observable, oldValue, newValue) -> {
            if (!model.isWinning.get() && newValue.intValue() == 5) showDialog("You Lost", stage, controller);
        });
        model.isWinning.addListener((observable, oldValue, newValue) -> {
            if (newValue && model.counter.get() <= 5)
                showDialog("You Won!", stage, controller);
        });

        stage.setTitle("Moviedle");
        stage.setScene(scene);
        stage.show();
    }
    public void showDialog(String message, Stage mainStage, Controller controller){
        try {
            Stage dialogStage = new Stage();
            dialogStage.setTitle(message);
            dialogStage.initOwner(mainStage);
            dialogStage.resizableProperty().set(false);

            BorderPane root = new BorderPane();
            Button restartBtn = new Button();
            restartBtn.setText("Restart");
            restartBtn.setOnAction(e -> {
                controller.restart();
                dialogStage.close();
            });
            root.setCenter(restartBtn);

            Scene scene = new Scene(root, 300, 50);
            dialogStage.setOnCloseRequest(e -> {
            mainStage.close();
            dialogStage.close();
            });

            dialogStage.setScene(scene);
            dialogStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch();
    }
}
