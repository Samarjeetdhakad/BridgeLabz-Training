package smarthomeautomationsystem;

public class Light extends Appliance {

    Light() {
        super(40);
    }

    @Override
    void turnOn() {
        super.turnOn();
        System.out.println("Light ON (Soft glow)");
    }

    @Override
    void turnOff() {
        super.turnOff();
        System.out.println("Light OFF");
    }
}