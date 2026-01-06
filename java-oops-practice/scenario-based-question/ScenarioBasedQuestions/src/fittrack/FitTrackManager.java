package fittrack;

import java.util.ArrayList;

class FitTrackManager {

    private ArrayList<Workout> workoutLogs = new ArrayList<>(); 

    public void logWorkout(Workout workout, UserProfile user) {
        workout.startWorkout();
        workout.calculateCalories(user.getWeight());
        workout.stopWorkout();

        workoutLogs.add(workout);
    }

    public double calculateProgress(double dailyTarget) {
        double totalBurned = 0;
        for (Workout w : workoutLogs) {
            totalBurned += w.getCaloriesBurned();
        }
        return dailyTarget - totalBurned; 
    }
}
