package homenest;

abstract class Device {
    private String deviceId;      
    private boolean status;      
    protected double energyUsage; 

    
     Device(String deviceId) {
        this.deviceId = deviceId;
        this.status = false; // default off
        this.energyUsage = 0.0;
        System.out.println("Device registered: " + deviceId);
    }

    public String getDeviceId() {
        return deviceId;
    }

    public boolean getStatus() {
        return status;
    }

    protected void setStatus(boolean status) { // protected → controlled access
        this.status = status;
    }

    // Operator-like method for energy calculation
    public double calculateEnergy(double hours, double powerRating) {
        energyUsage = hours * powerRating;
        return energyUsage;
    }

    // Secure firmware log (access modifier use)
    private void updateFirmwareLog() {
        System.out.println("Firmware updated for device: " + deviceId);
    }
}

