package com.generics.coursemanagement;
import java.util.ArrayList;
import java.util.List;

public class UniversityApp {

    public static void main(String[] args) {

        Course<ExamCourse> math =
                new Course<>("Mathematics", "Science", new ExamCourse());

        Course<AssignmentCourse> cs =
                new Course<>("Data Structures", "Computer Science", new AssignmentCourse());

        Course<ResearchCourse> ai =
                new Course<>("AI Research", "Computer Science", new ResearchCourse());

        System.out.println(math.getDetails());
        System.out.println(cs.getDetails());
        System.out.println(ai.getDetails());

        List<CourseType> courseTypes = new ArrayList<>();
        courseTypes.add(new ExamCourse());
        courseTypes.add(new AssignmentCourse());
        courseTypes.add(new ResearchCourse());

        CourseManager.printCourses(courseTypes);
    }
}
