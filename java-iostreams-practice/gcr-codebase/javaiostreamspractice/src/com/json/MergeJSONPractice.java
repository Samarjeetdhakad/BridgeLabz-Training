package com.json;

import org.json.JSONObject;

public class MergeJSONPractice {
    public static void main(String[] args) {
        // First JSON object
        JSONObject json1 = new JSONObject();
        json1.put ("name", "samarjeet");
        json1.put ("age", 22);

        // Second JSON object
       
        JSONObject json2 = new JSONObject();
        json2.put("gmail", "samarjeet@gmail");
        json2.put("city", "delhi");
        // Merge json2 into json1
       
        for(String key : json2.keySet()) {
        	json1.put(key, json2.get(key));
        }
        System.out.println(json1.toString(4));
    }
}