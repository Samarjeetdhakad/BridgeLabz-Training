package fittrack;

abstract class Workout implements ITrackable {

    protected String type;
    protected int duration;           
    protected double caloriesBurned;

    protected Workout(String type, int duration) {
        this.type = type;
        this.duration = duration;
    }

    abstract void calculateCalories(double weight);

    @Override
    public void startWorkout() {
        System.out.println(type + " workout started");
    }

    @Override
    public void stopWorkout() {
        System.out.println(type + " workout stopped");
    }

    public double getCaloriesBurned() {
        return caloriesBurned;
    }
}
