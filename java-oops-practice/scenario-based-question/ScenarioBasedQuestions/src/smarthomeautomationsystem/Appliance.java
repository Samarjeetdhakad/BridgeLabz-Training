package smarthomeautomationsystem;

public class Appliance {

    private boolean isOn;    
    protected int powerConsumption; 

    Appliance(int powerConsumption) {
        this.powerConsumption = powerConsumption;
        this.isOn = false;
    }

    void turnOn() {
        isOn = true;
        System.out.println("Appliance turned ON");
    }

    void turnOff() {
        isOn = false;
        System.out.println("Appliance turned OFF");
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    protected boolean isOn() {
        return isOn;
    }
}