package com.encapsulationpolymorphisminterfaceandabstract.bankingsystem;

interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}