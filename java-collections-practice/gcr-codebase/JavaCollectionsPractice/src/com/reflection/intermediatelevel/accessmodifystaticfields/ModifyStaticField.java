package com.reflection.intermediatelevel.accessmodifystaticfields;

import java.lang.reflect.Field;

public class ModifyStaticField {
    public static void main(String[] args) {
        try {
            // Get Class object
            Class<?> cls = Configuration.class;
            // Access private static field
            Field field = cls.getDeclaredField("API_KEY");
            // Allow access to private field
            field.setAccessible(true);

            //Get original value 
            String originalKey = (String) field.get(null);
            System.out.println("Original API_KEY" + originalKey);

            //Modify value 
            field.set(null, "NEW_SECRET_KEY");
            //Get updated value
            String updatedKey = (String) field.get(null);
            System.out.println("Updated API_KEY" + updatedKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
