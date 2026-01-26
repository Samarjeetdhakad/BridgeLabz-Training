package com.collections.mapinterface;
import java.util.HashMap;
import java.util.Map;

public class MergeTwoMaps {
    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);
        Map<String, Integer> result = new HashMap<>();
     
        for (Map.Entry<String, Integer> e:map1.entrySet()) {
            result.put(e.getKey(),e.getValue());
        }
        
        for (Map.Entry<String, Integer>e: map2.entrySet()) {
            String key = e.getKey();
            int value = e.getValue();

            if (result.containsKey(key)) {
                result.put(key, result.get(key) + value);
            } else {
                result.put(key, value);
            }
        }
        System.out.println(result);
    }
}