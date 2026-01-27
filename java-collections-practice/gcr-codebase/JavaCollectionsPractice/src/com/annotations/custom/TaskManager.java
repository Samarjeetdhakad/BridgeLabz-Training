package com.annotations.custom;

public class TaskManager {
    @TaskInfo(priority = 1, assignedTo = "Sunny")
    public void completeTask() {
        System.out.println("Task completed");
    }
}