import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

class Member {
    String name;
    LocalDate expiryDate;

    Member(String name, LocalDate expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
    }

    public String toString() {
        return name + " (Expires: " + expiryDate + ")";
    }
}

public class ExpiringMemberships {
    public static void main(String[] args) {
        List<Member> members = Arrays.asList(
                new Member("Alice", LocalDate.now().plusDays(10)),
                new Member("Bob", LocalDate.now().plusDays(40)),
                new Member("Charlie", LocalDate.now().plusDays(25)),
                new Member("Diana", LocalDate.now().plusDays(5)));
        LocalDate now = LocalDate.now();
        LocalDate in30 = now.plusDays(30);
        List<Member> expiring = members.stream()
                .filter(m -> !m.expiryDate.isBefore(now) && !m.expiryDate.isAfter(in30))
                .collect(Collectors.toList());
        expiring.forEach(System.out::println);
    }
}
