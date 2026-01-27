package com.javastreams;
import java.io.*;

public class ReadLargeFile{
    public static void main(String[] args){
        String filePath = "D:\\java programming workspace\\java-collections-practice\\gcr-codebase\\JavaCollectionsPractice\\src\\com\\javastreams\\inputfile\\readlarge.txt";
       try (
            BufferedReader br =
                new BufferedReader(new FileReader(filePath))
        ) {
            String line;
            while ((line = br.readLine())!= null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}