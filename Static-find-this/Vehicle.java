/**
 * Vehicle class for Vehicle Registration System
 * Demonstrates static variables, static methods, this keyword, final variables,
 * and instanceof
 */
public class Vehicle {
    // Static variable common for all vehicles - represents registration fee
    private static double registrationFee = 150.0; // Default registration fee

    // Static variable to track total number of vehicles registered
    private static int totalVehicles = 0;

    // Instance variables
    private String ownerName;
    private String vehicleType;

    // Final variable - registration number cannot be changed once assigned
    private final String registrationNumber;

    private String model;
    private int year;
    private String color;
    private boolean isRegistered;

    /**
     * Constructor to create a new vehicle
     * Uses 'this' keyword to initialize instance variables when parameter names
     * match
     * 
     * @param ownerName          Name of the vehicle owner
     * @param vehicleType        Type of vehicle (Car, Motorcycle, Truck, etc.)
     * @param registrationNumber Unique registration number (final - cannot be
     *                           changed)
     * @param model              Model of the vehicle
     * @param year               Manufacturing year of the vehicle
     * @param color              Color of the vehicle
     */
    public Vehicle(String ownerName, String vehicleType, String registrationNumber,
            String model, int year, String color) {
        // Using 'this' to distinguish between instance variables and parameters
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.model = model;
        this.year = year;
        this.color = color;

        // Final variable assignment - can only be done once during initialization
        this.registrationNumber = registrationNumber;

        // Initially, vehicle is registered upon creation
        this.isRegistered = true;

        // Increment static counter for total vehicles
        totalVehicles++;
    }

    /**
     * Static method to update the registration fee for all vehicles
     * Can be called without creating an instance of the Vehicle class
     * 
     * @param newFee New registration fee to be set
     */
    public static void updateRegistrationFee(double newFee) {
        if (newFee > 0) {
            double oldFee = registrationFee;
            registrationFee = newFee;
            System.out.println("Registration fee updated!");
            System.out.println("Previous fee: $" + oldFee + " | New fee: $" + registrationFee);
        } else {
            System.out.println("Invalid registration fee! Must be greater than 0.");
        }
    }

    /**
     * Static method to get current registration fee
     * 
     * @return Current registration fee
     */
    public static double getRegistrationFee() {
        return registrationFee;
    }

    /**
     * Static method to get total number of registered vehicles
     * 
     * @return Total count of registered vehicles
     */
    public static int getTotalVehicles() {
        return totalVehicles;
    }

    /**
     * Static method to display registration fee information
     */
    public static void displayRegistrationFeeInfo() {
        System.out.println("Current vehicle registration fee: $" + registrationFee);
    }

    /**
     * Static method to calculate registration fee with additional charges
     * 
     * @param vehicleAge Age of the vehicle in years
     * @param isLuxury   Whether the vehicle is a luxury vehicle
     * @return Total registration fee including additional charges
     */
    public static double calculateTotalRegistrationFee(int vehicleAge, boolean isLuxury) {
        double totalFee = registrationFee;

        // Additional fee for older vehicles (maintenance inspection)
        if (vehicleAge > 10) {
            totalFee += 50.0;
        }

        // Luxury vehicle surcharge
        if (isLuxury) {
            totalFee += 200.0;
        }

        return totalFee;
    }

    /**
     * Method to renew vehicle registration
     * 
     * @return Total fee paid for renewal
     */
    public double renewRegistration() {
        if (!this.isRegistered) {
            System.out.println("Vehicle was not registered. Registering now...");
        }

        int vehicleAge = 2024 - this.year;
        boolean isLuxury = this.vehicleType.equalsIgnoreCase("Luxury Car") ||
                this.vehicleType.equalsIgnoreCase("Sports Car");

        double totalFee = calculateTotalRegistrationFee(vehicleAge, isLuxury);
        this.isRegistered = true;

        System.out.println("Registration renewed for vehicle: " + this.registrationNumber);
        System.out.println("Owner: " + this.ownerName);
        System.out.println("Total fee paid: $" + totalFee);

        return totalFee;
    }

    /**
     * Method to transfer ownership of the vehicle
     * 
     * @param newOwnerName Name of the new owner
     */
    public void transferOwnership(String newOwnerName) {
        String previousOwner = this.ownerName;
        this.ownerName = newOwnerName;

        System.out.println("Ownership transferred for vehicle: " + this.registrationNumber);
        System.out.println("Previous owner: " + previousOwner);
        System.out.println("New owner: " + this.ownerName);

        // Transfer fee (additional cost)
        double transferFee = registrationFee * 0.1; // 10% of registration fee
        System.out.println("Transfer fee: $" + transferFee);
    }

    /**
     * Method to check if vehicle registration is valid
     * 
     * @return true if registration is valid, false otherwise
     */
    public boolean isRegistrationValid() {
        return this.isRegistered;
    }

