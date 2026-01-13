package com.searchingfilereaderstringbuffer.stringbuffer;

public class CompareStrings {
	public static void main(String[]args) {
		int n=1_000_000;
		StringBuffer sb=new StringBuffer();
		Long startBuffer=System.nanoTime();
		for(int i=0;i<n;i++) {
			sb.append("hello");
		}
		long endBuffer=System.nanoTime();
		long bufferTime=endBuffer - startBuffer;
        StringBuilder sbuilder=new StringBuilder();
        long startBuilder=System.nanoTime();
       for(int i=0;i<n;i++){
            sbuilder.append("hello");
          }
        long endBuilder=System.nanoTime();
        long builderTime=endBuilder-startBuilder;

        System.out.println("Time taken by StringBuffer  : " + bufferTime  );
        System.out.println("Time taken by StringBuilder : " + builderTime);
    }
	}