import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class DataStructureSearchComparison {

    public static void main(String[] args) {
        System.out.println("=== Problem 6: Data Structure Search Comparison ===");
        System.out.println("Array O(N) vs HashSet O(1) vs TreeSet O(log N)");
        System.out.println("===============================================\n");

        testDataStructureSearch();
        demonstrateDataStructureProperties();
    }

    public static void testDataStructureSearch() {
        int[] sizes = { 1000, 10000, 100000, 1000000 };

        System.out.printf("%-15s %-15s %-15s %-15s %-15s%n",
                "Dataset Size", "Array Search", "HashSet Search", "TreeSet Search", "LinkedList Search");
        System.out.println("--------------------------------------------------------------------------------");

        for (int size : sizes) {
            Integer[] data = generateRandomData(size);
            Integer target = data[ThreadLocalRandom.current().nextInt(size)];

            long startTime = System.nanoTime();
            boolean arrayFound = arraySearch(data, target);
            long arrayTime = System.nanoTime() - startTime;

            HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(data));
            startTime = System.nanoTime();
            boolean hashSetFound = hashSet.contains(target);
            long hashSetTime = System.nanoTime() - startTime;

            TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(data));
            startTime = System.nanoTime();
            boolean treeSetFound = treeSet.contains(target);
            long treeSetTime = System.nanoTime() - startTime;

            LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(data));
            startTime = System.nanoTime();
            boolean linkedListFound = linkedList.contains(target);
            long linkedListTime = System.nanoTime() - startTime;

            System.out.printf("%-15d %-15s %-15s %-15s %-15s%n",
                    size,
                    formatTime(arrayTime),
                    formatTime(hashSetTime),
                    formatTime(treeSetTime),
                    formatTime(linkedListTime));

            if (arrayFound && hashSetFound && treeSetFound && linkedListFound) {
                // All good
            } else {
                System.out.println("  WARNING: Inconsistent search results!");
            }
        }

        System.out.println("\nAnalysis:");
        System.out.println("- Array: O(N) - Linear search, simple but slow for large datasets");
        System.out.println("- HashSet: O(1) - Constant time average, fastest for lookups");
        System.out.println("- TreeSet: O(log N) - Logarithmic time, maintains sorted order");
        System.out.println("- LinkedList: O(N) - Linear search, slower than array due to cache misses");

        testInsertionDeletion();
    }

    public static boolean arraySearch(Integer[] arr, Integer target) {
        for (Integer element : arr) {
            if (element.equals(target)) {
                return true;
            }
        }
        return false;
    }

    public static void testInsertionDeletion() {
        System.out.println("\n=== Insertion and Deletion Performance ===");

        int operations = 100000;
        Integer[] testData = generateRandomData(operations);

        System.out.printf("%-20s %-15s %-15s%n", "Operation", "HashSet", "TreeSet");
        System.out.println("------------------------------------------------");

        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        long startTime = System.nanoTime();
        for (Integer value : testData) {
            hashSet.add(value);
        }
        long hashSetInsertTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (Integer value : testData) {
            treeSet.add(value);
        }
        long treeSetInsertTime = System.nanoTime() - startTime;

        System.out.printf("%-20s %-15s %-15s%n",
                "Insert " + operations,
                formatTime(hashSetInsertTime),
                formatTime(treeSetInsertTime));

        Integer[] toDelete = Arrays.copyOf(testData, Math.min(10000, testData.length));

        startTime = System.nanoTime();
        for (Integer value : toDelete) {
            hashSet.remove(value);
        }
        long hashSetDeleteTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (Integer value : toDelete) {
            treeSet.remove(value);
        }
        long treeSetDeleteTime = System.nanoTime() - startTime;

        System.out.printf("%-20s %-15s %-15s%n",
                "Delete " + toDelete.length,
                formatTime(hashSetDeleteTime),
                formatTime(treeSetDeleteTime));
    }

    public static void demonstrateDataStructureProperties() {
        System.out.println("\n=== Data Structure Properties Demonstration ===");

        Integer[] sampleData = { 5, 2, 8, 1, 9, 3, 7, 4, 6, 2, 5 }; 

        System.out.println("Original data: " + Arrays.toString(sampleData));

        System.out.println("\nArray Properties:");
        System.out.println("- Maintains insertion order: " + Arrays.toString(sampleData));
        System.out.println("- Allows duplicates: Yes");
        System.out.println("- Indexed access: O(1)");
        System.out.println("- Search: O(N)");

        HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(sampleData));
        System.out.println("\nHashSet Properties:");
        System.out.println("- No duplicates: " + hashSet);
        System.out.println("- No guaranteed order: " + hashSet);
        System.out.println("- Search/Insert/Delete: O(1) average");

        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(sampleData));
        System.out.println("\nTreeSet Properties:");
        System.out.println("- No duplicates: " + treeSet);
        System.out.println("- Sorted order: " + treeSet);
        System.out.println("- Search/Insert/Delete: O(log N)");

        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>(Arrays.asList(sampleData));
        System.out.println("\nLinkedHashSet Properties:");
        System.out.println("- No duplicates: " + linkedHashSet);
        System.out.println("- Maintains insertion order: " + linkedHashSet);
        System.out.println("- Search/Insert/Delete: O(1) average");

        demonstrateTreeSetOperations();
    }

    public static void demonstrateTreeSetOperations() {
        System.out.println("\n=== TreeSet Specific Operations ===");

        TreeSet<Integer> treeSet = new TreeSet<>();
        int[] values = { 50, 30, 70, 20, 40, 60, 80, 10, 35, 65, 75 };

        for (int value : values) {
            treeSet.add(value);
        }

        System.out.println("TreeSet: " + treeSet);

        System.out.println("\nRange Operations:");
        System.out.println("first(): " + treeSet.first());
        System.out.println("last(): " + treeSet.last());
        System.out.println("headSet(50): " + treeSet.headSet(50));
        System.out.println("tailSet(50): " + treeSet.tailSet(50));
        System.out.println("subSet(30, 70): " + treeSet.subSet(30, 70));

        System.out.println("\nNavigation Operations:");
        System.out.println("lower(50): " + treeSet.lower(50));
        System.out.println("higher(50): " + treeSet.higher(50));
        System.out.println("floor(45): " + treeSet.floor(45));
        System.out.println("ceiling(45): " + treeSet.ceiling(45));

        testRangeQueryPerformance();
    }

    public static void testRangeQueryPerformance() {
        System.out.println("\n=== Range Query Performance ===");

        int size = 100000;
        Integer[] data = generateRandomData(size);

        Arrays.sort(data);

        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(data));

        int rangeStart = size / 4;
        int rangeEnd = 3 * size / 4;

        long startTime = System.nanoTime();
        List<Integer> arrayResult = new ArrayList<>();
        for (Integer value : data) {
            if (value >= rangeStart && value <= rangeEnd) {
                arrayResult.add(value);
            }
        }
        long arrayRangeTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        NavigableSet<Integer> treeResult = treeSet.subSet(rangeStart, true, rangeEnd, true);
        long treeRangeTime = System.nanoTime() - startTime;

        System.out.printf("%-20s %-15s %-15s%n", "Operation", "Array", "TreeSet");
        System.out.println("------------------------------------------------");
        System.out.printf("%-20s %-15s %-15s%n",
                "Range Query",
                formatTime(arrayRangeTime),
                formatTime(treeRangeTime));

        System.out.println("Array result size: " + arrayResult.size());
        System.out.println("TreeSet result size: " + treeResult.size());
    }

    public static Integer[] generateRandomData(int size) {
        Integer[] data = new Integer[size];
        for (int i = 0; i < size; i++) {
            data[i] = ThreadLocalRandom.current().nextInt(1, size * 10);
        }
        return data;
    }

    public static String formatTime(long nanoTime) {
        if (nanoTime < 1_000) {
            return nanoTime + " ns";
        } else if (nanoTime < 1_000_000) {
            return String.format("%.2f μs", nanoTime / 1_000.0);
        } else if (nanoTime < 1_000_000_000) {
            return String.format("%.2f ms", nanoTime / 1_000_000.0);
        } else {
            return String.format("%.2f s", nanoTime / 1_000_000_000.0);
        }
    }
}
