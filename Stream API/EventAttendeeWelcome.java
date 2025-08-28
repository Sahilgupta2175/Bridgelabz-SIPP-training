import java.util.*;

public class EventAttendeeWelcome {
    public static void main(String[] args) {
        List<String> attendees = Arrays.asList("Alice", "Bob", "Charlie");
        attendees.forEach(name -> System.out.println("Welcome, " + name + "!"));
    }
}
