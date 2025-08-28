public class ElectricVehicleDashboard implements VehicleDashboard {
    @Override
    public void displaySpeed() {
        System.out.println("Speed: 60 km/h");
    }

    @Override
    public void displayBatteryPercentage() {
        System.out.println("Battery: 80%");
    }
}
