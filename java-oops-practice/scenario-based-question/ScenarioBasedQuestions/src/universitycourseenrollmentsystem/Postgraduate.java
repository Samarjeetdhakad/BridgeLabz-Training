package universitycourseenrollmentsystem;

public class Postgraduate extends Student {

    Postgraduate(String name, int id) {
        super(name, id);
    }

    @Override
    void assignGrade(String grade) {
        if (grade.equalsIgnoreCase("Pass")) {
            setGpa(4.0);
        } else {
            setGpa(0.0);
        }
    }
}