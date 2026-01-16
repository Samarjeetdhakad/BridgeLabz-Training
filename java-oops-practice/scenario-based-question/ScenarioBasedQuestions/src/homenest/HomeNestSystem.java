package homenest;

public class HomeNestSystem {
    public static void main(String[] args) {

        IControllable device1 = new Light("L101");
        IControllable device2 = new Camera("C202");
        IControllable device3 = new Thermostat("T303");
        IControllable device4 = new Lock("L404");

        device1.reset();
        device2.reset();
        device3.reset();
        device4.reset();
    }
}
