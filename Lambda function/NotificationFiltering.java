import java.util.*;
import java.util.stream.*;

class Alert {
    private String type;
    private String message;

    public Alert(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public String toString() {
        return type + ": " + message;
    }
}

public class NotificationFiltering {
    public static void main(String[] args) {
        List<Alert> alerts = Arrays.asList(
                new Alert("CRITICAL", "Patient heart rate abnormal!"),
                new Alert("INFO", "Patient checkup scheduled."),
                new Alert("CRITICAL", "Low oxygen level!"),
                new Alert("NORMAL", "Vitals stable."));

        List<Alert> criticalAlerts = alerts.stream()
                .filter(alert -> alert.getType().equals("CRITICAL"))
                .collect(Collectors.toList());

        System.out.println("Critical Alerts: " + criticalAlerts);
    }
}
