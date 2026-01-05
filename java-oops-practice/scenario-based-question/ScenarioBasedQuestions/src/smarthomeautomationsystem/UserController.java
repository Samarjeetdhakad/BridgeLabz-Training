package smarthomeautomationsystem;

public class UserController {

    void controlDevice(Appliance device, boolean power) {
        if (power) {
            device.turnOn();
        } else {
            device.turnOff();
        }
    }

    void compareEnergy(Appliance a1, Appliance a2) {
        if (a1.getPowerConsumption() > a2.getPowerConsumption()) {
            System.out.println("First appliance consumes more energy");
        } else if (a1.getPowerConsumption() < a2.getPowerConsumption()) {
            System.out.println("Second appliance consumes more energy");
        } else {
            System.out.println("Both appliances consume equal energy");
        }
    }
}