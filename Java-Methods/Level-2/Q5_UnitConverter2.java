class Q5_UnitConverter2 {

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
        System.out.println("2 yards to feet: " + convertYardsToFeet(2));
        System.out.println("6 feet to yards: " + convertFeetToYards(6));
        System.out.println("1 meter to inches: " + convertMetersToInches(1));
        System.out.println("20 inches to meters: " + convertInchesToMeters(20));
        System.out.println("10 inches to cm: " + convertInchesToCm(10));
    }
}
