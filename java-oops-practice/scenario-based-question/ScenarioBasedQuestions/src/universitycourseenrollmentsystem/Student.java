package universitycourseenrollmentsystem;


public class Student {

    private String name;
    private int id;
    private double gpa;

    Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.gpa = 0.0;
    }


    Student(String name, int id, String elective) {
        this(name, id);
        System.out.println("Elective chosen: " + elective);
    }

    protected void setGpa(double gpa) {
        this.gpa = gpa;
    }

    void assignGrade(String grade) {

    }

    public String getTranscript() {
        return "Name: " + name + ", ID: " + id + ", GPA: " + gpa;
    }
}