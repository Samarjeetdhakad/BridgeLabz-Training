package tourmate;

public class InternationalTrip extends Trip {

    InternationalTrip(String destination, int duration,Transport transport, Hotel hotel, Activity activity) {
        super(destination, duration, transport, hotel, activity);
    }

    @Override
    public void book() {
        System.out.println("International trip booked to " + destination);
        System.out.println("Passport and visa required.");
    }

    @Override
    public void cancel() {
        System.out.println("International trip cancelled with refund rules.");
    }
}
