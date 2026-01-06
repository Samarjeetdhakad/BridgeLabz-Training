package edumentor;

class Learner extends User implements ICertifiable {

    private String courseType; 

    public Learner(int userId, String name, String email, String courseType) {
        super(userId, name, email);
        this.courseType = courseType;
    }

    @Override
    public void generateCertificate() {
        if (courseType.equalsIgnoreCase("Short")) {
            System.out.println("Generating Short Course Certificate for " + name);
        } else {
            System.out.println("Generating Full-Time Program Certificate for"+name);
        }
    }

    @Override
    void printProfile() {
        System.out.println("Learner: " + name + " | Course Type: " + courseType);
    }
}
