package com.lambdaexpression.invoicegenerator;
import java.util.*;
import java.util.function.Function;

public class InvoiceGenerator {
	 public static void main(String[] args) {
	        List<String> transactionIds = new ArrayList<>();
	        transactionIds.add("101");
	        transactionIds.add("102");
	        transactionIds.add("103");
	        List<Invoice> invoices = new ArrayList<>();
	        //Constructor Reference
	        Function<String, Invoice> invoiceCreator = Invoice::new;
	        // Normal loop
	        for (String id : transactionIds) {
	            invoices.add(invoiceCreator.apply(id));
	        }
	        // Print invoices
	        for (Invoice inv : invoices) {
	            System.out.println(inv);
	        }
	    }
}

        