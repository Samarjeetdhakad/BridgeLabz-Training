package com.inheritance.hierarchicalinheritance.bankaccounttypes;

class BankAccount {
    long accountNumber;
    double balance;

    void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
    }
}
