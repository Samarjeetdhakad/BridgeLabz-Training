package parceltracker;
public class Main {

    public static void main(String[] args) {

        ParcelTracker tracker=new ParcelTracker();
        tracker.addInitialStage("Packed");
        tracker.addStage("Shipped");
        tracker.addStage("In Transit");
        tracker.addStage("Delivered");

        tracker.addCheckpointAfter("In Transit", "Reached City Hub");

        tracker.track();
    }
}