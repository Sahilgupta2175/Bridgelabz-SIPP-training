abstract class VehicleRide {
    protected String vehicleId;
    protected String driverName;
    protected double ratePerKm;

    public VehicleRide(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public abstract double calculateFare(double distance);

    public String getVehicleDetails() {
        return "Vehicle ID: " + vehicleId + ", Driver: " + driverName + ", Rate: $" + ratePerKm + "/km";
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    private void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public void setRatePerKm(double ratePerKm) {
        this.ratePerKm = ratePerKm;
    }
}

interface GPS {
    String getCurrentLocation();

    void updateLocation(String newLocation);
}

class CarRide extends VehicleRide implements GPS {
    private String currentLocation;

    public CarRide(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = "Starting Point";
    }

    @Override
    public double calculateFare(double distance) {
        return ratePerKm * distance * 1.5;
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

class BikeRide extends VehicleRide implements GPS {
    private String currentLocation;

    public BikeRide(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = "Starting Point";
    }

    @Override
    public double calculateFare(double distance) {
        return ratePerKm * distance * 0.8;
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

class AutoRide extends VehicleRide implements GPS {
    private String currentLocation;

    public AutoRide(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = "Starting Point";
    }

    @Override
    public double calculateFare(double distance) {
        return ratePerKm * distance * 1.2;
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

public class RideHailingApplication {
    public static void processRides(VehicleRide[] vehicles, double distance) {
        for (VehicleRide vehicle : vehicles) {
            System.out.println(vehicle.getVehicleDetails());

            if (vehicle instanceof GPS) {
                GPS gps = (GPS) vehicle;
                System.out.println("Current Location: " + gps.getCurrentLocation());
                gps.updateLocation("Downtown");
                System.out.println("Updated Location: " + gps.getCurrentLocation());
            }

            double fare = vehicle.calculateFare(distance);
            System.out.println("Distance: " + distance + " km");
            System.out.println("Fare: $" + fare);
            System.out.println("------------------------");
        }
    }

    public static void main(String[] args) {
        VehicleRide[] vehicles = {
                new CarRide("CAR001", "John Smith", 2.0),
                new BikeRide("BIKE001", "Mike Johnson", 1.5),
                new AutoRide("AUTO001", "Sarah Wilson", 1.8)
        };

        double tripDistance = 10.5;
        processRides(vehicles, tripDistance);
    }
}
