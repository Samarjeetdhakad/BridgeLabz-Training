package fittrack;

public class FitTrackApp {
    public static void main(String[] args) {

        UserProfile user = new UserProfile(
                "Samarjeet", 22, 70, "Weight Loss"
        );

        Workout cardio = new CardioWorkout(30);
        Workout strength = new StrengthWorkout(40);

        FitTrackManager manager = new FitTrackManager();

        manager.logWorkout(cardio, user);
        manager.logWorkout(strength, user);

        double remainingCalories =
                manager.calculateProgress(500);

        System.out.println("Remaining calories to burn: " + remainingCalories);
    }
}
