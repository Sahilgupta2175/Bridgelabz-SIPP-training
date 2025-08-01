public class ThrowVsThrowsDemo {
    static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        if (amount < 0 || rate < 0)
            throw new IllegalArgumentException();
        return amount * rate * years / 100;
    }

    public static void main(String[] args) {
        try {
            double interest = calculateInterest(1000, 5, 2);
            System.out.println(interest);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: Amount and rate must be positive");
        }
    }
}
