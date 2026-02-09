package com.multithreading.filedownloader;

public class Main {
	public static void main(String[]args) throws InterruptedException {
		FileDownloader f1=new FileDownloader("Document.pdf");
		FileDownloader f2=new FileDownloader("Image.jpg");
		FileDownloader f3=new FileDownloader("Video.mp4");
		f1.start();
		f2.start();
		f3.start();
		
		f1.join();
		f2.join();
		f3.join();		
		System.out.println("All downloads complete");
		
	}

}