package Javafinalproject;

import Javafinalproject.UI.UI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Driver extends Application {
    public static void main(String[] args) throws IOException {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Create and Configure the UI
        UI ui = new UI();

        VBox vbox = ui.createUI();

        // Set up Budget
        Scene scene = new Scene(vbox, 320, 240);
        stage.setTitle("Budget Tracker");
        stage.setScene(scene);
        stage.show();
    }
}