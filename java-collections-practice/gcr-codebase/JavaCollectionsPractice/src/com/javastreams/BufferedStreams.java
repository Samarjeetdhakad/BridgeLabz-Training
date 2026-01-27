package com.javastreams;
import java.io.*;

public class BufferedStreams {
    private static final int BUFFER_SIZE = 4096; // 4 KB
    public static void main(String[] args) {
        String sourceFile = "D:\\java programming workspace\\java-collections-practice\\gcr-codebase\\JavaCollectionsPractice\\src\\com\\javastreams\\inputfile\\source.txt";  

        String unbufferedCopy ="D:\\java programming workspace\\java-collections-practice\\gcr-codebase\\JavaCollectionsPractice\\src\\com\\javastreams\\outputfile\\unbufferedcopy.txt";

        String bufferedCopy =  "D:\\java programming workspace\\java-collections-practice\\gcr-codebase\\JavaCollectionsPractice\\src\\com\\javastreams\\outputfile\\bufferedcopy.txt";
        copyUsingUnbufferedStreams(sourceFile, unbufferedCopy);
        copyUsingBufferedStreams(sourceFile, bufferedCopy);
    }
   
    private static void copyUsingUnbufferedStreams(String src, String dest) {
        long startTime = System.nanoTime();
        try (
            FileInputStream fis = new FileInputStream(src);
            FileOutputStream fos = new FileOutputStream(dest)
        ) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1){
                fos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.nanoTime();
        System.out.println("Unbuffered Stream Time: "
                + (endTime - startTime) + " ns");
    }
 
    private static void copyUsingBufferedStreams(String src, String dest){
        long startTime = System.nanoTime();
        try (
            BufferedInputStream bis =new BufferedInputStream(new FileInputStream(src));
            BufferedOutputStream bos =new BufferedOutputStream(new FileOutputStream(dest))){
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1){
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.nanoTime();
        System.out.println("Buffered Stream Time:" + (endTime - startTime) + " ns");
    }
}