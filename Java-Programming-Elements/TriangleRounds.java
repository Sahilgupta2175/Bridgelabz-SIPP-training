import java.util.Scanner;

public class TriangleRounds {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter side 1 in meters: ");
        double side1 = input.nextDouble();
        System.out.print("Enter side 2 in meters: ");
        double side2 = input.nextDouble();
        System.out.print("Enter side 3 in meters: ");
        double side3 = input.nextDouble();
        double perimeter = side1 + side2 + side3;
        double distanceKm = 5;
        double distanceMeters = distanceKm * 1000;
        double rounds = distanceMeters / perimeter;
        System.out.printf("The total number of rounds the athlete will run is %.2f to complete 5 km%n", rounds);
        input.close();
    }
}