package com.generics.coursemanagement;
class Course<T extends CourseType> {

    private String courseName;
    private String department;
    private T courseType;

    public Course(String courseName, String department, T courseType) {
        this.courseName = courseName;
        this.department = department;
        this.courseType = courseType;
    }

    public String getDetails() {
        return courseName + " | Dept: " + department +
               " | Evaluation: " + courseType.getEvaluationMethod();
    }
}
