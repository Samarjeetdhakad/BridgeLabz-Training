package homenest;

class Thermostat extends Device implements IControllable {
    private int temperature;

    Thermostat(String deviceId) {
        super(deviceId);
        this.temperature = 24; // default temp
    }

    @Override
    public void turnOn() {
        setStatus(true);
        System.out.println("Thermostat ON at " + temperature + "°C");
    }

    @Override
    public void turnOff() {
        setStatus(false);
        System.out.println("Thermostat OFF");
    }

    @Override
    public void reset() {
        temperature = 24;
        System.out.println("Thermostat reset to 24°C");
    }
}
