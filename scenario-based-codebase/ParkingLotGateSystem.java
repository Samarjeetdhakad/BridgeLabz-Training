import java.util.Scanner;

public class ParkingLotGateSystem {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int totalSlots=5;   
        int occupiedSlots=0;
        int choice;

        while (true) {
            System.out.println("1. Park Vehicle");
            System.out.println("2. Exit Vehicle");
            System.out.println("3. Show Occupancy");
            System.out.println("4. Exit System");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1: 
                    if (occupiedSlots < totalSlots) {
                        occupiedSlots++;
                        System.out.println("Vehicle parked successfully ");
                    } else {
                        System.out.println("Parking lot is full ");
                        return;
                    }
                    break;

                case 2: 
                    if (occupiedSlots > 0) {
                        occupiedSlots--;
                        System.out.println("Vehicle exited successfully ");
                    } else {
                        System.out.println("Parking Lot is empty");
                    }
                    break;

                case 3: 
                    System.out.println("Occupied Slots:"+occupiedSlots);
                    System.out.println("Available Slots:"+(totalSlots-occupiedSlots));
                    break;

                case 4: 
                    System.out.println("Exiting Parking System");
                    return;

                default:
                    System.out.println("Invalid choice Please try again.");
            }
        }
    }
}
