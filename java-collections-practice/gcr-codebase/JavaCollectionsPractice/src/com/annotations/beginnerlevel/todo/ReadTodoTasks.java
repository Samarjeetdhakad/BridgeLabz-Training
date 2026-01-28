package com.annotations.beginnerlevel.todo;

import java.lang.reflect.Method;

public class ReadTodoTasks {
    public static void main(String[] args) {
        Class<ProjectTasks> cls = ProjectTasks.class;
        for (Method method : cls.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);

                System.out.println("Method Name : " + method.getName());
                System.out.println("Task        : " + todo.task());
                System.out.println("Assigned To : " + todo.assignedTo());
                System.out.println("Priority    : " + todo.priority());
            }
        }
    }
}