    /**
     * Method to calculate vehicle age
     * 
     * @return Age of the vehicle in years
     */
    public int getVehicleAge() {
        return 2024 - this.year;
    }

    /**
     * Method to display detailed vehicle registration information
     * This method is called only after instanceof verification
     */
    public void displayRegistrationDetails() {
        System.out.println("\n=== Vehicle Registration Details ===");
        System.out.println("Registration Number: " + this.registrationNumber);
        System.out.println("Owner Name: " + this.ownerName);
        System.out.println("Vehicle Type: " + this.vehicleType);
        System.out.println("Model: " + this.model);
        System.out.println("Year: " + this.year);
        System.out.println("Color: " + this.color);
        System.out.println("Vehicle Age: " + getVehicleAge() + " years");
        System.out.println("Registration Status: " + (this.isRegistered ? "Valid" : "Expired"));
        System.out.println("Current Registration Fee: $" + registrationFee);
        System.out.println("====================================");
    }

    /**
     * Static method to safely display vehicle registration details using instanceof
     * Demonstrates type checking before casting and method invocation
     * 
     * @param obj Object to be verified and displayed
     */
    public static void displayVehicleInfo(Object obj) {
        // Using instanceof to check if an object belongs to the Vehicle class
        if (obj instanceof Vehicle) {
            System.out.println("Valid Vehicle object detected!");
            Vehicle vehicle = (Vehicle) obj; // Safe casting after instanceof check
            vehicle.displayRegistrationDetails();
        } else {
            System.out.println("Error: Object is not an instance of Vehicle class!");
            System.out.println("Cannot display registration details for: " + obj.getClass().getSimpleName());
        }
    }

    /**
     * Static method to safely process vehicle operations using instanceof
     * 
     * @param obj       Object to be verified before processing
     * @param operation Operation to perform ("renew", "transfer", "info")
     * @param parameter Additional parameter for operations
     * @return true if operation successful, false otherwise
     */
    public static boolean processVehicleOperation(Object obj, String operation, String parameter) {
        if (obj instanceof Vehicle) {
            Vehicle vehicle = (Vehicle) obj;

            switch (operation.toLowerCase()) {
                case "renew":
                    vehicle.renewRegistration();
                    return true;
                case "transfer":
                    if (parameter != null && !parameter.trim().isEmpty()) {
                        vehicle.transferOwnership(parameter);
                        return true;
                    } else {
                        System.out.println("New owner name required for transfer!");
                        return false;
                    }
                case "info":
                    vehicle.displayRegistrationDetails();
                    return true;
                default:
                    System.out.println("Unknown operation: " + operation);
                    return false;
            }
        } else {
            System.out.println("Cannot process vehicle operation: Object is not a Vehicle instance!");
            return false;
        }
    }

    /**
     * Method to check if vehicle is eligible for senior citizen discount
     * 
     * @return true if eligible for discount, false otherwise
     */
    public boolean isEligibleForDiscount() {
        return getVehicleAge() > 15; // Vehicles older than 15 years get discount
    }

    /**
     * Getter methods for accessing private fields
     */
    public String getOwnerName() {
        return this.ownerName;
    }

    public String getVehicleType() {
        return this.vehicleType;
    }

    public String getRegistrationNumber() {
        return this.registrationNumber; // Final variable - read-only access
    }

    public String getModel() {
        return this.model;
    }

    public int getYear() {
        return this.year;
    }

    public String getColor() {
        return this.color;
    }

    public boolean isRegistered() {
        return this.isRegistered;
    }

