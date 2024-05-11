package Javafinalproject.UI;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;

import java.io.File;
public class FileInputUI extends HBox {
    TextField fileNameField;

    public FileInputUI() {
        // Create a Label
        Label label = new Label("Enter file name or search:");

        // Create a text field for entering file name
        fileNameField = new TextField();
        fileNameField.setPromptText("Enter file name....");

        // Create a button to trigger file chooser
        Button searchButton = new Button("Search for file....");
        searchButton.setOnAction(event -> browseForFile());

        // Add Components to the layout
        this.getChildren().addAll(label, fileNameField, searchButton);
        this.setSpacing(10);
        this.setPadding(new Insets(10));
    }

    // Method to open a file chooser dialog
    private void browseForFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose File");

        // Show open dialog
        File selectedFile = fileChooser.showOpenDialog(null);

        if(selectedFile != null) {
            fileNameField.setText(selectedFile.getAbsolutePath());
        }
    }

    //Method to get the entered file name
    public String getFileName() {
        return fileNameField.getText();
    }
}
