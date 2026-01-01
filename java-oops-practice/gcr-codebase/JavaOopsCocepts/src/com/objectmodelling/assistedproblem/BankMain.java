package com.objectmodelling.assistedproblem;

public class BankMain {
    public static void main(String[] args) {

        Bank bank = new Bank("State Bank", 5);

        Customer c1=new Customer("Aman",3);
        Customer c2=new Customer("Riya",3);

        bank.openAccount(c1,101,5000);
        bank.openAccount(c1,102,12000);
        bank.openAccount(c2,201,8000);

        System.out.println();
        c1.viewBalance();
        System.out.println();
        c2.viewBalance();
    }
}