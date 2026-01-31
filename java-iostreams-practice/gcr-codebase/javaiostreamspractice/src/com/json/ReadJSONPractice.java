package com.json;

import java.io.BufferedReader;
import java.io.FileReader;

import org.json.JSONObject;

public class ReadJSONPractice {
    public static void main(String[] args) {
        String filePath = 
        		"D:\\java programming workspace\\java-iostreams-practice\\gcr-codebase\\JavaIOStreamsPractice\\src\\sampleJSON\\user.json";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder jsonData = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                jsonData.append(line);
            }
            // Convert file content to JSONObject
            JSONObject jsonObject = new JSONObject(jsonData.toString());
            // Extract specific fields
            String name = jsonObject.getString("name");
            String email = jsonObject.getString("email");
            // Print extracted fields
            System.out.println("Name  : " + name);
            System.out.println("Email : " + email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}