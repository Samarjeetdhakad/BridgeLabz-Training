package mybank;

public abstract class Account implements ITransaction {

    private String accountNumber;
    private double balance;  

    public Account(String accountNumber) {
        this.accountNumber=accountNumber;
        this.balance=0;
    }

    public Account(String accountNumber, double openingBalance) {
        this.accountNumber=accountNumber;
        this.balance=openingBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double checkBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0)
            balance +=amount;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && amount<=balance) {
            balance -=amount;
            return true;
        }
        return false;
    }

    protected double getBalanceInternal() {
        return balance;
    }

    public abstract double calculateInterest();

    public void displayDetails() {
        System.out.println("Account No:" + accountNumber +"|Balance:" + balance);
    }
}