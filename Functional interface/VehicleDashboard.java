public interface VehicleDashboard {
    void displaySpeed();

    default void displayBatteryPercentage() {
        // Default: Not supported
    }
}
