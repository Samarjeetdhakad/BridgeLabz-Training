package com.multithreading.banksystem;

import java.time.LocalDateTime;

class Transaction implements Runnable {
    private BankAccount account;
    private int amount;
    private String customerName;
    public Transaction(BankAccount account, int amount, String customerName) {
        this.account = account;
        this.amount = amount;
        this.customerName = customerName;
    }

    @Override
    public void run() {
        System.out.println("[" + Thread.currentThread().getName() + "] Attempting to withdraw " + amount);
        boolean success = account.withdraw(amount);
        if (success) {
            System.out.println("Transaction successful: " + customerName +
                    ", Amount: " + amount +
                    ", Balance: " + account.getBalance() +
                    ", Time: " + LocalDateTime.now());
        } else {
            System.out.println("Transaction failed: " + customerName +
                    ", Amount: " + amount +
                    ", Insufficient balance, Time: " + LocalDateTime.now());
        }
    }
}