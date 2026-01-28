package com.reflection.advancedlevel.createcustomobjectmapper;
import java.lang.reflect.Field;
import java.util.Map;

public class ObjectMapperUtil{
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties){
        try {
            // Create object using no-arg constructor
            T obj = clazz.getDeclaredConstructor().newInstance();
            // Iterate over map entries
            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                String fieldName = entry.getKey();
                Object fieldValue = entry.getValue();
                // Get field from class
                Field field = clazz.getDeclaredField(fieldName);

                // Allow access to private field
                field.setAccessible(true);
                // Set value
                field.set(obj, fieldValue);
            }
            return obj;
        } catch (Exception e) {
            throw new RuntimeException("Object mapping failed", e);
        }
    }
}