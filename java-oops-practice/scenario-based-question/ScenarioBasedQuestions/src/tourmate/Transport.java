package tourmate;

public class Transport {

    private double cost;

    Transport(double cost) {
        this.cost = cost;
    }

    double getCost() {        // package-private (hidden from outside)
        return cost;
    }
}
