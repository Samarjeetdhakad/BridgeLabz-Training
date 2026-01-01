package com.objectmodelling.assistedproblem;

class Customer {
    String name;
    Account[] accounts;
    int accountCount = 0;

    Customer(String name, int maxAccounts) {
        this.name = name;
        accounts = new Account[maxAccounts];
    }

    void addAccount(Account account) {
        accounts[accountCount++] = account;
    }

    void viewBalance() {
        System.out.println("Account details of " + name + ":");
        for (int i = 0; i < accountCount; i++) {
            System.out.println("Account No: " + accounts[i].accountNumber +", Balance: ₹" + accounts[i].getBalance() +", Bank: " + accounts[i].bank.bankName);
        }
    }
}
