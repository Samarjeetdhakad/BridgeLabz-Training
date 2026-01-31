package com.csvhandling.mergecsv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class MergeCSV {
	    public static void main(String[] args) {
	        String file1 = "students1.csv";
	        String file2 = "students2.csv";
	        String outputFile="students_merged.csv";
	        Map<String, String[]> studentDetails=new HashMap<String, String[]>();
	        String line;
	        try{
	            BufferedReader br1=new BufferedReader(new FileReader(file1));
	            br1.readLine();
	            while ((line=br1.readLine())!=null) {
	                String[]data=line.split(",");
	                studentDetails.put(data[0],new String[]{data[1],data[2]});
	            }
	            br1.close();
	            BufferedReader br2=new BufferedReader(new FileReader(file2));
	            br2.readLine();
	            BufferedWriter bw=new BufferedWriter(new FileWriter(outputFile));
	            bw.write("ID,Name,Age,Marks,Grade");
	            bw.newLine();
	            while ((line=br2.readLine())!=null) {
	                String[]data=line.split(",");
	                String id=data[0];
	                String marks=data[1];
	                String grade=data[2];
	                if (studentDetails.containsKey(id)) {
	                    String[] info=studentDetails.get(id);
	                    bw.write(id +"," + info[0] + "," + info[1] + "," + marks + "," + grade);
	                    bw.newLine();
	                }
	            }
	            br2.close();
	            bw.close();

	            System.out.println("students_merged.csv created successfully!");
	        } 
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}