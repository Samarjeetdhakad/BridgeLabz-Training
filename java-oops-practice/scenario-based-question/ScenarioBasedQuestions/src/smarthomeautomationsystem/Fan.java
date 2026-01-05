package smarthomeautomationsystem;

public class Fan extends Appliance {

    Fan(int powerConsumption) {
        super(powerConsumption);
    }

    @Override
    void turnOn() {
        super.turnOn();
        System.out.println("Fan ON (Air circulating)");
    }

    @Override
    void turnOff() {
        super.turnOff();
        System.out.println("Fan OFF");
    }
}