package com.annotations.repeatable;
public class TaskServicee {

    @BugReport(description = "NullPointerException occurs sometimes")
    @BugReport(description = "Performance issue under heavy load")
    public void processTask() {
        System.out.println("Processing task...");
    }
}