package com.annotations.repeatable;

import java.lang.reflect.Method;

public class ReadBugReports {
    public static void main(String[] args) {
        try {
            Method method =
                    TaskServicee.class.getMethod("processTask");
            BugReport[] bugReports =
                    method.getAnnotationsByType(BugReport.class);

            for (BugReport bug : bugReports) {
                System.out.println("Bug: " + bug.description());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}