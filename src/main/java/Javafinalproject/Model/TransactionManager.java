package Javafinalproject.Model;

import Javafinalproject.Model.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class TransactionManager {

    // Method to sort transactions by date
    public static void sortByDate(List<Transaction> transactions) {
        Collections.sort(transactions, (t1, t2) -> t1.getDate().compareTo(t2.getDate()));
    }

    // Method to sort transactions by amount
    public static void sortByAmount(List<Transaction> transactions) {
        Collections.sort(transactions, (t1, t2) -> Double.compare(t1.getAmount(), t2.getAmount()));
    }

    // Method to sort transactions by category
    public static void sortByCategory(List<Transaction> transactions) {
        Collections.sort(transactions, (t1, t2) -> t1.getCategory().compareTo(t2.getCategory()));
    }

    //Method to Search transactions by keyword, category, date or amount
    public static List<Transaction> searchTransactions(List<Transaction> transactions, String keyword) {
        List<Transaction> searchResults = new ArrayList<>();
        for (Transaction t : transactions) {
            if (t.getDescription().contains(keyword) || t.getCategory().contains(keyword) || t.getDate().contains(keyword)
                    || String.valueOf(t.getAmount()).contains(keyword)) {
                searchResults.add(t);
            }
        }
        return searchResults;
    }
}
