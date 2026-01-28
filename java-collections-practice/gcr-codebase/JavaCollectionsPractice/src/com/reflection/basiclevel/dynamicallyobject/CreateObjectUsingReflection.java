package com.reflection.basiclevel.dynamicallyobject;
import java.lang.reflect.Constructor;

public class CreateObjectUsingReflection {
    public static void main(String[] args) {
        try {
            // Load class dynamically
        	Class<?> cls = Class.forName("com.reflection.basiclevel.dynamicallyobject.Student");


            //Using no-arg constructor
            Object obj1 = cls.getDeclaredConstructor().newInstance();
            Student s1 = (Student) obj1;
            s1.display();
            //Using parameterized constructor
            Constructor<?> constructor = cls.getDeclaredConstructor(int.class, String.class);
            Object obj2 = constructor.newInstance(101, "samarjeet");
            Student s2 = (Student) obj2;
            s2.display();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}