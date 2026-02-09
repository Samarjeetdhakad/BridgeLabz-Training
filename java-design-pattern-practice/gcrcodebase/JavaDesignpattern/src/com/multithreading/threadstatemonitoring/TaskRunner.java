package com.multithreading.threadstatemonitoring;

public class TaskRunner extends Thread{
	TaskRunner(String name){
		super(name);
	}
public void run() {
	try {
		for(int i=0;i<1_000_000;i++) {
			Math.sqrt(i);
		}
		Thread.sleep(2000);
		for(int i=0;i<1_000_000;i++) {
			Math.sqrt(i);
		}
	}
		catch(InterruptedException e) {
			System.out.println(getName()+" interrupted");
		}
	
}
}