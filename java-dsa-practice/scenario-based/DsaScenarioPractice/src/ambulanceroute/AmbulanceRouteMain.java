package ambulanceroute;

public class AmbulanceRouteMain {
    public static void main(String[] args) {

        AmbulanceRoute route = new AmbulanceRoute();

        route.addUnit("Emergency", false);
        route.addUnit("Radiology", false);
        route.addUnit("Surgery", true);
        route.addUnit("ICU", false);

        System.out.println("Hospital Route");
        route.displayRoute();

        System.out.println("\nAmbulance arriving");
        route.findNearestAvailableUnit();

        System.out.println("\nICU is under maintenance:");
        route.removeUnit("ICU");

        System.out.println("Updated Route:");
        route.displayRoute();
    }
}
