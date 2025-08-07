import java.util.regex.Pattern;

public class IPAddressValidator {
    private static final String IP_REGEX = "^(?:(?:25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}(?:25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$";
    private static final Pattern IP_PATTERN = Pattern.compile(IP_REGEX);

    public static boolean isValidIPAddress(String ip) {
        return IP_PATTERN.matcher(ip).matches();
    }

    public static void main(String[] args) {
        String[] testIPs = { "192.168.1.1", "255.255.255.255", "0.0.0.0", "256.1.1.1", "192.168.1", "192.168.1.1.1" };

        for (String ip : testIPs) {
            System.out.println(ip + " -> " + (isValidIPAddress(ip) ? "Valid" : "Invalid"));
        }
    }
}
