package campusconnect;

class Student extends Person implements ICourseActions {

    private int[] grades;  
    private Course course;

    public Student(int id, String name, String email, int[] grades) {
        super(id, name, email);
        this.grades = grades;
    }

    public double calculateGPA() {
        int sum = 0;
        for (int g : grades) {
            sum += g;       
        }
        return (double) sum / grades.length; 
    }

    @Override
    public void enrollCourse(Course course) {
        this.course = course;
        course.addStudent(this);
    }

    @Override
    public void dropCourse(Course course) {
        course.removeStudent(this);
        this.course = null;
    }

    @Override
    void printDetails() {
        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("GPA: " + calculateGPA());
    }
}
