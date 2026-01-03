package com.inheritance.hierarchicalinheritance.bankaccounttypes;

class FixedDepositAccount extends BankAccount {
    int lockInPeriod; 

    void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
    }
}
