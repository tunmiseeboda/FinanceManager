package Javafinalproject.UI;

import javafx.scene.layout.HBox;
import javafx.scene.control.TextField;
import java.util.function.Consumer;

public class SearchField extends HBox {

    private TextField searchField;

    public SearchField(Consumer<String> searchHandler){
        // create a text fields for entering search queries
        searchField = new TextField();
        searchField.setPromptText("Search....");

        // set event handler when teh user types and presses Enter
        searchField.setOnAction(event -> searchHandler.accept(searchField.getText()));


        // Add the search field to the layout
        this.getChildren().add(searchField);
    }
}
