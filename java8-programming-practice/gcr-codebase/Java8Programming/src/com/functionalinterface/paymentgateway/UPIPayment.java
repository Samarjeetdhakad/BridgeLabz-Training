package com.functionalinterface.paymentgateway;
class UPIPayment implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        System.out.println("UPI payment of " + amount + " processed");
    }
}