package homenest;

class Light extends Device implements IControllable {

     Light(String deviceId) {
        super(deviceId);
    }

    @Override
    public void turnOn() {
        setStatus(true);
        System.out.println("Light is ON 💡");
    }

    @Override
    public void turnOff() {
        setStatus(false);
        System.out.println("Light is OFF");
    }

    @Override
    public void reset() {
        System.out.println("Light reset to default brightness.");
    }
}
