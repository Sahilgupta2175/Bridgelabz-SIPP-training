package systems;

import java.util.*;

public class VotingSystem {
    private HashMap<String, Integer> votes;
    private LinkedHashMap<String, Integer> votesInOrder;
    private TreeMap<String, Integer> votesSorted;

    public VotingSystem() {
        votes = new HashMap<>();
        votesInOrder = new LinkedHashMap<>();
        votesSorted = new TreeMap<>();
    }

    public void vote(String candidate) {
        votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
        votesInOrder.put(candidate, votesInOrder.getOrDefault(candidate, 0) + 1);
        votesSorted.put(candidate, votesSorted.getOrDefault(candidate, 0) + 1);
    }

    public void displayResults() {
        System.out.println("Voting Results:");
        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    public void displayResultsInVotingOrder() {
        System.out.println("Results in order of first vote:");
        for (Map.Entry<String, Integer> entry : votesInOrder.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    public void displayResultsSorted() {
        System.out.println("Results sorted by candidate name:");
        for (Map.Entry<String, Integer> entry : votesSorted.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    public String getWinner() {
        if (votes.isEmpty())
            return null;

        return votes.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();

        system.vote("Alice");
        system.vote("Bob");
        system.vote("Alice");
        system.vote("Charlie");
        system.vote("Bob");
        system.vote("Alice");

        system.displayResults();
        System.out.println();

        system.displayResultsInVotingOrder();
        System.out.println();

        system.displayResultsSorted();
        System.out.println();

        System.out.println("Winner: " + system.getWinner());
    }
}
