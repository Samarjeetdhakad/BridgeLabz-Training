package com.javastreams;
import java.io.*;

public class ByteArrayStream {
    public static void main(String[] args){
        String source = "D:\\java programming workspace\\java-collections-practice\\gcr-codebase\\JavaCollectionsPractice\\src\\com\\javastreams\\inputfile\\img.JPG";
        String dest ="D:\\java programming workspace\\java-collections-practice\\gcr-codebase\\JavaCollectionsPractice\\src\\com\\javastreams\\outputfile\\image_copy.JPG";
        try (
            FileInputStream fis = new FileInputStream(source);
            ByteArrayOutputStream baos = new ByteArrayOutputStream()) 
        {
            int byteData;
            while ((byteData = fis.read())!= -1) {
                baos.write(byteData);
            }
            byte[] imageBytes = baos.toByteArray();
            try (
                ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
                FileOutputStream fos = new FileOutputStream(dest) )
            {
                while ((byteData = bais.read()) != -1) {
                    fos.write(byteData);
                }
            }
            System.out.println("Image copied using ByteArray streams");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}