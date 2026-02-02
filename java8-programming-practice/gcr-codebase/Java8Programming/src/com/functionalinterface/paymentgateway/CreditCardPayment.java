package com.functionalinterface.paymentgateway;
class CreditCardPayment implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        System.out.println("Credit Card payment of " + amount + " processed");
    }
}