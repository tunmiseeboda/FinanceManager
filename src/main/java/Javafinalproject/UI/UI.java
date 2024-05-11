package Javafinalproject.UI;


import Javafinalproject.Model.*;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.control.ListView;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;

import java.util.List;
public class UI {
    private VBox layout;
   private ObservableList<Transaction> transactions;
   private FileInputUI fileInputUI;
   private ListView<String> transactionListView;
   private ComboBox<String> sortOptions;

   public UI() {

       // Initialize transactions list
       transactions = FXCollections.observableArrayList();

       // Initialize file input UI
       fileInputUI = new FileInputUI();
       fileInputUI.setOnLoadTransactionFromFile(this::loadTransactionsFromFile);

       // Initialize transaction list view
       transactionListView = new ListView<>();
       updateTransactionListView();

       // Intialize sort options combo box
       sortOptions = new ComboBox<>();
       sortOptions.getItems().addAll("Sort by Amount", "Sort by Category", "Sort by Date" );
       sortOptions.setValue("Sort by Date");
       sortOptions.setOnAction(event -> sortTransactions());

      // Initialize load Button
       Button loadButton = new Button("Load Transactions");
       loadButton.setOnAction(event -> loadTransactionsFromFile(fileInputUI.getFileName()));


       // Add file input UI and transaction list view to layout
       layout = new VBox(10, fileInputUI, sortOptions, loadButton, transactionListView);
   }

   private void sortTransactions() {
       if(sortOptions.getValue().equals("Sort by Date")) {
           TransactionManager.sortByDate(transactions);
       } else if (sortOptions.getValue().equals("Sort by Category")){
           TransactionManager.sortByCategory(transactions);
       } else {
           TransactionManager.sortByAmount(transactions);
       }
       updateTransactionListView();
   }

   private void loadTransactionsFromFile(String fileName) {
       // Call FileManger method to load transactions from file
       List<Transaction> loadedTransactions = FileManager.loadTransactions(fileName);
       // Update transactions list and list view
       transactions.clear();
       transactions.addAll(loadedTransactions);

       //
       sortTransactions();
   }
    public void updateTransactions(List<Transaction> updatedTransactions) {
        // Clear and update the transactions list
        transactions.clear();
        transactions.addAll(updatedTransactions);
        //
        sortTransactions();
    }


   private void updateTransactionListView(){
       // clear and update the list view with transaction descriptions
       transactionListView.getItems().clear();
       for(Transaction transaction: transactions) {
           transactionListView.getItems().add(transaction.toString());

       }
   }

   // Method to get the UI layout
    public VBox getLayout() {
        return layout;
    }
}
