package homenest;

class Camera extends Device implements IControllable {

     Camera(String deviceId) {
        super(deviceId);
    }

    @Override
    public void turnOn() {
        setStatus(true);
        System.out.println("Camera activated 🎥");
    }

    @Override
    public void turnOff() {
        setStatus(false);
        System.out.println("Camera deactivated");
    }

    @Override
    public void reset() {
        System.out.println("Camera storage cleared and rebooted.");
    }
}