    /**
     * Setter methods (excluding final variable 'registrationNumber')
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Main method to demonstrate the Vehicle class functionality
     */
    public static void main(String[] args) {
        System.out.println("=== Vehicle Registration System Demo ===\n");

        // Display initial registration fee information
        Vehicle.displayRegistrationFeeInfo();
        System.out.println("Initial registered vehicles: " + Vehicle.getTotalVehicles());

        // Create vehicle instances
        Vehicle vehicle1 = new Vehicle("John Smith", "Car", "ABC123", "Toyota Camry", 2020, "Blue");
        Vehicle vehicle2 = new Vehicle("Jane Doe", "Motorcycle", "XYZ789", "Honda CBR", 2019, "Red");
        Vehicle vehicle3 = new Vehicle("Bob Johnson", "Truck", "TRK456", "Ford F-150", 2018, "White");
        Vehicle vehicle4 = new Vehicle("Alice Brown", "Luxury Car", "LUX999", "BMW X5", 2022, "Black");
        Vehicle vehicle5 = new Vehicle("Charlie Davis", "Car", "OLD001", "Honda Civic", 2005, "Silver");

        // Display updated vehicle count
        System.out.println("\nAfter vehicle registration:");
        System.out.println("Total registered vehicles: " + Vehicle.getTotalVehicles());

        // Demonstrate vehicle operations
        System.out.println("\n=== Vehicle Operations ===");

        // Renew registrations
        System.out.println("--- Registration Renewals ---");
        vehicle1.renewRegistration();
        vehicle2.renewRegistration();
        vehicle4.renewRegistration(); // Luxury vehicle - higher fee
        vehicle5.renewRegistration(); // Old vehicle - additional inspection fee

        // Transfer ownership
        System.out.println("\n--- Ownership Transfers ---");
        vehicle3.transferOwnership("Mike Wilson");

        // Demonstrate instanceof usage with valid Vehicle objects
        System.out.println("\n=== Instanceof Demonstration ===");
        Vehicle.displayVehicleInfo(vehicle1);
        Vehicle.displayVehicleInfo(vehicle2);
        Vehicle.displayVehicleInfo(vehicle3);
        Vehicle.displayVehicleInfo(vehicle4);
        Vehicle.displayVehicleInfo(vehicle5);

        // Demonstrate instanceof with invalid objects
        String invalidObject1 = "Not a Vehicle";
        Integer invalidObject2 = 12345;
        Vehicle.displayVehicleInfo(invalidObject1);
        Vehicle.displayVehicleInfo(invalidObject2);

        // Demonstrate instanceof in vehicle operations
        System.out.println("\n=== Instanceof in Vehicle Operations ===");
        Vehicle.processVehicleOperation(vehicle1, "renew", null);
        Vehicle.processVehicleOperation(vehicle2, "transfer", "Sarah Connor");
        Vehicle.processVehicleOperation("Invalid Object", "info", null);

        // Demonstrate registration fee update
        System.out.println("\n=== Registration Fee Update Demo ===");
        Vehicle.updateRegistrationFee(175.0);
        Vehicle.displayRegistrationFeeInfo();

        // Show updated renewal costs
        System.out.println("\nRenewal after fee increase:");
        vehicle1.renewRegistration();

        // Final variable demonstration
        System.out.println("\n=== Final Variable Demo ===");
        System.out.println("Vehicle Registration Number (final variable): " + vehicle1.getRegistrationNumber());
        // vehicle1.registrationNumber = "NEW_ABC123"; // Uncommenting this would cause
        // compilation error

        // Discount eligibility check
        System.out.println("\n=== Discount Eligibility Report ===");
        Vehicle[] allVehicles = { vehicle1, vehicle2, vehicle3, vehicle4, vehicle5 };

        for (Vehicle vehicle : allVehicles) {
            String eligibility = vehicle.isEligibleForDiscount() ? "Eligible" : "Not Eligible";
            System.out.println(vehicle.getRegistrationNumber() + " (" + vehicle.getVehicleAge() +
                    " years old): " + eligibility + " for senior vehicle discount");
        }

        // Vehicle type distribution
        System.out.println("\n=== Vehicle Type Distribution ===");
        String[] vehicleTypes = { "Car", "Motorcycle", "Truck", "Luxury Car" };

        for (String type : vehicleTypes) {
            System.out.print(type + ": ");
            int count = 0;
            for (Vehicle vehicle : allVehicles) {
                if (vehicle.getVehicleType().equalsIgnoreCase(type)) {
                    System.out.print(vehicle.getRegistrationNumber() + " ");
                    count++;
                }
            }
            System.out.println("(Total: " + count + ")");
        }

        // Registration fee calculation examples
        System.out.println("\n=== Registration Fee Calculation Examples ===");
        System.out.println("Standard fee: $" + Vehicle.getRegistrationFee());
        System.out.println("New vehicle (luxury): $" + Vehicle.calculateTotalRegistrationFee(2, true));
        System.out.println("Old vehicle (standard): $" + Vehicle.calculateTotalRegistrationFee(15, false));
        System.out.println("Old luxury vehicle: $" + Vehicle.calculateTotalRegistrationFee(12, true));

        // Final statistics
        System.out.println("\n=== Final Registration Statistics ===");
        Vehicle.displayRegistrationFeeInfo();
        System.out.println("Total registered vehicles: " + Vehicle.getTotalVehicles());

        // Calculate total registration revenue
        double totalRevenue = 0;
        for (Vehicle vehicle : allVehicles) {
            int age = vehicle.getVehicleAge();
            boolean isLuxury = vehicle.getVehicleType().toLowerCase().contains("luxury");
            totalRevenue += Vehicle.calculateTotalRegistrationFee(age, isLuxury);
        }
        System.out.println("Total registration revenue: $" + totalRevenue);

        // Average vehicle age
        double totalAge = 0;
        for (Vehicle vehicle : allVehicles) {
            totalAge += vehicle.getVehicleAge();
        }
        double averageAge = totalAge / allVehicles.length;
        System.out.println("Average vehicle age: " + String.format("%.1f", averageAge) + " years");
    }
}
