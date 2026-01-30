package com.csvhandling.readfile;


import java.io.*;
import java.util.*;

public class Read{
	public static void main(String[]args) {
		String filePath = "student.csv";
		
		try (BufferedReader bis = new BufferedReader(new FileReader(filePath))){
			String line;
			while((line = bis.readLine())!=null) {
			    String[] columns = line.split(",");
			    System.out.println("|"+ columns[0] + "|"+ columns[1]+ " |" + columns[2]+ "|"+ columns[3] );
			}
			
		}catch(IOException e) {
			e.printStackTrace();
			
		};
	}
}