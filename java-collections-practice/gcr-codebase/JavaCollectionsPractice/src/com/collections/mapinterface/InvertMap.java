package com.collections.mapinterface;
import java.util.*;

public class InvertMap {
    public static void main(String[] args) {
        Map<String, Integer> input=new HashMap<>();
        input.put("A", 1);
        input.put("B",2);
        input.put("C", 1);
        Map<Integer, List<String>> inverted=new HashMap<>();
        for (Map.Entry<String, Integer> entry : input.entrySet()) {

            String key = entry.getKey();
            Integer value = entry.getValue();

            if (!inverted.containsKey(value)) {
                inverted.put(value, new ArrayList<>());
            }

            inverted.get(value).add(key);
        }
        System.out.println(inverted);
    }
}