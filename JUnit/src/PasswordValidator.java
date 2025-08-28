public class PasswordValidator {
    public boolean isValid(String password) {
        if (password == null)
            return false;
        if (password.length() < 8)
            return false;
        boolean hasUpper = false, hasDigit = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c))
                hasUpper = true;
            if (Character.isDigit(c))
                hasDigit = true;
        }
        return hasUpper && hasDigit;
    }
}
