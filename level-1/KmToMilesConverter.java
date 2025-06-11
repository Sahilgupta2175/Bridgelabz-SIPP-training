public class KmToMilesConverter {
    public static void main(String[] args) {
        // Given distance in kilometers
        double kilometers = 10.8;

        // Conversion factor
        double milesPerKm = 1.6;

        // Calculate miles
        double miles = kilometers * milesPerKm;

        // Print result
        System.out.println("The distance " + kilometers + " km in miles is " + String.format("%.2f", miles));
    }
}
