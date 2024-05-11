package Javafinalproject.UI;

import Javafinalproject.Model.FileManager;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.function.Consumer;

public class FileInputUI extends HBox {
    private TextField fileNameField;
    private Button loadButton;

    public FileInputUI() {
        // Create a Label
        Label label = new Label("Enter file name or search:");

        // Create a text field for entering file name
        fileNameField = new TextField();
        fileNameField.setPromptText("Enter file name....");

        // Create a button to trigger file chooser
        Button searchButton = new Button("Search for file....");
        searchButton.setOnAction(event -> browseForFile());

        // create a button to load transactions from file
        loadButton = new Button("Load Transactions");
        loadButton.setOnAction(event -> loadTransactionFromFile());

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
            fileNameField.setText(selectedFile.getPath());
        }
    }

    private void loadTransactionFromFile() {
        String fileName = fileNameField.getText();

        if (!fileName.isEmpty()) {
            // load transactions from selected file
            FileManager fileManager = new FileManager();
            //
            //
            if (fileName.toLowerCase().endsWith(".csv")) {
                System.out.println("Loading transactions from file: " + fileName);
                FileManager.loadTransactions(fileName).forEach(System.out::println);
            } else {
                //
                System.out.println("Unsupported file type. Please select a csv file.");
            }
        } else {
            System.out.println("Please enter a file name.");
        }
    }

    public String getFileName() {
        return fileNameField.getText();
    }

    // Method to set event handler when file name entered
    public void setOnFileNameEntered(Consumer<String> handler) {
        fileNameField.setOnAction(event -> handler.accept(fileNameField.getText()));
    }

    public void setOnLoadTransactionFromFile(Consumer<String> handler) {
        loadButton.setOnAction(event -> {
            String fileName = fileNameField.getText();
            if (!fileName.isEmpty()) {
                handler.accept(fileName);
            } else {
                System.out.println("Please enter a file name.");
            }
        });
    }

}
