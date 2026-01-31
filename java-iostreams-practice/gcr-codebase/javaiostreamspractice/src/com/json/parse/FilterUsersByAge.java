package com.json.parse;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;

public class FilterUsersByAge {

    public static void main(String[] args) {

        try {
            //  Read JSON file into String
            String jsonData = new String(
                    Files.readAllBytes(Paths.get("users.json")));
            //  Parse String → JSONArray
            JSONArray jsonArray = new JSONArray(jsonData);
            System.out.println("People with age > 25:");
            //  Loop and filter
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                int age = obj.getInt("age");
                if (age > 25) {
                    System.out.println( "ID: " + obj.getInt("id") + ", Name: " + obj.getString("name") + ", Age: " + age );
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
