package com.multithreading.threadstatemonitoring;

public class Main {
	    public static void main(String[] args) throws InterruptedException {
	        TaskRunner task1=new TaskRunner("Task-1");
	        TaskRunner task2=new TaskRunner("Task-2");
	        StateMonitor monitor=new StateMonitor(task1, task2);
	        monitor.start();

	        task1.start();
	        task2.start();

	        task1.join();
	        task2.join();
	        monitor.join();
	    }
	}

