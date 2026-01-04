package com.encapsulationpolymorphisminterfaceandabstract.bankingsystem;

class SavingsAccount extends BankAccount implements Loanable {

    private double loanAmount;

    public SavingsAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * 0.04; 
        }

    @Override
    public void applyForLoan(double amount) {
        loanAmount = amount;
        System.out.println("Loan applied for: " + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        return balance >= 5000;
    }
}