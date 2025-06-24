public class Q6_CarRental {
    private String customerName;
    private String carModel;
    private int rentalDays;
    private double ratePerDay;

    public Q6_CarRental() {
        this.customerName = "Unknown";
        this.carModel = "Economy";
        this.rentalDays = 1;
        this.ratePerDay = 20.0;
    }

    public Q6_CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;

        switch (carModel.toLowerCase()) {
            case "economy":
                this.ratePerDay = 20.0;
                break;
            case "sedan":
                this.ratePerDay = 30.0;
                break;
            case "suv":
                this.ratePerDay = 50.0;
                break;
            case "luxury":
                this.ratePerDay = 100.0;
                break;
            default:
                this.ratePerDay = 25.0;
        }
    }

    public Q6_CarRental(String customerName, String carModel, int rentalDays, double ratePerDay) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.ratePerDay = ratePerDay;
    }

    public double calculateTotalCost() {
        return rentalDays * ratePerDay;
    }

    public void displayRentalDetails() {
        System.out.println("Car Rental Details:");
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Number of Days: " + rentalDays);
        System.out.println("Rate per Day: $" + ratePerDay);
        System.out.println("Total Cost: $" + calculateTotalCost());
    }

    public static void main(String[] args) {
        Q6_CarRental rental1 = new Q6_CarRental();
        System.out.println("Default Rental:");
        rental1.displayRentalDetails();

        System.out.println("\nRental with car model-based pricing:");
        Q6_CarRental rental2 = new Q6_CarRental("John Smith", "SUV", 3);
        rental2.displayRentalDetails();

        System.out.println("\nRental with custom pricing:");
        Q6_CarRental rental3 = new Q6_CarRental("Jane Doe", "Luxury", 2, 120.0);
        rental3.displayRentalDetails();
    }
}
