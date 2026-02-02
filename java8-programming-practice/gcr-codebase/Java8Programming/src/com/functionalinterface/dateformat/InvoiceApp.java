package com.functionalinterface.dateformat;
import java.time.LocalDate;

public class InvoiceApp {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println("Invoice Date: " +DateUtils.formatDate(today, "dd-MM-yyyy"));
        System.out.println("Report Date: " + DateUtils.formatDate(today, "dd/MM/yyyy"));
        System.out.println("Display Date:" + DateUtils.formatDate(today, "MMM dd, yyyy"));
    }
}