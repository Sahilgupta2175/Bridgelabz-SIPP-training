public class CourseFee {
    public static void main(String[] args) {
        double fee = 125000;
        double discountPercent = 10;
        double discount = (discountPercent / 100) * fee;
        double discountedFee = fee - discount;
        System.out.printf("The discount amount is INR %.2f and final discounted fee is INR %.2f%n",
                         discount, discountedFee);
    }
}