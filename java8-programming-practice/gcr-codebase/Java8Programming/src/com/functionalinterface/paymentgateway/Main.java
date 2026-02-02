package com.functionalinterface.paymentgateway;

public class Main {
	    public static void main(String[] args) {
	        PaymentProcessor card = new CreditCardPayment();
	        PaymentProcessor upi = new UPIPayment();	     
	        card.processPayment(5000);
	        card.refund(5000);
	        upi.processPayment(1200);
	        upi.refund(1200);

	    }
	}

