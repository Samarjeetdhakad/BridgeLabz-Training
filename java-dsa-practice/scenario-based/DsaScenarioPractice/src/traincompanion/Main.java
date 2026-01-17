package traincompanion;

public class Main {
    public static void main(String[] args) {
        TrainCompartment t=new TrainCompartment();

        t.addCompartment("Engine");
        t.addCompartment("Pantry");
        t.addCompartment("Sleeper 1");
        t.addCompartment("Sleeper 2");
        t.addCompartment("Sleeper 3");
        t.addCompartment("AC 1");
        t.addCompartment("AC 2");

        t.moveForward();
        t.moveBackward();

        t.remove("Sleeper 3");

        t.showAdjacent("AC 1");
  }
}