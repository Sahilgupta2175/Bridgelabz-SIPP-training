class Vehicle {
    protected int maxSpeed;
    protected String fuelType;
    protected String brand;
    protected String model;

    public Vehicle(String brand, String model, int maxSpeed, String fuelType) {
        this.brand = brand;
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    public void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
        System.out.println("Fuel Type: " + fuelType);
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double calculateFuelEfficiency() {
        return 15.0;
    }
}

class Car extends Vehicle {
    private int seatCapacity;
    private String bodyType;
    private boolean isConvertible;

    public Car(String brand, String model, int maxSpeed, String fuelType,
            int seatCapacity, String bodyType, boolean isConvertible) {
        super(brand, model, maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
        this.bodyType = bodyType;
        this.isConvertible = isConvertible;
    }

    @Override
    public void displayInfo() {
        System.out.println("=== CAR DETAILS ===");
        super.displayInfo();
        System.out.println("Seat Capacity: " + seatCapacity + " passengers");
        System.out.println("Body Type: " + bodyType);
        System.out.println("Convertible: " + (isConvertible ? "Yes" : "No"));
        System.out.println("Vehicle Type: Car");
    }

    @Override
    public double calculateFuelEfficiency() {
        if (bodyType.equals("Sedan")) {
            return 18.0;
        } else if (bodyType.equals("SUV")) {
            return 12.0;
        } else {
            return 16.0;
        }
    }

    public void startAirConditioning() {
        System.out
                .println(brand + " " + model + " air conditioning is now running for " + seatCapacity + " passengers.");
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public String getBodyType() {
        return bodyType;
    }

    public boolean isConvertible() {
        return isConvertible;
    }
}

class Truck extends Vehicle {
    private double loadCapacity;
    private int numberOfAxles;
    private String truckType;

    public Truck(String brand, String model, int maxSpeed, String fuelType,
            double loadCapacity, int numberOfAxles, String truckType) {
        super(brand, model, maxSpeed, fuelType);
        this.loadCapacity = loadCapacity;
        this.numberOfAxles = numberOfAxles;
        this.truckType = truckType;
    }

    @Override
    public void displayInfo() {
        System.out.println("=== TRUCK DETAILS ===");
        super.displayInfo();
        System.out.println("Load Capacity: " + loadCapacity + " tons");
        System.out.println("Number of Axles: " + numberOfAxles);
        System.out.println("Truck Type: " + truckType);
        System.out.println("Vehicle Type: Truck");
    }

    @Override
    public double calculateFuelEfficiency() {
        if (truckType.equals("Light Truck")) {
            return 10.0;
        } else if (truckType.equals("Heavy Truck")) {
            return 6.0;
        } else {
            return 8.0;
        }
    }

    public void loadCargo() {
        System.out.println(brand + " " + model + " is loading cargo. Maximum capacity: " + loadCapacity + " tons.");
    }

    public boolean canCarryWeight(double weight) {
        return weight <= loadCapacity;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public int getNumberOfAxles() {
        return numberOfAxles;
    }

    public String getTruckType() {
        return truckType;
    }
}

class Motorcycle extends Vehicle {
    private String motorcycleType;
    private int engineCapacity;
    private boolean hasSidecar;

    public Motorcycle(String brand, String model, int maxSpeed, String fuelType,
            String motorcycleType, int engineCapacity, boolean hasSidecar) {
        super(brand, model, maxSpeed, fuelType);
        this.motorcycleType = motorcycleType;
        this.engineCapacity = engineCapacity;
        this.hasSidecar = hasSidecar;
    }

    @Override
    public void displayInfo() {
        System.out.println("=== MOTORCYCLE DETAILS ===");
        super.displayInfo();
        System.out.println("Motorcycle Type: " + motorcycleType);
        System.out.println("Engine Capacity: " + engineCapacity + " cc");
        System.out.println("Has Sidecar: " + (hasSidecar ? "Yes" : "No"));
        System.out.println("Vehicle Type: Motorcycle");
    }

    @Override
    public double calculateFuelEfficiency() {
        if (engineCapacity <= 150) {
            return 45.0;
        } else if (engineCapacity <= 500) {
            return 35.0;
        } else {
            return 25.0;
        }
    }

    public void performWheeling() {
        if (motorcycleType.equals("Sport")) {
            System.out.println(brand + " " + model + " is performing a wheelie! (Sport bike maneuver)");
        } else {
            System.out.println(brand + " " + model + " is cruising smoothly.");
        }
    }

    public String getMotorcycleType() {
        return motorcycleType;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public boolean hasSidecar() {
        return hasSidecar;
    }
}

public class VehicleTransportSystem {
    public static void main(String[] args) {
        System.out.println("=== Vehicle and Transport System ===\n");

        Car car = new Car("Toyota", "Camry", 200, "Petrol", 5, "Sedan", false);
        Truck truck = new Truck("Volvo", "FH16", 120, "Diesel", 25.0, 4, "Heavy Truck");
        Motorcycle motorcycle = new Motorcycle("Yamaha", "R1", 300, "Petrol", "Sport", 998, false);

        Vehicle[] vehicles = { car, truck, motorcycle };

        System.out.println("1. Polymorphic behavior with displayInfo():");
        for (Vehicle vehicle : vehicles) {
            vehicle.displayInfo();
            System.out.println("Fuel Efficiency: " + vehicle.calculateFuelEfficiency() + " km/l");
            System.out.println();
        }

        System.out.println("2. Unique Vehicle Behaviors:");
        car.startAirConditioning();
        truck.loadCargo();
        motorcycle.performWheeling();

        System.out.println("\n3. Vehicle Performance Analysis:");

        Vehicle fastestVehicle = vehicles[0];
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getMaxSpeed() > fastestVehicle.getMaxSpeed()) {
                fastestVehicle = vehicle;
            }
        }
        System.out.println("Fastest Vehicle: " + fastestVehicle.getBrand() + " " +
                fastestVehicle.getModel() + " (" + fastestVehicle.getMaxSpeed() + " km/h)");

        Vehicle mostEfficientVehicle = vehicles[0];
        for (Vehicle vehicle : vehicles) {
            if (vehicle.calculateFuelEfficiency() > mostEfficientVehicle.calculateFuelEfficiency()) {
                mostEfficientVehicle = vehicle;
            }
        }
        System.out.println("Most Fuel Efficient: " + mostEfficientVehicle.getBrand() + " " +
                mostEfficientVehicle.getModel() + " (" + mostEfficientVehicle.calculateFuelEfficiency() + " km/l)");

        System.out.println("\n4. Type-specific Operations:");
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Car) {
                Car carInstance = (Car) vehicle;
                System.out.println("Car " + carInstance.getBrand() + " can seat " +
                        carInstance.getSeatCapacity() + " passengers");
            } else if (vehicle instanceof Truck) {
                Truck truckInstance = (Truck) vehicle;
                System.out.println("Truck " + truckInstance.getBrand() + " can carry " +
                        truckInstance.getLoadCapacity() + " tons");
                System.out.println("Can carry 20 tons? " + truckInstance.canCarryWeight(20.0));
            } else if (vehicle instanceof Motorcycle) {
                Motorcycle motoInstance = (Motorcycle) vehicle;
                System.out.println("Motorcycle " + motoInstance.getBrand() + " has " +
                        motoInstance.getEngineCapacity() + " cc engine");
            }
        }

        System.out.println("\n=== End of Vehicle Transport Demo ===");
    }
}
