package campusconnect;

import java.util.ArrayList;

class Course{

    private String courseName;
    private Faculty faculty;
    private ArrayList<Student> students;

    public Course(String courseName, Faculty faculty) {
        this.courseName = courseName;
        this.faculty = faculty;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public void removeStudent(Student s) {
        students.remove(s);
    }

    public void showCourseDetails() {
        System.out.println("\nCourse:" + courseName);
        faculty.printDetails();
        System.out.println("Enrolled Students:" + students.size());
    }
}
