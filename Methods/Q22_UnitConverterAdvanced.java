import java.util.Scanner;

public class Q22_UnitConverterAdvanced {

    public static double convertYardsToFeet(double yards) {
        return yards * 3;
    }

    public static double convertFeetToYards(double feet) {
        return feet * 0.333333;
    }

    public static double convertMetersToInches(double meters) {
        return meters * 39.3701;
    }

    public static double convertInchesToMeters(double inches) {
        return inches * 0.0254;
    }

    public static double convertInchesToCm(double inches) {
        return inches * 2.54;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1-Yards to Feet\n2-Feet to Yards\n3-Meters to Inches\n4-Inches to Meters\n5-Inches to CM");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        System.out.print("Enter value: ");
        double value = sc.nextDouble();

        switch (choice) {
            case 1 -> System.out.println("Feet: " + convertYardsToFeet(value));
            case 2 -> System.out.println("Yards: " + convertFeetToYards(value));
            case 3 -> System.out.println("Inches: " + convertMetersToInches(value));
            case 4 -> System.out.println("Meters: " + convertInchesToMeters(value));
            case 5 -> System.out.println("Centimeters: " + convertInchesToCm(value));
            default -> System.out.println("Invalid choice");
        }
        sc.close();
    }
}
