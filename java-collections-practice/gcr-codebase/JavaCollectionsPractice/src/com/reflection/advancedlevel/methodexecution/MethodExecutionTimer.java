package com.reflection.advancedlevel.methodexecution;
import java.lang.reflect.Method;

public class MethodExecutionTimer {
    public static void main(String[] args) {
        try {
            // Create object
            TaskService service = new TaskService();
            // Get Class object
            Class<?> cls = service.getClass();
            // Loop through all method
            for (Method method : cls.getDeclaredMethods()) {
                // Only no-arg methods
                if (method.getParameterCount() == 0) {
                    method.setAccessible(true);
                    long startTime = System.nanoTime();
                    // Invoke method dynamically
                    method.invoke(service);
                    long endTime = System.nanoTime();
                    long duration = endTime - startTime;
                    System.out.println("Method: " + method.getName() + " | Time: " + duration + " ns" );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}