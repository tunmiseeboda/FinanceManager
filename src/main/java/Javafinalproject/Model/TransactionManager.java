package Javafinalproject.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TransactionManager {

    // Method to sort transactions by date
    public static void sortByDate(List<Transaction> transactions) {
        Collections.sort(transactions, new Comparator<Transaction>() {
            @Override
            public int compare(Transaction t1, Transaction t2) {
                String[] parts1 = t1.getDate().split("/");
                String[] parts2 = t2.getDate().split("/");

                // Extract month, day, year
                int month1 = Integer.parseInt(parts1[0]);
                int day1 = Integer.parseInt(parts1[1]);
                int year1 = Integer.parseInt(parts1[2]);

                int month2 = Integer.parseInt(parts2[0]);
                int day2 = Integer.parseInt(parts2[1]);
                int year2 = Integer.parseInt(parts2[2]);

                // Compare years
                if (year1 != year2) {
                    return Integer.compare(year1, year2);
                }

                // Compare months
                if (month1 != month2) {
                    return Integer.compare(month1, month2);
                }

                // Compare days
                return Integer.compare(day1, day2);
            }
        });
    }

    // Method to sort transactions by amount
    public static void sortByAmount(List<Transaction> transactions) {
        Collections.sort(transactions, (t1, t2) -> Double.compare(t1.getAmount(), t2.getAmount()));
    }

    // Method to sort transactions by category
    public static void sortByCategory(List<Transaction> transactions) {
        Collections.sort(transactions, new Comparator<Transaction>() {
            @Override
            public int compare(Transaction t1, Transaction t2) {
                // Compare categories
                int categoryComparison = t1.getCategory().compareToIgnoreCase(t2.getCategory());

                // If categories are the same, sort alphabetically within the category
                if (categoryComparison == 0) {
                    return t1.getDescription().compareTo(t2.getDescription());
                } else {
                    return categoryComparison;
                }
            }
        });
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
