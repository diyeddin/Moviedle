module com.example.moviedle {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.moviedle to javafx.fxml;
    exports com.example.moviedle;
}