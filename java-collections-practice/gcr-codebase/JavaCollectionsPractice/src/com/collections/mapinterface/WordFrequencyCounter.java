package com.collections.mapinterface;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class WordFrequencyCounter {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("D:\\java programming workspace\\java-collections-practice"
                    		+ "\\gcr-codebase\\JavaCollectionsPractice\\src\\com\\collections\\map"));

            String line;
            while ((line = br.readLine()) != null) {
                line = line.toLowerCase().replaceAll("[^a-z ]", "");
                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (word.isEmpty()) continue;

                    if (map.containsKey(word)) {
                        map.put(word, map.get(word) + 1);
                    } else {
                        map.put(word,1);
                    }
                }
            }
           
        } catch (IOException e) {
            System.out.println(e);
        }
        System.out.println(map);
    }
}