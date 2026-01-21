package com.generics.coursemanagement;
import java.util.List;

class CourseManager {

    public static void printCourses(List<? extends CourseType> courses) {

        for (CourseType course : courses) {
            System.out.println(course.getEvaluationMethod());
        }
    }
}
