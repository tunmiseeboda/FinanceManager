package Javafinalproject.UI;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
public class UI {
    public VBox createUI() {
        VBox vbox = new VBox();
        vbox.getChildren().add(new Button("Click me"));
        return vbox;
    }
}
