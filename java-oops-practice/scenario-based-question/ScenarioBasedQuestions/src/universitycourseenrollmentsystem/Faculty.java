package universitycourseenrollmentsystem;

public class Faculty {

    String name;

    Faculty(String name) {
        this.name = name;
    }

    void gradeStudent(Student student, String grade) {
        student.assignGrade(grade);
    }
}