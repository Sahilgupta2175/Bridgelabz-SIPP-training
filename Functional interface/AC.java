public class AC implements SmartDeviceControl {
    @Override
    public void turnOn() {
        System.out.println("AC turned on");
    }

    @Override
    public void turnOff() {
        System.out.println("AC turned off");
    }
}
