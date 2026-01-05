package mybank;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to MyBank!");

        System.out.println("\nSelect account type:");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        sc.nextLine(); 

        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();

        System.out.print("Opening balance?(y/n): ");
        String op = sc.nextLine();

        Account account;

        if (op.equalsIgnoreCase("y")) {
            System.out.print("Enter opening balance: ");
            double bal = sc.nextDouble();

            account = (choice == 1)? new SavingsAccount(accNo, bal) : new CurrentAccount(accNo, bal);

        } else {
            account = (choice == 1)? new SavingsAccount(accNo): new CurrentAccount(accNo);
            }2
        

        System.out.println("\n account created1");
        account.displayDetails();

        System.out.print("\nEnter amount to deposit: INR");
        double dep = sc.nextDouble();
        account.deposit(dep);

        System.out.print("Enter amount to withdraw:INR");
        double wd = sc.nextDouble();
        if (!account.withdraw(wd)) {
            System.out.println(" Withdrawal failed — insufficient funds.");
        }

        System.out.println("\n final account status");
        account.displayDetails();

        System.out.println("\nCalculated Interest:INR" + account.calculateInterest());

        sc.close();
    }
}