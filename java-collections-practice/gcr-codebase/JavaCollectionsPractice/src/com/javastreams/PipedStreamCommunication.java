package com.javastreams;
import java.io.*;

public class PipedStreamCommunication {
    public static void main(String[] args) {
        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream();
            pis.connect(pos);

            Thread writerThread = new Thread(() -> {
                try {
                    String data = "Data sent from Writer Thread";
                    pos.write(data.getBytes());
                    pos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
          
            Thread readerThread = new Thread(() -> {
                try {
                    int ch;
                    while ((ch = pis.read()) != -1) {
                        System.out.print((char) ch);
                    }
                    pis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            readerThread.start();
            writerThread.start();
            writerThread.join();
            readerThread.join();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}