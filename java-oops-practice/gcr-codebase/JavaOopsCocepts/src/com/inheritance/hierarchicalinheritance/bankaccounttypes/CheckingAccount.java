package com.inheritance.hierarchicalinheritance.bankaccounttypes;

class CheckingAccount extends BankAccount {
    double withdrawalLimit;

    void displayAccountType() {
        System.out.println("Account Type: Checking Account");
    }
}
