public class Q9_Vehicle {
    private String ownerName;
    private String vehicleType;

    private static double registrationFee = 500.0;

    public Q9_Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public void displayVehicleDetails() {
        System.out.println("Vehicle Details:");
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: $" + registrationFee);
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println("Registration fee updated to: $" + registrationFee);
    }

    public static double getRegistrationFee() {
        return registrationFee;
    }

    public static void main(String[] args) {
        System.out.println("Initial Registration Fee: $" + Q9_Vehicle.getRegistrationFee());

        Q9_Vehicle vehicle1 = new Q9_Vehicle("John Smith", "Sedan");
        Q9_Vehicle vehicle2 = new Q9_Vehicle("Jane Doe", "SUV");
        Q9_Vehicle vehicle3 = new Q9_Vehicle("Robert Johnson", "Motorcycle");

        System.out.println("\nVehicle Information (Before Fee Change):");
        vehicle1.displayVehicleDetails();

        System.out.println("\nUpdating Registration Fee...");
        Q9_Vehicle.updateRegistrationFee(600.0);

        System.out.println("\nVehicle Information (After Fee Change):");
        vehicle1.displayVehicleDetails();
        System.out.println();
        vehicle2.displayVehicleDetails();
        System.out.println();
        vehicle3.displayVehicleDetails();
    }
}
