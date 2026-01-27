package com.javastreams;

import java.io.*;

public class UserInputFromConsole {
	public static void main(String[] args) {
		try(
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				FileWriter fw = new FileWriter("D:\\java programming workspace\\java-collections-practice\\gcr-codebase\\JavaCollectionsPractice\\src\\com\\javastreams\\outputfile\\user_details.txt"))
		{
		    // Read input from console
	            System.out.print("Enter your name");
	            String name = br.readLine();	
	            System.out.print("Enter your age:");
	            String age = br.readLine();
	
	            System.out.print("Enter your favorite programming language");
	            String language = br.readLine();	           
	            fw.write("Name: " + name + "\n");
	            fw.write("Age: " + age + "\n");
	            fw.write("Favorite Language:" + language + "\n");
	
	            System.out.println("\nData saved successfully to file");
        }
		catch(IOException e){
        	e.printStackTrace();
        }
	}

}