import java.util.*;
import java.util.stream.Collectors;

class Claim {
    String type;
    double amount;

    Claim(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }
}

public class InsuranceClaimAnalysis {
    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
                new Claim("Health", 1200),
                new Claim("Auto", 3000),
                new Claim("Health", 800),
                new Claim("Auto", 2500),
                new Claim("Home", 5000));
        Map<String, Double> avgClaim = claims.stream()
                .collect(Collectors.groupingBy(
                        c -> c.type,
                        Collectors.averagingDouble(c -> c.amount)));
        avgClaim.forEach((type, avg) -> System.out.println(type + ": " + avg));
    }
}
