package Javafinalproject.UI;


import Javafinalproject.Model.FileManager;
import Javafinalproject.Model.Transaction;
import Javafinalproject.Model.TransactionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

import java.util.List;

public class UI {
    private VBox layout;
    private ObservableList<Transaction> transactions;

    private  FileInputUI fileInputUI;
    private ListView<String> transactionListView;
    private  ComboBox<String> sortOptions;
    private  ComboBox<String> orderOptions;
    private SearchField searchField;

   public UI() {

       // Initialize transactions list
       transactions = FXCollections.observableArrayList();


       // Initialize file input UI
       fileInputUI = new FileInputUI();
       fileInputUI.setOnLoadTransactionFromFile(this::loadTransactionsFromFile);

       // Initialize transaction list view
       transactionListView = new ListView<>();
       updateTransactionListView();

       // Initialize sort options combo box
       sortOptions = new ComboBox<>();
       sortOptions.getItems().addAll("Sort by Amount", "Sort by Category", "Sort by Date" );
       sortOptions.setValue("Sort by Date");
       sortOptions.setOnAction(event -> sortTransactions());

       // Initialize order options combo box
       orderOptions = new ComboBox<>();
       orderOptions.getItems().addAll("Ascending", "Descending");
       orderOptions.setValue("Ascending");
       orderOptions.setOnAction(event -> sortTransactions());

       // Initialize Search field
       searchField = new SearchField(this::searchTransactions);

      // Initialize load Button
       Button loadButton = new Button("Load Transactions");
       loadButton.setOnAction(event -> loadTransactionsFromFile(fileInputUI.getFileName()));

       // Initialize NewTransactionForm
       NewTransactionForm newTransactionForm = new NewTransactionForm(this::addTransaction);


       // Add file input UI and transaction list view to layout
       layout = new VBox(10, fileInputUI, sortOptions, orderOptions, searchField, loadButton, transactionListView, newTransactionForm);
   }

   private void sortTransactions() {
       String sortBy = sortOptions.getValue();
       String sortOrder = orderOptions.getValue();
       if(sortBy.equals("Sort by Date")) {
           TransactionManager.sortByDate(transactions);
       } else if (sortBy.equals("Sort by Category")){
           TransactionManager.sortByCategory(transactions);
       } else {
           TransactionManager.sortByAmount(transactions);
       }
       if (sortOrder.equals("Descending")) {
           FXCollections.reverse(transactions);
       }

       updateTransactionListView();
   }

   private void searchTransactions(String keyword) {
       // Call the searchTransactions method from TransactionManager class
       List<Transaction> searchResults = TransactionManager.searchTransactions(transactions, keyword);
       transactions.clear();
       transactions.addAll(searchResults);
       // Update transaction list view with search results
       updateTransactionListView();
   }

   private void loadTransactionsFromFile(String fileName) {
       // Call FileManger method to load transactions from file
       List<Transaction> loadedTransactions = FileManager.loadTransactions(fileName);
       // Update transactions list and list view
       transactions.clear();
       transactions.addAll(loadedTransactions);
       sortTransactions();
   }
    public void updateTransactions(List<Transaction> updatedTransactions) {
        // Clear and update the transactions list
        transactions.clear();
        transactions.addAll(updatedTransactions);
        sortTransactions();
    }

    private void updateTransactionListView(){
       updateTransactionListView(transactions);
    }

   private void updateTransactionListView(List<Transaction> transactions){
       // clear and update the list view with transaction details
       transactionListView.getItems().clear();
       for(Transaction transaction: transactions) {
           transactionListView.getItems().add(transaction.toString());

       }
   }

    // Method to reload transactions from file
    public void reloadTransactionsFromFile() {
        loadTransactionsFromFile(fileInputUI.getFileName());
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        sortTransactions();
    }
   // Method to get the UI layout
    public VBox getLayout() {
        return layout;
    }
}
