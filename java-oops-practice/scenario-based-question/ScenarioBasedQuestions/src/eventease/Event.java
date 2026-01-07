package eventease;

public abstract class Event implements ISchedulable {

    private static int idCounter = 1000;

    private final int eventId;          
    private String eventName;
    private String location;
    private String date;
    private int attendees;

    
    private double venueCost;
    private double serviceCost;
    private double discount;

    protected User organizer;

    
    public Event(String eventName, String location, String date, int attendees, double venueCost, User organizer) {
        this.eventId= ++idCounter;
        this.eventName= eventName;
        this.location =location;
        this.date=date;
        this.attendees= attendees;
        this.venueCost=venueCost;
        this.organizer=organizer;
    }

    
    public Event(String eventName, String location, String date, int attendees,double venueCost, double serviceCost, double discount, User organizer) {
        this(eventName, location, date, attendees, venueCost, organizer);
        this.serviceCost = serviceCost;
        this.discount = discount;
    }

    
    public double calculateTotalCost() {
        return venueCost + serviceCost - discount;
    }

    public int getEventId() {
        return eventId;
    }

    public void showDetails() {
        System.out.println("Event ID: " + eventId);
        System.out.println("Event: " + eventName);
        System.out.println("Location: " + location);
        System.out.println("Date: " + date);
        System.out.println("Attendees: " + attendees);
        System.out.println("Organizer: " + organizer.getName());
        System.out.println("Total Cost: ₹" + calculateTotalCost());
        System.out.println();
    }
}
