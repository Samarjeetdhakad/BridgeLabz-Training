package hospitalmanagementsystem;

public class InPatient extends Patient {

    int daysAdmitted;

    InPatient(String name, int age, int daysAdmitted) {
        super(name, age);
        this.daysAdmitted = daysAdmitted;
        this.patientType="InPatient";
    }

    @Override
    void displayInfo() {
        System.out.println(getSummary()+", Days Admitted:" + daysAdmitted);
    }
}