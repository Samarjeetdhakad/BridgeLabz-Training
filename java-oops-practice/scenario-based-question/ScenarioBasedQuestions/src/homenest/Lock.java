package homenest;

class Lock extends Device implements IControllable {

     Lock(String deviceId) {
        super(deviceId);
    }

    @Override
    public void turnOn() {
        setStatus(true);
        System.out.println("Lock ENGAGED 🔒");
    }

    @Override
    public void turnOff() {
        setStatus(false);
        System.out.println("Lock DISENGAGED 🔓");
    }

    @Override
    public void reset() {
        System.out.println("Lock password reset to default.");
    }
}

