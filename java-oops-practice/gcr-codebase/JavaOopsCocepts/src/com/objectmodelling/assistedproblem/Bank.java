package com.objectmodelling.assistedproblem;

class Bank {
    String bankName;
    Customer[] customers;
    int customerCount = 0;

    Bank(String bankName, int maxCustomers) {
        this.bankName = bankName;
        customers = new Customer[maxCustomers];
    }

    // Communication method
    void openAccount(Customer customer, int accNo, double balance) {
        Account account = new Account(accNo, balance, this);
        customer.addAccount(account);
        customers[customerCount++] = customer;

        System.out.println("Account opened for " + customer.name +
                           " in " + bankName);
    }
}