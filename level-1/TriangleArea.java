import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input base and height in inches
        System.out.print("Enter base of triangle (in inches): ");
        double base = input.nextDouble();

        System.out.print("Enter height of triangle (in inches): ");
        double height = input.nextDouble();

        // Area in square inches
        double areaInches = 0.5 * base * height;

        // Convert to square centimeters (1 inch = 2.54 cm => 1 in² = 6.4516 cm²)
        double areaCm = areaInches * 6.4516;

        // Output
        System.out.println("The area of triangle is " + String.format("%.2f", areaInches) +
                " square inches and " + String.format("%.2f", areaCm) + " square centimeters");

        input.close();
    }
}
