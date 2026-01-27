package com.javastreams;
import java.io.*;

public class FileHandling {
	
	public static void main(String[] args) {
		try(FileInputStream fis = new FileInputStream("D:\\java programming workspace\\java-collections-practice\\gcr-codebase\\JavaCollectionsPractice\\src\\com\\javastreams\\inputfile\\hello.txt")){
			FileOutputStream fos = new FileOutputStream("D:\\java programming workspace\\java-collections-practice\\gcr-codebase\\JavaCollectionsPractice\\src\\com\\javastreams\\outputfile\\filehandling.txt");
			
			int byteData;
			while((byteData = fis.read()) != -1) {
				fos.write(byteData);
			}
			System.out.println("File read and write successfully");
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}

}