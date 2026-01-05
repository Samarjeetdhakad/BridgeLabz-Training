package smarthomeautomationsystem;

public class AC extends Appliance {

    AC(int powerConsumption) {
        super(powerConsumption);
    }

    @Override
    void turnOn() {
        super.turnOn();
        System.out.println("AC ON (Cooling started)");
    }

    @Override
    void turnOff() {
        super.turnOff();
        System.out.println("AC OFF");
    }
}