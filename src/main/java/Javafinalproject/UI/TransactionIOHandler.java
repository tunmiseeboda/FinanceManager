package Javafinalproject.UI;



import Javafinalproject.Model.FileManager;
import Javafinalproject.Model.Transaction;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;
public class TransactionIOHandler {

    public static void exportTransactions(List<Transaction> transactions){
        //open a file chooser dialog to select the export file location
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Export Transactions");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("CSV Files", "*.csv")
        );
        File file = fileChooser.showSaveDialog(new Stage());

        if (file != null) {
            FileManager.saveTransactions(transactions, file.getAbsolutePath());
        }
    }

}
