package com.encapsulationpolymorphisminterfaceandabstract.bankingsystem;

abstract class BankAccount {

    private String accountNumber;
    private String holderName;
    protected double balance;   

    
    public BankAccount(String accNo, String holderName, double balance) {
        this.accountNumber = accNo;
        this.holderName = holderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public abstract double calculateInterest();

    public void displayAccountDetails() {
        System.out.println("Account No : " + accountNumber);
        System.out.println("Holder     : " + holderName);
        System.out.println("Balance    : " + balance);
    }

    
    public double getBalance() {
        return balance;
    }
    
}