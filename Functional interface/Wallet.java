public class Wallet implements DigitalPayment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via Wallet");
    }
}
