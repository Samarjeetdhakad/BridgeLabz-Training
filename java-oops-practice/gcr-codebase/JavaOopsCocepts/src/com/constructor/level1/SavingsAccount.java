package com.constructor.level1;

class SavingsAccount extends BankAccount {

    double interestRate;
    SavingsAccount(String accountNumber,String accountHolder,double balance,double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate=interestRate;
    }
    void displayAccountDetails() {
        System.out.println("Account Number: "+accountNumber);   
        System.out.println("Account Holder: "+accountHolder);   
        System.out.println("Balance:"+getBalance());          
        System.out.println("Interest Rate:"+interestRate+"%");
    }
}
