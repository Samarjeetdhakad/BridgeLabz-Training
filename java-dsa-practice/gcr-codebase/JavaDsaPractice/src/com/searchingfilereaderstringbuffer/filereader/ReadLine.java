package com.searchingfilereaderstringbuffer.filereader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ReadLine{
	public static void main(String[] args) {
        File file=new File("sampl.txt"); 
        try(Scanner sc=new Scanner(file)){
            while(sc.hasNextLine()){
                String line=sc.nextLine();
                System.out.println(line);
         }
        } 
        catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
  }
 }
}