package com.annotations.custom;
import java.lang.reflect.Method;

public class ReadTaskInfo {

    public static void main(String[] args) {

        try {
            Class<TaskManager> cls = TaskManager.class;

            Method method = cls.getMethod("completeTask");

            if (method.isAnnotationPresent(TaskInfo.class)) {

                TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);

                System.out.println("Priority   : " + taskInfo.priority());
                System.out.println("Assigned To: " + taskInfo.assignedTo());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}