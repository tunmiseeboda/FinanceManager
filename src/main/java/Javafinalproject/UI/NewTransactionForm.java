package Javafinalproject.UI;

import Javafinalproject.Model.Transaction;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.function.Consumer;

public class NewTransactionForm extends VBox {
    private final TextField amountField;
    private final TextField categoryField;
    private final TextField descriptionField;
    private final TextField dateField;

    public NewTransactionForm(Consumer<Transaction> onTransactionAdded) {
        // Create Labels and text fields for amount, category, description and date
        Label categoryLabel = new Label("Category");
        categoryField = new TextField();
        Label amountLabel = new Label("Amount");
        amountField = new TextField();
        Label descriptionLabel = new Label("Description");
        descriptionField = new TextField();
        Label dateLabel = new Label("Date");
        dateField = new TextField();

        // create a button to add the transaction
        Button addButton = new Button("Add Transaction");
        addButton.setOnAction(event -> {

            // Get input values
            double amount = Double.parseDouble(amountField.getText());
            String category = categoryField.getText();
            String description = descriptionField.getText();
            String date = dateField.getText();

            // Create a new transaction
            Transaction transaction = new Transaction(amount, category, description, date);

            // Pass the new transaction to the consumer
            onTransactionAdded.accept(transaction);

            // Clear input fields
            amountField.clear();
            categoryField.clear();
            descriptionField.clear();
            dateField.clear();
        });

        // Create a layout for the form
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(5);
        gridPane.setPadding(new Insets(10));
        gridPane.add(categoryLabel, 0, 0);
        gridPane.add(categoryField, 1, 0);
        gridPane.add(amountLabel, 0, 1);
        gridPane.add(amountField, 1, 1);
        gridPane.add(descriptionLabel, 0, 2);
        gridPane.add(descriptionField, 1, 2);
        gridPane.add(dateLabel, 0, 3);
        gridPane.add(dateField, 1, 3);


        // add form elements to the VBox
        this.getChildren().addAll(gridPane, addButton);
        this.setSpacing(10);
        this.setPadding(new Insets(10));

    }

}
