import java.util.Scanner;

class Q10_WindChill {
    public static double calculateWindChill(double temperature, double windSpeed) {
        return 35.74 + 0.6215 * temperature +
                (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter temperature (in °F): ");
        double temp = sc.nextDouble();
        System.out.print("Enter wind speed (in mph): ");
        double speed = sc.nextDouble();

        double windChill = calculateWindChill(temp, speed);
        System.out.printf("Wind Chill Temperature: %.2f°F\n", windChill);
        sc.close();
    }
}
