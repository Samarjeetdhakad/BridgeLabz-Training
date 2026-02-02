package com.functionalinterface.dataserialization;

public class Main {
	    public static void main(String[] args) {
	        Customer customer = new Customer(1, "samarjeet");
	        BackupProcessor.backupObject(customer); 	      
	    }
	}

