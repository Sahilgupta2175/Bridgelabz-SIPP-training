import java.util.regex.Pattern;

public class LicensePlateValidator {
    private static final String LICENSE_PLATE_REGEX = "^[A-Z]{2}\\d{4}$";
    private static final Pattern LICENSE_PLATE_PATTERN = Pattern.compile(LICENSE_PLATE_REGEX);

    public static boolean isValidLicensePlate(String licensePlate) {
        return LICENSE_PLATE_PATTERN.matcher(licensePlate).matches();
    }

    public static void main(String[] args) {
        String[] testPlates = { "AB1234", "A12345", "ab1234", "ABC123", "AB12345" };

        for (String plate : testPlates) {
            System.out.println(plate + " -> " + (isValidLicensePlate(plate) ? "Valid" : "Invalid"));
        }
    }
}
