import java.util.ArrayList;
import java.util.List;

class Vehicle {
    private String vehicleNumber;
    private int capacity;
    private String type;

    public Vehicle(String vehicleNumber, int capacity, String type) {
        this.vehicleNumber = vehicleNumber;
        this.capacity = capacity;
        this.type = type;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getType() {
        return type;
    }

    public double getRatePerKm() {
        return 0.0;
    }
}

class Mini extends Vehicle {
    public Mini(String vehicleNumber) {
        super(vehicleNumber, 4, "Mini");
    }

    @Override
    public double getRatePerKm() {
        return 10.0;
    }
}

class Sedan extends Vehicle {
    public Sedan(String vehicleNumber) {
        super(vehicleNumber, 4, "Sedan");
    }

    @Override
    public double getRatePerKm() {
        return 15.0;
    }
}

class SUV extends Vehicle {
    public SUV(String vehicleNumber) {
        super(vehicleNumber, 6, "SUV");
    }

    @Override
    public double getRatePerKm() {
        return 20.0;
    }
}

class Driver {
    private String name;
    private String licenseNumber;
    private double rating;
    private Vehicle vehicle;
    private boolean available;

    public Driver(String name, String licenseNumber, Vehicle vehicle) {
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.vehicle = vehicle;
        this.rating = 5.0;
        this.available = true;
    }

    public String getName() {
        return name;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    protected void updateRating(double newRating) {
        this.rating = (this.rating + newRating) / 2;
    }

    public double getRating() {
        return rating;
    }
}

interface IRideService {
    Ride bookRide(String pickupLocation, String dropLocation, String vehicleType);

    void endRide(Ride ride, double rating);

    double calculateFare(Ride ride);
}

class Ride {
    private String rideId;
    private Driver driver;
    private String pickupLocation;
    private String dropLocation;
    private double distance;
    private double fare;
    private boolean completed;

    public Ride(String rideId, Driver driver, String pickupLocation, String dropLocation) {
        this.rideId = rideId;
        this.driver = driver;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.completed = false;
        this.distance = 1 + Math.random() * 19;
    }

    public String getRideId() {
        return rideId;
    }

    public Driver getDriver() {
        return driver;
    }

    public double getDistance() {
        return distance;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public double getFare() {
        return fare;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}

class RideService implements IRideService {
    private List<Driver> drivers;
    private int rideCounter;

    public RideService() {
        this.drivers = new ArrayList<>();
        this.rideCounter = 0;
    }

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    @Override
    public Ride bookRide(String pickupLocation, String dropLocation, String vehicleType) {
        for (Driver driver : drivers) {
            if (driver.isAvailable() && driver.getVehicle().getType().equalsIgnoreCase(vehicleType)) {
                driver.setAvailable(false);
                Ride ride = new Ride("RIDE" + (++rideCounter), driver, pickupLocation, dropLocation);
                double fare = calculateFare(ride);
                ride.setFare(fare);
                return ride;
            }
        }
        return null;
    }

    @Override
    public void endRide(Ride ride, double rating) {
        if (ride != null) {
            ride.setCompleted(true);
            ride.getDriver().setAvailable(true);
            ride.getDriver().updateRating(rating);
        }
    }

    @Override
    public double calculateFare(Ride ride) {
        Vehicle vehicle = ride.getDriver().getVehicle();
        double baseFare = 50.0;
        double ratePerKm = vehicle.getRatePerKm();

        return baseFare + (ride.getDistance() * ratePerKm);
    }
}

public class CabGo {
    public static void main(String[] args) {
        Vehicle mini = new Mini("KA01AB1234");
        Vehicle sedan = new Sedan("KA01CD5678");
        Vehicle suv = new SUV("KA01EF9012");

        Driver driver1 = new Driver("John", "DL123456", mini);
        Driver driver2 = new Driver("Alice", "DL789012", sedan);
        Driver driver3 = new Driver("Bob", "DL345678", suv);

        RideService rideService = new RideService();
        rideService.addDriver(driver1);
        rideService.addDriver(driver2);
        rideService.addDriver(driver3);

        Ride ride1 = rideService.bookRide("MG Road", "Electronic City", "Mini");
        if (ride1 != null) {
            System.out.println("Ride booked with " + ride1.getDriver().getName() +
                    " driving a " + ride1.getDriver().getVehicle().getType());
            System.out.println("Distance: " + String.format("%.2f", ride1.getDistance()) + " km");
            System.out.println("Estimated fare: ₹" + String.format("%.2f", ride1.getFare()));

            rideService.endRide(ride1, 4.5);
            System.out.println("Ride completed. Driver's new rating: " +
                    String.format("%.1f", ride1.getDriver().getRating()));
        } else {
            System.out.println("No Mini available at the moment.");
        }

        Ride ride2 = rideService.bookRide("Airport", "Whitefield", "SUV");
        if (ride2 != null) {
            System.out.println("\nRide booked with " + ride2.getDriver().getName() +
                    " driving a " + ride2.getDriver().getVehicle().getType());
            System.out.println("Distance: " + String.format("%.2f", ride2.getDistance()) + " km");
            System.out.println("Estimated fare: ₹" + String.format("%.2f", ride2.getFare()));

            rideService.endRide(ride2, 5.0);
            System.out.println("Ride completed. Driver's new rating: " +
                    String.format("%.1f", ride2.getDriver().getRating()));
        } else {
            System.out.println("\nNo SUV available at the moment.");
        }
    }
}
