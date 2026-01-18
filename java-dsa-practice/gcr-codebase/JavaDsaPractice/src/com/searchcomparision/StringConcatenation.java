package com.searchcomparision;

import java.util.*;
public class StringConcatenation{
	    public static void main(String[] args){
	        Scanner sc=new Scanner(System.in);
	        int n=sc.nextInt();
	        //string
	        long start=System.nanoTime();
	        String s ="";
	        for(int i=0;i<n;i++){
	            s=s+"a";  
	        }
	        long end=System.nanoTime();
	        long stringTime=end-start;
	        //stringbuilder
	        start=System.nanoTime();
	        StringBuilder sb=new StringBuilder();
	        for (int i=0;i<n;i++) {
	            sb.append("a"); 
	        }
	        end=System.nanoTime();
	        long builderTime=end-start;
	        //stringbuffer
	        start = System.nanoTime();
	        StringBuffer sbf=new StringBuffer();
	        for (int i=0;i<n;i++) {
	            sbf.append("a");  
	        }
	        end=System.nanoTime();
	        long bufferTime=end-start;
	        System.out.println("String Time" + stringTime + " ns(" + (stringTime / 1_000_000.0) + " ms)");
	        System.out.println("StringBuilder Time" + builderTime + " ns(" + (builderTime / 1_000_000.0) + " ms)");
	        System.out.println("StringBuffer Time " + bufferTime + " ns(" + (bufferTime / 1_000_000.0) + " ms)");
	  }
	}