import java.util.regex.Pattern;

public class UserRegistration {
    private static final Pattern EMAIL = Pattern.compile("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");

    public void registerUser(String username, String email, String password) {
        if (username == null || username.isBlank())
            throw new IllegalArgumentException("Invalid username");
        if (email == null || !EMAIL.matcher(email).matches())
            throw new IllegalArgumentException("Invalid email");
        if (password == null || password.length() < 6)
            throw new IllegalArgumentException("Invalid password");
        // registration simulated
    }
}
