class Q4_UnitConverter1 {

    public static double convertKmToMiles(double km) {
        return km * 0.621371;
    }

    public static double convertMilesToKm(double miles) {
        return miles * 1.60934;
    }

    public static double convertMetersToFeet(double meters) {
        return meters * 3.28084;
    }

    public static double convertFeetToMeters(double feet) {
        return feet * 0.3048;
    }

    public static void main(String[] args) {
        System.out.println("5 km to miles: " + convertKmToMiles(5));
        System.out.println("3 miles to km: " + convertMilesToKm(3));
        System.out.println("10 m to feet: " + convertMetersToFeet(10));
        System.out.println("15 ft to m: " + convertFeetToMeters(15));
    }
}
