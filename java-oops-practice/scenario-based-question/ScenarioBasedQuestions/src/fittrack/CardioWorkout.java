package fittrack;

class CardioWorkout extends Workout {

    public CardioWorkout(int duration) {
        super("Cardio", duration);
    }

    @Override
    void calculateCalories(double weight) {
        caloriesBurned = duration * weight * 0.08; 
    }
}
