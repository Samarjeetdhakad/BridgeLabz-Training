package com.searchingfilereaderstringbuffer.inputstreamreader;


import java.io.*;
public class ConvertStream {
	    public static void main(String[] args) {
	        String filePath = "sample.txt";

	        try {
	            FileInputStream fis=new FileInputStream(filePath);
	            InputStreamReader isr=new InputStreamReader(fis, "UTF-8");
	            BufferedReader br=new BufferedReader(isr);
	            String line;
	            while ((line=br.readLine())!=null) {
	                System.out.println(line);
	            }
	            br.close();
	            isr.close();
	            fis.close();
	        }
	        catch (IOException e){
	            System.out.println("Error reading file: " + e.getMessage());
	     }
	    }
	    }