class Q6_UnitConverter3 {

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

    public static double convertGallonsToLiters(double gal) {
        return gal * 3.78541;
    }

    public static double convertLitersToGallons(double l) {
        return l * 0.264172;
    }

    public static void main(String[] args) {
        System.out.println("100°F to °C: " + convertFahrenheitToCelsius(100));
        System.out.println("37°C to °F: " + convertCelsiusToFahrenheit(37));
        System.out.println("150 pounds to kg: " + convertPoundsToKilograms(150));
        System.out.println("70 kg to pounds: " + convertKilogramsToPounds(70));
        System.out.println("1 gallon to liters: " + convertGallonsToLiters(1));
        System.out.println("3.5 liters to gallons: " + convertLitersToGallons(3.5));
    }
}
