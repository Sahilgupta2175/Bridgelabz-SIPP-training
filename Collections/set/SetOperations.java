package set;

import java.util.*;

public class SetOperations {

    public static <T> boolean areEqual(Set<T> set1, Set<T> set2) {
        return set1.equals(set2);
    }

    public static <T> Set<T> union(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }

    public static <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }

    public static <T> Set<T> symmetricDifference(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        Set<T> temp = new HashSet<>(set2);

        result.addAll(set2);
        temp.retainAll(set1);
        result.removeAll(temp);

        return result;
    }

    public static List<Integer> convertToSortedList(Set<Integer> set) {
        List<Integer> result = new ArrayList<>(set);
        Collections.sort(result);
        return result;
    }

    public static <T> boolean isSubset(Set<T> subset, Set<T> superset) {
        return superset.containsAll(subset);
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 2, 1));
        System.out.println("Set1: " + set1 + ", Set2: " + set2);
        System.out.println("Are equal: " + areEqual(set1, set2));

        Set<Integer> set3 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set4 = new HashSet<>(Arrays.asList(3, 4, 5));
        System.out.println("\nSet3: " + set3 + ", Set4: " + set4);
        System.out.println("Union: " + union(set3, set4));
        System.out.println("Intersection: " + intersection(set3, set4));
        System.out.println("Symmetric Difference: " + symmetricDifference(set3, set4));

        Set<Integer> set5 = new HashSet<>(Arrays.asList(5, 3, 9, 1));
        System.out.println("\nSet: " + set5);
        System.out.println("Sorted List: " + convertToSortedList(set5));

        Set<Integer> subset = new HashSet<>(Arrays.asList(2, 3));
        Set<Integer> superset = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        System.out.println("\nSubset: " + subset + ", Superset: " + superset);
        System.out.println("Is subset: " + isSubset(subset, superset));
    }
}
