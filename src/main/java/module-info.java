module com.example.javafinalproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens Javafinalproject to javafx.fxml;
    exports Javafinalproject;
    exports Javafinalproject.Model;
    opens Javafinalproject.Model to javafx.fxml;
}