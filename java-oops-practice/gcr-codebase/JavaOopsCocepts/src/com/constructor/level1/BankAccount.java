package com.constructor.level1;

class BankAccount {

    public String accountNumber;    
    protected String accountHolder;  
    private double balance;          

    BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber=accountNumber;
        this.accountHolder=accountHolder;
        this.balance=balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance>=0) {
            this.balance=balance;
        } else {
            System.out.println("Balance cannot be negative!");
        }
    }
}
