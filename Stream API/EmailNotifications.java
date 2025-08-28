import java.util.*;

public class EmailNotifications {
    public static void main(String[] args) {
        List<String> emails = Arrays.asList("a@example.com", "b@example.com", "c@example.com");
        emails.forEach(EmailNotifications::sendEmailNotification);
    }

    static void sendEmailNotification(String email) {
        System.out.println("Notification sent to: " + email);
    }
}
