package e_walletapplication;

public class Transaction {

    String description;
    double amount;

    Transaction(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    void show() {
        System.out.println(description + " :" + amount);
    }
}