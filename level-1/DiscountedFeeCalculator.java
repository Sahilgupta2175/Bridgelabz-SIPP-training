import java.util.Scanner;

public class DiscountedFeeCalculator {
    public static void main(String[] args) {
        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Declare variables
        double fee;
        double discountPercent;

        // Take user input for fee and discount
        System.out.print("Enter the course fee (INR): ");
        fee = input.nextDouble();

        System.out.print("Enter the discount percent: ");
        discountPercent = input.nextDouble();

        // Calculate discount and final fee
        double discount = (discountPercent / 100) * fee;
        double finalFee = fee - discount;

        // Display result
        System.out.println("The discount amount is INR " + String.format("%.2f", discount) +
                " and final discounted fee is INR " + String.format("%.2f", finalFee));

        // Close Scanner
        input.close();
    }
}
