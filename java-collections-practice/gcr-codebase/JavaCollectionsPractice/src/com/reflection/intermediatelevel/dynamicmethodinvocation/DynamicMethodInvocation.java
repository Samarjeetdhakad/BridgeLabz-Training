package com.reflection.intermediatelevel.dynamicmethodinvocation;

import java.lang.reflect.Method;
import java.util.Scanner;

public class DynamicMethodInvocation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter method name (add / subtract / multiply): ");
        String methodName = sc.nextLine();
        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        try {
            // Create object dynamically
            MathOperations obj = new MathOperations();
            // Get Class object
            Class<?> cls = obj.getClass();

            // Get method dynamically
            Method method = cls.getMethod(methodName, int.class, int.class);
            // Invoke method
            int result = (int) method.invoke(obj, a, b);
            // Display result
            System.out.println("Result: " + result);
        } catch (NoSuchMethodException e) {
            System.out.println("Invalid method name!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}