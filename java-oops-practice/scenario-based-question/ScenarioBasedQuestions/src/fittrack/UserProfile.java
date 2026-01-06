package fittrack;

class UserProfile {

    private String name;
    private int age;
    private double weight;   
    private String goal;

   
    public UserProfile(String name, int age, double weight) {
        this(name, age, weight, "Maintain Fitness");
    }

    
    public UserProfile(String name, int age, double weight, String goal) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.goal = goal;
    }

    
    public double getWeight() {
        return weight;
    }

    public String getGoal() {
        return goal;
    }
}
