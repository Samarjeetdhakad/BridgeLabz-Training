package universitycourseenrollmentsystem;

public class Enrollment {

    Student student;
    Course course;

    Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    void showEnrollment() {
        System.out.println(student.getTranscript());
        System.out.println("Course: " + course.courseName);
    }
}