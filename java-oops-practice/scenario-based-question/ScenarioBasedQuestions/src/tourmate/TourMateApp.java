package tourmate;

public class TourMateApp {
    public static void main(String[] args) {

        Transport flight = new Transport(15000);
        Hotel hotel = new Hotel(3000, 5);
        Activity activity = new Activity(5000);

        Trip trip = new InternationalTrip( "Paris", 5, flight, hotel, activity );

        trip.book();
        System.out.println("Total Budget: " + trip.budget);
    }
}
