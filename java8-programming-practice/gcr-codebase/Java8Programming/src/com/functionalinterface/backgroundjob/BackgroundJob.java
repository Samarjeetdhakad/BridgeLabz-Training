package com.functionalinterface.backgroundjob;
public class BackgroundJob {
    public static void main(String[] args) {
        Runnable task = () -> {
            System.out.println("Background task running...");
            };
        Thread t = new Thread(task);
        t.start();   

        System.out.println("Main program continues...");
    }
}