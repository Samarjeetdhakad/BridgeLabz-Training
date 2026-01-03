package com.inheritance.hierarchicalinheritance.bankaccounttypes;

public class BankDemo {
    public static void main(String[] args) {

        SavingsAccount sa = new SavingsAccount();
        sa.accountNumber=1111;
        sa.balance=50000;
        sa.interestRate=4.5;

        sa.displayAccountType();
        sa.displayAccountDetails();
        System.out.println("Interest Rate: " + sa.interestRate + "%");
        System.out.println();

        CheckingAccount ca = new CheckingAccount();
        ca.accountNumber = 2222;
        ca.balance = 30000;
        ca.withdrawalLimit = 20000;

        ca.displayAccountType();
        ca.displayAccountDetails();
        System.out.println("Withdrawal Limit: ₹" + ca.withdrawalLimit);
        System.out.println();

        FixedDepositAccount fd = new FixedDepositAccount();
        fd.accountNumber = 3333;
        fd.balance = 100000;
        fd.lockInPeriod = 12;

        fd.displayAccountType();
        fd.displayAccountDetails();
        System.out.println("Lock-in Period: " + fd.lockInPeriod + " months");
    }
}
