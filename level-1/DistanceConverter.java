import java.util.Scanner;

public class DistanceConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input distance in feet
        System.out.print("Enter distance in feet: ");
        double feet = input.nextDouble();

        // Convert to yards and miles
        double yards = feet / 3.0;
        double miles = yards / 1760.0;

        // Output
        System.out.println("The distance in feet is " + feet +
                ", in yards is " + String.format("%.2f", yards) +
                ", and in miles is " + String.format("%.4f", miles));

        input.close();
    }
}
