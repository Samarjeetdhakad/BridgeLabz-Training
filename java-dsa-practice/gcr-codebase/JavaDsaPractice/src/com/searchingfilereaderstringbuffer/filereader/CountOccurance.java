package com.searchingfilereaderstringbuffer.filereader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountOccurance {
	public static void main(String[] args) {

	        File file=new File("sample.txt"); 
	        String targetWord="java";         
	        int count=0;
	        try (Scanner sc=new Scanner(file)){
	            while(sc.hasNext()){

	                String word=sc.next().toLowerCase(); 
	                word=word.replaceAll("\\W+", "");
	                if(word.equals(targetWord.toLowerCase())){
	                    count++;
	             }
	            }
	            System.out.println("The word \"" + targetWord + "\" appears " + count + " times in the file.");
	        }
	        catch (FileNotFoundException e) {
	            System.out.println("File not found: " + e.getMessage());
	    }
	    }
	    }