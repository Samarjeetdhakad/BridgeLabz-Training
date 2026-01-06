package campusconnect;

public class CampusConnectApp {
    public static void main(String[] args) {

        Faculty faculty = new Faculty(101, "Dr. Sharma", "sharma@uni.edu", "Computer Science");

        Course javaCourse = new Course("Core Java", faculty);

        int[] grades = {80, 85, 90};
        Student student1 = new Student(201, "Amit", "amit@uni.edu", grades);

        
        ICourseActions actions = student1;
        actions.enrollCourse(javaCourse);

        Person p1 = student1;
        Person p2 = faculty;

        p1.printDetails();
        System.out.println();
        p2.printDetails();

        javaCourse.showCourseDetails();
    }
}

