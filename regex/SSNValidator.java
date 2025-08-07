import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class SSNValidator {
    private static final String SSN_REGEX = "\\b\\d{3}-\\d{2}-\\d{4}\\b";
    private static final Pattern SSN_PATTERN = Pattern.compile(SSN_REGEX);

    public static boolean isValidSSN(String ssn) {
        return SSN_PATTERN.matcher(ssn).matches();
    }

    public static String extractAndValidateSSN(String text) {
        Matcher matcher = SSN_PATTERN.matcher(text);
        if (matcher.find()) {
            String ssn = matcher.group();
            return ssn + " is valid";
        } else {
            return "No valid SSN found";
        }
    }

    public static void main(String[] args) {
        String[] testTexts = {
                "My SSN is 123-45-6789.",
                "Invalid SSN: 123456789",
                "Another SSN: 987-65-4321 here."
        };

        for (String text : testTexts) {
            System.out.println("Text: " + text);
            System.out.println("Result: " + extractAndValidateSSN(text));
            System.out.println();
        }
    }
}
