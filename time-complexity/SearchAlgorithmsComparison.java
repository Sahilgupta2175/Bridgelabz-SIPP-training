import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class SearchAlgorithmsComparison {

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Search Algorithms Comparison ===");
        System.out.println("Linear Search O(N) vs Binary Search O(log N)");
        System.out.println("================================================\n");

        testSearchAlgorithms();
    }

    public static void testSearchAlgorithms() {
        int[] sizes = { 1000, 10000, 1000000 };

        System.out.printf("%-15s %-20s %-20s%n", "Dataset Size", "Linear Search", "Binary Search");
        System.out.println("--------------------------------------------------------");

        for (int size : sizes) {
            int[] data = generateRandomArray(size);
            int target = data[ThreadLocalRandom.current().nextInt(size)];

            long startTime = System.nanoTime();
            int linearResult = linearSearch(data, target);
            long linearTime = System.nanoTime() - startTime;

            int[] sortedData = data.clone();
            startTime = System.nanoTime();
            Arrays.sort(sortedData);
            int binaryResult = binarySearch(sortedData, target);
            long binaryTime = System.nanoTime() - startTime;

            System.out.printf("%-15d %-20s %-20s%n",
                    size,
                    formatTime(linearTime),
                    formatTime(binaryTime));

            if (linearResult != -1 && binaryResult != -1) {
                System.out.println("  ✓ Both algorithms found the target");
            }
        }

        System.out.println("\nAnalysis:");
        System.out.println("- Linear Search: O(N) - scans each element sequentially");
        System.out.println("- Binary Search: O(log N) - but requires sorted data O(N log N)");
        System.out.println("- Binary Search is efficient when data is already sorted");
        System.out.println("- For unsorted data, sorting overhead makes binary search slower initially");
    }

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(1, size * 10);
        }
        return arr;
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