package e_walletapplication;
import java.util.ArrayList;

public class Wallet{

    private double balance;  
    protected ArrayList<Transaction> history = new ArrayList<>();

   
    Wallet(){
        this.balance = 0;
    }

    Wallet(double referralBonus){
        this.balance = referralBonus;
        history.add(new Transaction("Referral Bonus", referralBonus));
    }

    protected void credit(double amount){
        balance += amount;
        history.add(new Transaction("Money Added", amount));
    }

    protected boolean debit(double amount){
        if (balance >= amount) {
            balance -= amount;
            history.add(new Transaction("Money Deducted", amount));
            return true;
        }
        return false;
    }

    
    void transferTo(User receiver, double amount) {
        System.out.println("Transfer not supported");
    }

    public double getBalance() {
        return balance;
    }

    void showHistory() {
        for (Transaction t : history) {
            t.show();
        }
    }
}