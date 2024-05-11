package Javafinalproject;

import Javafinalproject.Model.FileManager;
import Javafinalproject.Model.Transaction;
import Javafinalproject.UI.FileInputUI;
import Javafinalproject.UI.UI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class Driver extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // create FileManager instance
        FileManager fileManager = new FileManager();



        // Create UI
        UI ui = new UI();


        VBox layout = new VBox();
        layout.getChildren().addAll(ui.getLayout());

        // Set up Budget
        Scene scene = new Scene(layout, 320, 240);
        stage.setTitle("Budget Tracker");
        stage.setScene(scene);
        stage.show();
    }
}