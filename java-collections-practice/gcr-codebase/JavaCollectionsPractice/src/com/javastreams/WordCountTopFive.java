package com.javastreams;
import java.io.*;
import java.util.*;

public class WordCountTopFive {
    public static void main(String[] args) {
        String filePath = "D:\\java programming workspace\\java-collections-practice\\gcr-codebase\\JavaCollectionsPractice\\src\\com\\javastreams\\inputfile\\source.txt";
        
        HashMap<String, Integer> wordCountMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {


                line = line.toLowerCase().replaceAll("[^a-z ]", "");

                // Split line into words
                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountMap.put(
                            word,
                            wordCountMap.getOrDefault(word, 0) + 1
                        );
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Map.Entry<String, Integer>> list =
            new ArrayList<>(wordCountMap.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());
        
        System.out.println("Top 5 most frequent words:");
        int count = 0;
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
            count++;
            if (count == 5) {
                break;
            }
        }
    }
}