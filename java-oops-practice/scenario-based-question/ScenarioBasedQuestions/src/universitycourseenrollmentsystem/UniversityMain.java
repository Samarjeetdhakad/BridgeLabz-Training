package universitycourseenrollmentsystem;

public class UniversityMain {

    public static void main(String[] args) {

        Course java=new Course("Java Programming");

        Student s1=new Undergraduate("Rohan", 101);
        Student s2=new Postgraduate("Anita", 201);

        Faculty faculty = new Faculty("Dr. Sharma");

        faculty.gradeStudent(s1, "A");
        faculty.gradeStudent(s2, "Pass");

        Enrollment e1=new Enrollment(s1, java);
        Enrollment e2=new Enrollment(s2, java);

        e1.showEnrollment();
        e2.showEnrollment();
    }
}