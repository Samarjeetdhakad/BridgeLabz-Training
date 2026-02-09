package com.multithreading.filedownloader;

public class FileDownloader extends Thread {
	private String fileName;
	FileDownloader(String fileName){
		this.fileName=fileName;		
	}
	public void run() {
		try {
			for(int i=0;i<=100;i++) {
				System.out.println(Thread.currentThread().getName()+ fileName+ i);
				Thread.sleep((int)(Math.random()*500));
			}			
		}
		catch(InterruptedException e){
			System.out.println(fileName+ " interrupted");
			
		}
	}

}