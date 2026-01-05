package universitycourseenrollmentsystem;

public class Undergraduate extends Student {

    Undergraduate(String name, int id) {
        super(name, id);
    }
    
    @Override
    void assignGrade(String grade) {
        if (grade.equalsIgnoreCase("A")) setGpa(4.0);
        else if (grade.equalsIgnoreCase("B")) setGpa(3.0);
        else if (grade.equalsIgnoreCase("C")) setGpa(2.0);
        else setGpa(0.0);
    }
}