public interface SecurityUtils {
    static boolean isStrongPassword(String password) {
        return password != null && password.length() >= 8 && password.matches(".*[A-Z].*")
                && password.matches(".*[0-9].*");
    }
}
