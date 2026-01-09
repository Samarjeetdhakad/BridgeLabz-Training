package tourmate;

public class Hotel {

    private double costPerDay;
    private int days;

     Hotel(double costPerDay, int days) {
        this.costPerDay = costPerDay;
        this.days = days;
    }

    double getCost() {
        return costPerDay * days;
    }
}
