package Javafinalproject.UI;

import javafx.scene.layout.HBox;
import javafx.scene.control.TextField;
import java.util.function.Consumer;

public class SearchField extends HBox {

    private TextField searchField;
    private Consumer<String> searchHandler;

    public SearchField(Consumer<String> searchHandler){
        this.searchHandler = searchHandler;

        // create a text fields for entering search queries
        searchField = new TextField();
        searchField.setPromptText("Search....");

        // set event handler when teh user types and presses Enter
        searchField.setOnAction(event -> handleSearch());

        // set event handler for the text changes
        searchField.textProperty().addListener((observable, oldValue, newValue  )->{
            if (newValue.isEmpty()) {
                handleSearch();
            }
        });

        // Add the search field to the layout
        this.getChildren().add(searchField);
    }

    public void handleSearch() {
        String keyword = searchField.getText().trim();
        searchHandler.accept(keyword);
    }
}
