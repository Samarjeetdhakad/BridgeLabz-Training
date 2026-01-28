package com.csvhandling.writefile;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class WriteFile {
	    public static void main(String[] args) {
	        String filePath = "employees.csv";
	        try (BufferedWriter bw=new BufferedWriter(new FileWriter(filePath))) {
	            bw.write("ID,Name,Department,Salary");
	            bw.newLine();

	            bw.write("101,Ankit,IT,55000");
	            bw.newLine();

	            bw.write("102,Riya,HR,48000");
	            bw.newLine();
	            bw.write("103,Rahul,Finance,62000");
	            bw.newLine();

	            bw.write("104,Pooja,Marketing,50000");
	            bw.newLine();
	            bw.write("105,Amit,IT,70000");
	            bw.newLine();
	            System.out.println("employees.csv file created successfully");
	        } 
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}