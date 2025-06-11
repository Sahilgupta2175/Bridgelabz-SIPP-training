import java.util.Scanner;

public class PurchaseCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input unit price and quantity
        System.out.print("Enter unit price (INR): ");
        double unitPrice = input.nextDouble();

        System.out.print("Enter quantity: ");
        int quantity = input.nextInt();

        // Calculate total price
        double totalPrice = unitPrice * quantity;

        // Output
        System.out.println("The total purchase price is INR " + String.format("%.2f", totalPrice) +
                " if the quantity " + quantity + " and unit price is INR " + unitPrice);

        input.close();
    }
}