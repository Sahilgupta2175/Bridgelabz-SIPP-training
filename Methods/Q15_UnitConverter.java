import java.util.Scanner;

public class Q15_UnitConverter {

    // distance
    public static double convertKmToMiles(double km) {
        return km * 0.621371;
    }

    public static double convertMilesToKm(double miles) {
        return miles * 1.60934;
    }

    public static double convertMetersToFeet(double m) {
        return m * 3.28084;
    }

    public static double convertFeetToMeters(double ft) {
        return ft * 0.3048;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1‑Km→Miles  2‑Miles→Km  3‑Meters→Feet  4‑Feet→Meters");
        System.out.print("Choose option: ");
        int opt = sc.nextInt();
        switch (opt) {
            case 1 -> {
                System.out.print("Kilometers: ");
                double km = sc.nextDouble();
                System.out.printf("Miles: %.4f%n", convertKmToMiles(km));
            }
            case 2 -> {
                System.out.print("Miles: ");
                double mi = sc.nextDouble();
                System.out.printf("Kilometers: %.4f%n", convertMilesToKm(mi));
            }
            case 3 -> {
                System.out.print("Meters: ");
                double m = sc.nextDouble();
                System.out.printf("Feet: %.4f%n", convertMetersToFeet(m));
            }
            case 4 -> {
                System.out.print("Feet: ");
                double ft = sc.nextDouble();
                System.out.printf("Meters: %.4f%n", convertFeetToMeters(ft));
            }
            default -> System.out.println("Invalid choice!");
        }
        sc.close();
    }
}
