package com.csvhandling.searchrecord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SearchRecord {
	 public static void main(String[] args) {
	        String filePath = "employees.csv";
	        String searchName = "Riya";
	        boolean found = false;
	        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

	            String line;
	            br.readLine();
	            while ((line = br.readLine()) != null) {
	                String[] data = line.split(",");
	                String name = data[1];
	                if (name.equalsIgnoreCase(searchName)) {
	                    String department = data[2];
	                    String salary = data[3];
	                    System.out.println("Employee Found");
	                    System.out.println("Name : " + name);
	                    System.out.println("Department:" + department);
	                    System.out.println("Salary: " + salary);

	                    found = true;
	                    break;
	                }
	            }
	            if (!found) {
	                System.out.println("Employee not found");
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

}