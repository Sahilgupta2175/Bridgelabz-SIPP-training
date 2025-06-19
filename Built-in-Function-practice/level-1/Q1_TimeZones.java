import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Q1_TimeZones {
    public static void main(String[] args) {
        ZonedDateTime gmt = ZonedDateTime.now(ZoneId.of("GMT"));
        ZonedDateTime ist = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        ZonedDateTime pst = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss z");

        System.out.println("Current Time in GMT: " + gmt.format(formatter));
        System.out.println("Current Time in IST: " + ist.format(formatter));
        System.out.println("Current Time in PST: " + pst.format(formatter));
    }
}
