package fittrack;

class StrengthWorkout extends Workout {

    public StrengthWorkout(int duration) {
        super("Strength", duration);
    }

    @Override
    void calculateCalories(double weight) {
        caloriesBurned = duration * weight * 0.06; 
    }
}
