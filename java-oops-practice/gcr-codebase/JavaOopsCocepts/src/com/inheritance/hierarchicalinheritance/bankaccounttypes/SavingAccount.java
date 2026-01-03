package com.inheritance.hierarchicalinheritance.bankaccounttypes;

class SavingsAccount extends BankAccount {
    double interestRate;

    void displayAccountType() {
        System.out.println("Account Type: Savings Account");
    }
}
