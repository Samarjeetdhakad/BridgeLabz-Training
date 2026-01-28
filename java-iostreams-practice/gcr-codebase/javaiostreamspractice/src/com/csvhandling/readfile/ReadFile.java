package com.csvhandling.readfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {

        String filePath = "students3.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line = br.readLine(); // skip header

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                String course = data[3];
                String email = data[4];
                String phone = data[5];

                System.out.println(id + " | " + name + " | " + age + " | " + course);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
