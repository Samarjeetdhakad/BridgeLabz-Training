package com.searchcomparision;

import java.io.*;
public class FileInputReader{
	    public static void main(String[] args) throws Exception{
	        String filePath = "largefile.txt"; 
	        long fileReaderTime = benchmarkFileReader(filePath);
	        System.out.println("FileReader Time" + fileReaderTime + "ms");
	        long inputStreamReaderTime = benchmarkInputStreamReader(filePath);
	        System.out.println("InputStreamReader Time" + inputStreamReaderTime + "ms");
	    }
	    public static long benchmarkFileReader(String filePath) {
	        long start=System.nanoTime();
	        try (FileReader fr=new FileReader(filePath)) {
	            char[] buffer=new char[8192]; 
	            while(fr.read(buffer)!=-1) {}
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	        long end=System.nanoTime();
	        return (end-start)/1_000_000;
	    }
	    public static long benchmarkInputStreamReader(String filePath) {
	        long start=System.nanoTime();
	        try (InputStreamReader isr=new InputStreamReader(new FileInputStream(filePath))) {
	            char[] buffer=new char[8192]; 
	            while (isr.read(buffer)!=-1){}
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	        long end=System.nanoTime();
	        return (end-start)/1_000_000; 
    }
	}