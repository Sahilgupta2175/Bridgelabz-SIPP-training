public class CourseFeeDiscount {
    public static void main(String[] args) {
        // Initialize fee and discount percentage
        double fee = 125000;
        double discountPercent = 10;

        // Calculate discount and final fee
        double discount = (discountPercent / 100) * fee;
        double finalFee = fee - discount;

        // Print result
        System.out.println("The discount amount is INR " + String.format("%.2f", discount) +
                " and final discounted fee is INR " + String.format("%.2f", finalFee));
    }
}
