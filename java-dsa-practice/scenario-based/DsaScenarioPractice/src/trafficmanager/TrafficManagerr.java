package trafficmanager;

public class TrafficManagerr {

    public static void main(String[] args) {

        RoundAbout roundabout = new RoundAbout(3);
        WaitingQueue waitingQueue = new WaitingQueue(5);

        // Vehicles arriving
        waitingQueue.enqueue("Car-A");
        waitingQueue.enqueue("Car-B");
        waitingQueue.enqueue("Car-C");
        waitingQueue.enqueue("Car-D");
       
        enterRoundabout(roundabout,waitingQueue);
        enterRoundabout(roundabout,waitingQueue);
        enterRoundabout(roundabout,waitingQueue);

        roundabout.printState();

        // Exit
        roundabout.removeVehicle();
        roundabout.printState();

        // New entry
        enterRoundabout(roundabout, waitingQueue);
        roundabout.printState();
    }

    private static void enterRoundabout(RoundAbout roundabout, WaitingQueue queue) {
        if (!roundabout.hasSpace()) {
            System.out.println("Roundabout full");
            return;
        }

        String car = queue.dequeue();
        if (car != null) {
            roundabout.addVehicle(car);
        }
    }
}