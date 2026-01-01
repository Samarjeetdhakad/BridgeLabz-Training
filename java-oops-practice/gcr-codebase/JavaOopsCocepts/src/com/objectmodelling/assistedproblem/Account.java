package com.objectmodelling.assistedproblem;

class Account {
    int accountNumber;
    double balance;
    Bank bank;

    Account(int accountNumber, double balance, Bank bank) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.bank = bank;
    }

    double getBalance() {
        return balance;
    }
}