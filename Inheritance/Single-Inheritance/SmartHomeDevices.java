class Device {
    protected String deviceId;
    protected String status;
    protected String deviceName;
    protected String location;
    protected boolean isOnline;

    public Device(String deviceId, String deviceName, String location, String status, boolean isOnline) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.location = location;
        this.status = status;
        this.isOnline = isOnline;
    }

    public void displayStatus() {
        System.out.println("=== DEVICE STATUS ===");
        System.out.println("Device ID: " + deviceId);
        System.out.println("Device Name: " + deviceName);
        System.out.println("Location: " + location);
        System.out.println("Status: " + status);
        System.out.println("Online: " + (isOnline ? "Yes" : "No"));
    }

    public void togglePower() {
        if (status.equals("OFF")) {
            status = "ON";
            isOnline = true;
            System.out.println(deviceName + " has been turned ON");
        } else {
            status = "OFF";
            isOnline = false;
            System.out.println(deviceName + " has been turned OFF");
        }
    }

    public void checkConnectivity() {
        if (isOnline) {
            System.out.println(deviceName + " is connected to the smart home network");
        } else {
            System.out.println(deviceName + " is offline - please check connection");
        }
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getStatus() {
        return status;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getLocation() {
        return location;
    }

    public boolean isOnline() {
        return isOnline;
    }
}

class Thermostat extends Device {
    private double temperatureSetting;
    private double currentTemperature;
    private String mode;
    private boolean scheduleEnabled;

    public Thermostat(String deviceId, String deviceName, String location, String status,
            boolean isOnline, double temperatureSetting, double currentTemperature,
            String mode, boolean scheduleEnabled) {
        super(deviceId, deviceName, location, status, isOnline);
        this.temperatureSetting = temperatureSetting;
        this.currentTemperature = currentTemperature;
        this.mode = mode;
        this.scheduleEnabled = scheduleEnabled;
    }

    @Override
    public void displayStatus() {
        super.displayStatus();
        System.out.println("=== THERMOSTAT SETTINGS ===");
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
        System.out.println("Current Temperature: " + currentTemperature + "°C");
        System.out.println("Mode: " + mode);
        System.out.println("Schedule Enabled: " + (scheduleEnabled ? "Yes" : "No"));
        System.out.println("Temperature Difference: " + Math.abs(temperatureSetting - currentTemperature) + "°C");

        if (Math.abs(temperatureSetting - currentTemperature) > 1.0) {
            if (currentTemperature < temperatureSetting) {
                System.out.println("Action: Heating required");
            } else {
                System.out.println("Action: Cooling required");
            }
        } else {
            System.out.println("Action: Temperature is optimal");
        }
    }

    public void adjustTemperature(double newTemperature) {
        if (status.equals("ON") && isOnline) {
            this.temperatureSetting = newTemperature;
            System.out.println("Temperature set to " + newTemperature + "°C for " + deviceName);
        } else {
            System.out.println("Cannot adjust temperature - device is offline or turned off");
        }
    }

    public void changeMode(String newMode) {
        if (status.equals("ON") && isOnline) {
            this.mode = newMode;
            System.out.println(deviceName + " mode changed to: " + newMode);
        } else {
            System.out.println("Cannot change mode - device is offline or turned off");
        }
    }

    public void toggleSchedule() {
        if (status.equals("ON") && isOnline) {
            scheduleEnabled = !scheduleEnabled;
            System.out.println("Schedule " + (scheduleEnabled ? "enabled" : "disabled") + " for " + deviceName);
        } else {
            System.out.println("Cannot toggle schedule - device is offline or turned off");
        }
    }

    public void updateCurrentTemperature(double newTemperature) {
        this.currentTemperature = newTemperature;
        System.out.println("Current temperature updated to " + newTemperature + "°C");
    }

    public String getEnergyEfficiency() {
        double difference = Math.abs(temperatureSetting - currentTemperature);
        if (difference <= 1.0) {
            return "Excellent";
        } else if (difference <= 3.0) {
            return "Good";
        } else if (difference <= 5.0) {
            return "Fair";
        } else {
            return "Poor";
        }
    }

    public double getTemperatureSetting() {
        return temperatureSetting;
    }

    public double getCurrentTemperature() {
        return currentTemperature;
    }

    public String getMode() {
        return mode;
    }

    public boolean isScheduleEnabled() {
        return scheduleEnabled;
    }
}

public class SmartHomeDevices {
    public static void main(String[] args) {
        System.out.println("=== Smart Home Devices System ===\n");

        Device device1 = new Device("DEV001", "Smart Light", "Living Room", "ON", true);
        Device device2 = new Device("DEV002", "Security Camera", "Front Door", "ON", true);

        Thermostat thermostat1 = new Thermostat("THERM001", "Main Thermostat", "Living Room",
                "ON", true, 22.0, 20.5, "AUTO", true);

        Thermostat thermostat2 = new Thermostat("THERM002", "Bedroom Thermostat", "Master Bedroom",
                "ON", true, 19.0, 21.0, "COOL", false);

        System.out.println("1. Display Device Status (Superclass):");
        device1.displayStatus();
        device1.checkConnectivity();
        System.out.println();

        device2.displayStatus();
        device2.checkConnectivity();
        System.out.println();

        System.out.println("2. Display Thermostat Status (Single Inheritance - Subclass):");
        thermostat1.displayStatus();
        System.out.println("Energy Efficiency: " + thermostat1.getEnergyEfficiency());
        System.out.println();

        thermostat2.displayStatus();
        System.out.println("Energy Efficiency: " + thermostat2.getEnergyEfficiency());
        System.out.println();

        System.out.println("3. Thermostat-specific Operations:");
        thermostat1.adjustTemperature(24.0);
        thermostat1.changeMode("HEAT");
        thermostat1.toggleSchedule();
        System.out.println();

        thermostat2.adjustTemperature(18.0);
        thermostat2.updateCurrentTemperature(19.5);
        thermostat2.toggleSchedule();
        System.out.println();

        System.out.println("4. Updated Thermostat Status:");
        thermostat1.displayStatus();
        System.out.println("Energy Efficiency: " + thermostat1.getEnergyEfficiency());
        System.out.println();

        System.out.println("5. Device Power Management:");
        device1.togglePower();
        thermostat2.togglePower();
        System.out.println();

        System.out.println("6. Smart Home Summary:");
        System.out.println("Active Devices:");
        if (device1.isOnline()) {
            System.out.println("- " + device1.getDeviceName() + " (" + device1.getLocation() + ")");
        }
        if (device2.isOnline()) {
            System.out.println("- " + device2.getDeviceName() + " (" + device2.getLocation() + ")");
        }
        if (thermostat1.isOnline()) {
            System.out.println("- " + thermostat1.getDeviceName() + " (" + thermostat1.getLocation() +
                    ") - Set to " + thermostat1.getTemperatureSetting() + "°C");
        }
        if (thermostat2.isOnline()) {
            System.out.println("- " + thermostat2.getDeviceName() + " (" + thermostat2.getLocation() +
                    ") - Set to " + thermostat2.getTemperatureSetting() + "°C");
        }

        System.out.println("\n=== End of Smart Home Demo ===");
    }
}
