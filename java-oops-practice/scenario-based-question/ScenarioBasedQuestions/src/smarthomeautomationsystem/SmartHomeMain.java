package smarthomeautomationsystem;

public class SmartHomeMain {

    public static void main(String[] args) {

        Appliance light = new Light();
        Appliance fan = new Fan(75);
        Appliance ac= new AC(1500);

        UserController controller = new UserController();
        controller.controlDevice(light,true);
        controller.controlDevice(fan,true);
        controller.controlDevice(ac,true);

        controller.controlDevice(fan,false);
        controller.compareEnergy(light,ac);
    }
}
