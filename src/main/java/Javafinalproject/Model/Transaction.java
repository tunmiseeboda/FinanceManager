package Javafinalproject.Model;

public class Transaction {
    // instance variables
    double amount;
    String category;
    String description;
    String date;

    // constructor
    public Transaction(double amount, String category, String description, String date) {
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.date = date;
    }

    // getters
    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    // setters
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    // toString
    @Override
    public String toString() {
        return "Transaction[ " +
                "amount=" + amount + ", category=" + category + ", description=" + description + ", date="
                + date + "]";
    }
}
