import java.util.regex.Pattern;

public class CreditCardValidator {
    private static final String VISA_REGEX = "^4\\d{15}$";
    private static final String MASTERCARD_REGEX = "^5\\d{15}$";
    private static final Pattern VISA_PATTERN = Pattern.compile(VISA_REGEX);
    private static final Pattern MASTERCARD_PATTERN = Pattern.compile(MASTERCARD_REGEX);

    public static String validateCreditCard(String cardNumber) {
        if (VISA_PATTERN.matcher(cardNumber).matches()) {
            return "Valid Visa";
        } else if (MASTERCARD_PATTERN.matcher(cardNumber).matches()) {
            return "Valid MasterCard";
        } else {
            return "Invalid";
        }
    }

    public static void main(String[] args) {
        String[] testCards = { "4123456789012345", "5123456789012345", "3123456789012345", "412345678901234" };

        for (String card : testCards) {
            System.out.println(card + " -> " + validateCreditCard(card));
        }
    }
}
