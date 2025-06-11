import java.util.Scanner;

public class KmToMilesConverters {
    public static void main(String[] args) {
        // Create Scanner object to read input
        Scanner input = new Scanner(System.in);

        // Declare km as double and take input
        double km;
        System.out.print("Enter distance in kilometers: ");
        km = input.nextInt();

        // Conversion: 1 mile = 1.6 km
        double miles = km / 1.6;

        // Print result
        System.out.println("The total miles is " + String.format("%.2f", miles) +
                " mile for the given " + km + " km");

        // Close the scanner
        input.close();
    }
}
