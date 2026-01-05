package hospitalmanagementsystem;

class OutPatient extends Patient {

    String visitDate;

    OutPatient(String name, int age, String visitDate) {
        super(name, age);
        this.visitDate =visitDate;
        this.patientType="OutPatient";
    }

    @Override
    void displayInfo() {
        System.out.println(getSummary()+",Visit Date:" + visitDate);
    }
}
