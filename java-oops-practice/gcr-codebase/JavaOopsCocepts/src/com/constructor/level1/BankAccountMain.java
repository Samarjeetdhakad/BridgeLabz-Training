package com.constructor.level1;

public class BankAccountMain {
	    public static void main(String[] args) {

	        SavingsAccount sa = new SavingsAccount("ACC12345", "Samarjeet", 15000  ,4.5 );

	        sa.displayAccountDetails();
	        sa.setBalance(20000);
	        System.out.println("Updated Balance:" + sa.getBalance());
	    }
	}



