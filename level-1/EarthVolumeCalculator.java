public class EarthVolumeCalculator {
    public static void main(String[] args) {
        // Radius of Earth in kilometers
        double radiusKm = 6378;

        // Volume of Earth in cubic kilometers
        double volumeKm3 = (4.0 / 3.0) * Math.PI * Math.pow(radiusKm, 3);

        // Conversion factor from km^3 to miles^3
        double kmToMiles = 0.621371;
        double volumeMiles3 = volumeKm3 * Math.pow(kmToMiles, 3);

        // Print result
        System.out.println("The volume of earth in cubic kilometers is " + String.format("%.2f", volumeKm3) +
                " and cubic miles is " + String.format("%.2f", volumeMiles3));
    }
}
