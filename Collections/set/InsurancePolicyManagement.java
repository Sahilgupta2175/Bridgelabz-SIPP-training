package set;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

class Policy {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate,
            String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyholderName() {
        return policyholderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Policy policy = (Policy) obj;
        return Objects.equals(policyNumber, policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public String toString() {
        return String.format("Policy{number='%s', holder='%s', expiry=%s, type='%s', premium=%.2f}",
                policyNumber, policyholderName, expiryDate, coverageType, premiumAmount);
    }
}

public class InsurancePolicyManagement {
    private HashSet<Policy> hashSetPolicies;
    private LinkedHashSet<Policy> linkedHashSetPolicies;
    private TreeSet<Policy> treeSetPolicies;

    public InsurancePolicyManagement() {
        hashSetPolicies = new HashSet<>();
        linkedHashSetPolicies = new LinkedHashSet<>();
        treeSetPolicies = new TreeSet<>(Comparator.comparing(Policy::getExpiryDate));
    }

    public void addPolicy(Policy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    public Set<Policy> getAllUniquePolicies() {
        return new HashSet<>(hashSetPolicies);
    }

    public Set<Policy> getPoliciesInInsertionOrder() {
        return new LinkedHashSet<>(linkedHashSetPolicies);
    }

    public Set<Policy> getPoliciesSortedByExpiry() {
        return new TreeSet<>(treeSetPolicies);
    }

    public Set<Policy> getPoliciesExpiringSoon() {
        LocalDate thirtyDaysFromNow = LocalDate.now().plusDays(30);
        return treeSetPolicies.stream()
                .filter(policy -> policy.getExpiryDate().isBefore(thirtyDaysFromNow) ||
                        policy.getExpiryDate().isEqual(thirtyDaysFromNow))
                .collect(Collectors.toSet());
    }

    public Set<Policy> getPoliciesByCoverageType(String coverageType) {
        return hashSetPolicies.stream()
                .filter(policy -> policy.getCoverageType().equalsIgnoreCase(coverageType))
                .collect(Collectors.toSet());
    }

    public void performanceComparison() {
        Policy testPolicy = new Policy("TEST001", "Test User", LocalDate.now().plusYears(1), "Test", 1000.0);

        long startTime, endTime;

        startTime = System.nanoTime();
        hashSetPolicies.contains(testPolicy);
        endTime = System.nanoTime();
        System.out.println("HashSet search time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        linkedHashSetPolicies.contains(testPolicy);
        endTime = System.nanoTime();
        System.out.println("LinkedHashSet search time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        treeSetPolicies.contains(testPolicy);
        endTime = System.nanoTime();
        System.out.println("TreeSet search time: " + (endTime - startTime) + " ns");
    }

    public static void main(String[] args) {
        InsurancePolicyManagement management = new InsurancePolicyManagement();

        management.addPolicy(new Policy("P001", "John Doe", LocalDate.now().plusDays(10), "Health", 5000.0));
        management.addPolicy(new Policy("P002", "Jane Smith", LocalDate.now().plusDays(50), "Auto", 3000.0));
        management.addPolicy(new Policy("P003", "Bob Johnson", LocalDate.now().plusDays(5), "Home", 4000.0));
        management.addPolicy(new Policy("P004", "Alice Brown", LocalDate.now().plusMonths(6), "Health", 5500.0));

        System.out.println("All unique policies:");
        management.getAllUniquePolicies().forEach(System.out::println);

        System.out.println("\nPolicies expiring soon:");
        management.getPoliciesExpiringSoon().forEach(System.out::println);

        System.out.println("\nHealth policies:");
        management.getPoliciesByCoverageType("Health").forEach(System.out::println);

        System.out.println("\nPerformance comparison:");
        management.performanceComparison();
    }
}
