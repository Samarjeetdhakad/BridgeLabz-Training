import java.util.Scanner;

public class BusRouteTracker {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int totalDistance=0;
        int distancePerStop=3; 
        char choice ='n';

        while (choice != 'y' && choice != 'Y') {
            totalDistance += distancePerStop;

            System.out.println("Bus has reached a stop");
            System.out.println("Total distance covered:"+totalDistance + " km");

            System.out.print("Do you want to get off here(y/n): ");
            choice = sc.next().charAt(0);
        }

        System.out.println("Passenger got off after traveling"+totalDistance+" km.");
     
    }
}
