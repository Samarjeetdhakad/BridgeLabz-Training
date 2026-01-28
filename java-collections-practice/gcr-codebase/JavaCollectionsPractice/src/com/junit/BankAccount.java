package com.junit;
public class BankAccount {
    private double balance;
    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
    // Withdraw money
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false; // insufficient balance
    }
    // Get current balance
    public double getBalance() {
        return balance;
    }
}