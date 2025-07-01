interface Refuelable {
    void refuel(double amount);
    double getFuelLevel();
    void displayFuelInfo();
}

class Vehicle {
    protected int maxSpeed;
    protected String model;
    protected String brand;
    protected int year;

    public Vehicle(int maxSpeed, String model, String brand, int year) {
        this.maxSpeed = maxSpeed;
        this.model = model;
        this.brand = brand;
        this.year = year;
    }

    public void displayVehicleInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }

    public void start() {
        System.out.println(brand + " " + model + " is starting");
    }

    public void stop() {
        System.out.println(brand + " " + model + " has stopped");
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }
}

class ElectricVehicle extends Vehicle {
    private double batteryCapacity;
    private double currentCharge;
    private int chargingTime;

    public ElectricVehicle(int maxSpeed, String model, String brand, int year, 
                          double batteryCapacity, double currentCharge, int chargingTime) {
        super(maxSpeed, model, brand, year);
        this.batteryCapacity = batteryCapacity;
        this.currentCharge = currentCharge;
        this.chargingTime = chargingTime;
    }

    @Override
    public void displayVehicleInfo() {
        super.displayVehicleInfo();
        System.out.println("Vehicle Type: Electric");
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
        System.out.println("Current Charge: " + currentCharge + "%");
        System.out.println("Charging Time: " + chargingTime + " hours");
    }

    public void charge(double hours) {
        double chargeAdded = (hours / chargingTime) * 100;
        currentCharge = Math.min(100, currentCharge + chargeAdded);
        System.out.println("Charged for " + hours + " hours. Current charge: " + currentCharge + "%");
    }

    @Override
    public void start() {
        if (currentCharge > 10) {
            System.out.println("Electric " + brand + " " + model + " is starting silently");
        } else {
            System.out.println("Low battery! Please charge before starting");
        }
    }

    public void displayRange() {
        double range = (currentCharge / 100) * 300;
        System.out.println("Estimated range: " + range + " km");
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public double getCurrentCharge() {
        return currentCharge;
    }

    public int getChargingTime() {
        return chargingTime;
    }
}

class PetrolVehicle extends Vehicle implements Refuelable {
    private double fuelCapacity;
    private double currentFuel;
    private double fuelEfficiency;

    public PetrolVehicle(int maxSpeed, String model, String brand, int year, 
                        double fuelCapacity, double currentFuel, double fuelEfficiency) {
        super(maxSpeed, model, brand, year);
        this.fuelCapacity = fuelCapacity;
        this.currentFuel = currentFuel;
        this.fuelEfficiency = fuelEfficiency;
    }

    @Override
    public void displayVehicleInfo() {
        super.displayVehicleInfo();
        System.out.println("Vehicle Type: Petrol");
        System.out.println("Fuel Capacity: " + fuelCapacity + " liters");
        System.out.println("Current Fuel: " + currentFuel + " liters");
        System.out.println("Fuel Efficiency: " + fuelEfficiency + " km/l");
    }

    @Override
    public void refuel(double amount) {
        double newFuelLevel = Math.min(fuelCapacity, currentFuel + amount);
        double actualAmount = newFuelLevel - currentFuel;
        currentFuel = newFuelLevel;
        System.out.println("Refueled " + actualAmount + " liters. Current fuel: " + currentFuel + " liters");
    }

    @Override
    public double getFuelLevel() {
        return currentFuel;
    }

    @Override
    public void displayFuelInfo() {
        System.out.println("Fuel Level: " + currentFuel + "/" + fuelCapacity + " liters");
        System.out.println("Fuel Percentage: " + (currentFuel/fuelCapacity*100) + "%");
    }

    @Override
    public void start() {
        if (currentFuel > 2) {
            System.out.println("Petrol " + brand + " " + model + " engine started");
        } else {
            System.out.println("Low fuel! Please refuel before starting");
        }
    }

    public void displayRange() {
        double range = currentFuel * fuelEfficiency;
        System.out.println("Estimated range: " + range + " km");
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public double getFuelEfficiency() {
        return fuelEfficiency;
    }
}

public class VehicleManagementSystem {
    public static void main(String[] args) {
        System.out.println("=== Vehicle Management System ===\n");

        ElectricVehicle tesla = new ElectricVehicle(250, "Model S", "Tesla", 2023, 100, 75, 8);
        PetrolVehicle honda = new PetrolVehicle(180, "Accord", "Honda", 2022, 65, 45, 15);
        PetrolVehicle bmw = new PetrolVehicle(220, "X5", "BMW", 2023, 80, 20, 12);

        System.out.println("1. Electric Vehicle Information:");
        tesla.displayVehicleInfo();
        tesla.start();
        tesla.displayRange();
        tesla.charge(4);
        tesla.displayRange();
        System.out.println();

        System.out.println("2. Petrol Vehicle Information:");
        honda.displayVehicleInfo();
        honda.displayFuelInfo();
        honda.start();
        honda.displayRange();
        honda.refuel(15);
        honda.displayRange();
        System.out.println();

        System.out.println("3. Another Petrol Vehicle:");
        bmw.displayVehicleInfo();
        bmw.displayFuelInfo();
        bmw.start();
        bmw.refuel(25);
        System.out.println();

        System.out.println("4. Refuelable Interface Demonstration:");
        Refuelable[] refuelableVehicles = {honda, bmw};
        for (Refuelable vehicle : refuelableVehicles) {
            vehicle.displayFuelInfo();
            vehicle.refuel(10);
        }
        System.out.println();

        System.out.println("5. Vehicle Polymorphism:");
        Vehicle[] vehicles = {tesla, honda, bmw};
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.getBrand() + " " + vehicle.getModel() + " - Max Speed: " + vehicle.getMaxSpeed());
            vehicle.start();
            vehicle.stop();
        }

        System.out.println("\n=== End of Vehicle Management Demo ===");
    }
}
