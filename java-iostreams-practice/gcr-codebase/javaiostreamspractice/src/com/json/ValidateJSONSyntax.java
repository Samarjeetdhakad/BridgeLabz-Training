package com.json;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class ValidateJSONSyntax {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.readTree(new File("D:\\java programming workspace\\java-iostreams-practice\\gcr-codebase\\JavaIOStreamsPractice\\src\\sampleJSON\\user.json"));
            System.out.println("JSON is VALID");
        } catch (Exception e) {
            System.out.println("Invalid JSON");
            e.printStackTrace();
        }
    }
}