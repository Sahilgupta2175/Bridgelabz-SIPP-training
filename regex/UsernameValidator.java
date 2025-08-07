import java.util.regex.Pattern;

public class UsernameValidator {
    private static final String USERNAME_REGEX = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
    private static final Pattern USERNAME_PATTERN = Pattern.compile(USERNAME_REGEX);

    public static boolean isValidUsername(String username) {
        return USERNAME_PATTERN.matcher(username).matches();
    }

    public static void main(String[] args) {
        String[] testUsernames = { "user_123", "123user", "us", "validUser", "invalid-name", "a_very_long_username" };

        for (String username : testUsernames) {
            System.out.println(username + " -> " + (isValidUsername(username) ? "Valid" : "Invalid"));
        }
    }
}
