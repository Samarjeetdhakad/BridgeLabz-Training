package com.multithreading.restaurantorder;

public class Chef extends Thread {
	private String dish;
	private int time;
	Chef(String name,String dish,int time){
		super(name);
		this.dish=dish;
		this.time=time;
	}
	public void run() {
		System.out.println(getName()+ " started preparing "+ dish);
		try {
			int []progress= {25,50,75,100};
			for(int p:progress) {
				Thread.sleep(time/4);
				System.out.println(getName()+ " preparing "+ dish + ": "+ p);				
			}
			 System.out.println(getName() + " completed " + dish);
		}
		catch(InterruptedException e) {
			 System.out.println(getName() + " was interrupted");
		}
	}

}