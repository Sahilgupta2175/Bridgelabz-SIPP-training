import java.util.regex.Pattern;

public class HexColorValidator {
    private static final String HEX_COLOR_REGEX = "^#[0-9A-Fa-f]{6}$";
    private static final Pattern HEX_COLOR_PATTERN = Pattern.compile(HEX_COLOR_REGEX);

    public static boolean isValidHexColor(String hexColor) {
        return HEX_COLOR_PATTERN.matcher(hexColor).matches();
    }

    public static void main(String[] args) {
        String[] testColors = { "#FFA500", "#ff4500", "#123", "#GGHHII", "#123456", "#abcdef" };

        for (String color : testColors) {
            System.out.println(color + " -> " + (isValidHexColor(color) ? "Valid" : "Invalid"));
        }
    }
}
