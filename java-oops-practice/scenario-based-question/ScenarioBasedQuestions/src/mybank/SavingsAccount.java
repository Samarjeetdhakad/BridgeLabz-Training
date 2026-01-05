package mybank;

public class SavingsAccount extends Account {

    private double interestRate = 4.5;

    public SavingsAccount(String accNo) {
        super(accNo);
    }

    public SavingsAccount(String accNo, double openingBalance) {
        super(accNo, openingBalance);
    }

    @Override
    public double calculateInterest() {       
        return getBalanceInternal()*interestRate/100;
    }

    @Override
    public void displayDetails() {
        System.out.println("Savings Account | " +"Acc No: " + getAccountNumber() +" | Balance: INR " + checkBalance());
    }
}