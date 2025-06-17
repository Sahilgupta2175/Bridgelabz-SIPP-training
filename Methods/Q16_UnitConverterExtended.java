import java.util.Scanner;

public class Q16_UnitConverterExtended {

    public static double convertFahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    public static double convertCelsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    public static double convertPoundsToKilograms(double p) {
        return p * 0.453592;
    }

    public static double convertKilogramsToPounds(double kg) {
        return kg * 2.20462;
    }

    public static double convertGallonsToLiters(double g) {
        return g * 3.78541;
    }

    public static double convertLitersToGallons(double l) {
        return l * 0.264172;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1-F to C\n2-C to F\n3-Pound to Kg\n4-Kg to Pound\n5-Gallon to Liter\n6-Liter to Gallon");
        System.out.print("Choose option: ");
        int option = sc.nextInt();
        System.out.print("Enter value: ");
        double value = sc.nextDouble();

        switch (option) {
            case 1 -> System.out.println("Celsius: " + convertFahrenheitToCelsius(value));
            case 2 -> System.out.println("Fahrenheit: " + convertCelsiusToFahrenheit(value));
            case 3 -> System.out.println("Kilograms: " + convertPoundsToKilograms(value));
            case 4 -> System.out.println("Pounds: " + convertKilogramsToPounds(value));
            case 5 -> System.out.println("Liters: " + convertGallonsToLiters(value));
            case 6 -> System.out.println("Gallons: " + convertLitersToGallons(value));
            default -> System.out.println("Invalid option!");
        }
        sc.close();
    }
}
