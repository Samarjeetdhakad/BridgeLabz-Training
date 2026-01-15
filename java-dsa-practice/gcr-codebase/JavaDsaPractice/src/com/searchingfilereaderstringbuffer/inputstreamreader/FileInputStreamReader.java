package com.searchingfilereaderstringbuffer.inputstreamreader;
import java.io.*;

public class FileInputStreamReader{
public static void main(String[] args) {

        String filePath = "output.txt";

        try {
            
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            
            FileWriter fw = new FileWriter(filePath);

            System.out.println("Enter text (type 'exit' to stop):");

            String input;

            while (true) {
                input = br.readLine();   

                if (input.equalsIgnoreCase("exit")) {
                    break;  
                }

                fw.write(input + "\n"); 
            }
           
            fw.close();
            br.close();
            isr.close();

            System.out.println("Data successfully written to " + filePath);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
