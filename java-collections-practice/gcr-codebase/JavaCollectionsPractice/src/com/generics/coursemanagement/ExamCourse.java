package com.generics.coursemanagement;
class ExamCourse extends CourseType {

    @Override
    String getEvaluationMethod() {
        return "Written Exam";
    }
}

class AssignmentCourse extends CourseType {

    @Override
    String getEvaluationMethod() {
        return "Assignments + Viva";
    }
}

class ResearchCourse extends CourseType {

    @Override
    String getEvaluationMethod() {
        return "Research Paper + Presentation";
    }
}
