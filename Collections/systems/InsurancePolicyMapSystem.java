package systems;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

class PolicyForMap {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public PolicyForMap(String policyNumber, String policyholderName, LocalDate expiryDate,
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
    public String toString() {
        return String.format("Policy{number='%s', holder='%s', expiry=%s, type='%s', premium=%.2f}",
                policyNumber, policyholderName, expiryDate, coverageType, premiumAmount);
    }
}

public class InsurancePolicyMapSystem {
    private HashMap<String, PolicyForMap> hashMapPolicies;
    private LinkedHashMap<String, PolicyForMap> linkedHashMapPolicies;
    private TreeMap<LocalDate, PolicyForMap> treeMapPolicies;

    public InsurancePolicyMapSystem() {
        hashMapPolicies = new HashMap<>();
        linkedHashMapPolicies = new LinkedHashMap<>();
        treeMapPolicies = new TreeMap<>();
    }

    public void addPolicy(PolicyForMap policy) {
        hashMapPolicies.put(policy.getPolicyNumber(), policy);
        linkedHashMapPolicies.put(policy.getPolicyNumber(), policy);
        treeMapPolicies.put(policy.getExpiryDate(), policy);
    }

    public PolicyForMap retrievePolicyByNumber(String policyNumber) {
        return hashMapPolicies.get(policyNumber);
    }

    public List<PolicyForMap> getPoliciesExpiringWithin30Days() {
        LocalDate thirtyDaysFromNow = LocalDate.now().plusDays(30);
        return treeMapPolicies.entrySet().stream()
                .filter(entry -> entry.getKey().isBefore(thirtyDaysFromNow) ||
                        entry.getKey().isEqual(thirtyDaysFromNow))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public List<PolicyForMap> getPoliciesForPolicyholder(String policyholderName) {
        return hashMapPolicies.values().stream()
                .filter(policy -> policy.getPolicyholderName().equalsIgnoreCase(policyholderName))
                .collect(Collectors.toList());
    }

    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();

        Iterator<Map.Entry<String, PolicyForMap>> iterator = hashMapPolicies.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, PolicyForMap> entry = iterator.next();
            if (entry.getValue().getExpiryDate().isBefore(today)) {
                String policyNumber = entry.getKey();
                iterator.remove();
                linkedHashMapPolicies.remove(policyNumber);
                treeMapPolicies.remove(entry.getValue().getExpiryDate());
            }
        }
    }

    public void displayPoliciesInInsertionOrder() {
        System.out.println("Policies in insertion order:");
        linkedHashMapPolicies.values().forEach(System.out::println);
    }

    public void displayPoliciesSortedByExpiry() {
        System.out.println("Policies sorted by expiry date:");
        treeMapPolicies.values().forEach(System.out::println);
    }

    public static void main(String[] args) {
        InsurancePolicyMapSystem system = new InsurancePolicyMapSystem();

        system.addPolicy(new PolicyForMap("P001", "John Doe", LocalDate.now().plusDays(10), "Health", 5000.0));
        system.addPolicy(new PolicyForMap("P002", "Jane Smith", LocalDate.now().plusDays(50), "Auto", 3000.0));
        system.addPolicy(new PolicyForMap("P003", "John Doe", LocalDate.now().minusDays(5), "Home", 4000.0));
        system.addPolicy(new PolicyForMap("P004", "Alice Brown", LocalDate.now().plusMonths(6), "Health", 5500.0));

        System.out.println("Retrieved policy P001: " + system.retrievePolicyByNumber("P001"));

        System.out.println("\nPolicies expiring within 30 days:");
        system.getPoliciesExpiringWithin30Days().forEach(System.out::println);

        System.out.println("\nPolicies for John Doe:");
        system.getPoliciesForPolicyholder("John Doe").forEach(System.out::println);

        system.displayPoliciesInInsertionOrder();

        system.displayPoliciesSortedByExpiry();

        System.out.println("\nRemoving expired policies...");
        system.removeExpiredPolicies();

        system.displayPoliciesSortedByExpiry();
    }
}
