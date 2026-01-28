package com.reflection.basiclevel.accessprivatefield;
import java.lang.reflect.Field;

public class AccessPrivateField {
    public static void main(String[] args) {
        try {
            // Create object
            Person person = new Person(25);
            // Get Class object
            Class<?> cls = person.getClass();
            // Access private field "age"
            Field ageField = cls.getDeclaredField("age");

            // Make private field accessible
            ageField.setAccessible(true);
            int ageValue = (int) ageField.get(person);
            System.out.println("Original Age: " + ageValue);

            ageField.set(person, 30);
            //Get updated value
            int updatedAge = (int) ageField.get(person);
            System.out.println("Updated Age: " + updatedAge);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}