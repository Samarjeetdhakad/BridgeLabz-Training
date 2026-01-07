package eventease;

public class BirthdayEvent extends Event {

    BirthdayEvent(String eventName, String location, String date,int attendees, double venueCost, User organizer) {
        super(eventName, location, date, attendees, venueCost, organizer);
    }

    @Override
    public void schedule() {
        System.out.println("Birthday event scheduled with fun decorations ");
    }

    @Override
    public void reschedule(String newDate) {
        System.out.println("Birthday event rescheduled to " + newDate);
    }

    @Override
    public void cancel() {
        System.out.println("Birthday event cancelled");
    }
}
