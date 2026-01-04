package com.encapsulationpolymorphisminterfaceandabstract.bankingsystem;

public class BankingSystem {

    public static void main(String[] args) {

        BankAccount acc1=new SavingsAccount("SB101","Amit",8000);
        BankAccount acc2=new CurrentAccount("CA201","Rohit",15000);

        BankAccount[] accounts = { acc1, acc2 };

        for (BankAccount acc : accounts) {
            acc.displayAccountDetails();

            double interest = acc.calculateInterest();
            System.out.println("Interest Earned:"+interest);

            if (acc instanceof Loanable) {
                Loanable loan =(Loanable) acc;
                loan.applyForLoan(50000);

                if (loan.calculateLoanEligibility()) {
                    System.out.println("Loan Approved");
                } else {
                    System.out.println("Loan Rejected");
                }
            }
        }
    }
}