import java.util.Scanner;

public class Q8_TriangularPark {
    public static double calculateRounds(double a, double b, double c) {
        double perimeter = a + b + c;
        double distance = 5000; // in meters (5km)
        return distance / perimeter;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter side A (in meters): ");
        double a = sc.nextDouble();
        System.out.print("Enter side B (in meters): ");
        double b = sc.nextDouble();
        System.out.print("Enter side C (in meters): ");
        double c = sc.nextDouble();

        double rounds = calculateRounds(a, b, c);
        System.out.printf("The athlete must complete %.2f rounds.\n", rounds);
        sc.close();
    }
}
