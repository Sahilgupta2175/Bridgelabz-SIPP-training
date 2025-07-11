import java.util.concurrent.ThreadLocalRandom;

public class SortingAlgorithmsComparison {

    public static void main(String[] args) {
        System.out.println("=== Problem 2: Sorting Algorithms Comparison ===");
        System.out.println("Bubble Sort O(N²) vs Merge Sort O(N log N) vs Quick Sort O(N log N)");
        System.out.println("================================================================\n");

        testSortingAlgorithms();
    }

    public static void testSortingAlgorithms() {
        int[] sizes = { 1000, 10000, 100000 };

        System.out.printf("%-15s %-15s %-15s %-15s%n", "Dataset Size", "Bubble Sort", "Merge Sort", "Quick Sort");
        System.out.println("----------------------------------------------------------------");

        for (int size : sizes) {
            int[] originalData = generateRandomArray(size);

            String bubbleTime = "Too slow";
            if (size <= 10000) {
                int[] bubbleData = originalData.clone();
                long startTime = System.nanoTime();
                bubbleSort(bubbleData);
                long endTime = System.nanoTime();
                bubbleTime = formatTime(endTime - startTime);

                if (!isSorted(bubbleData)) {
                    System.out.println("ERROR: Bubble sort failed!");
                }
            }

            int[] mergeData = originalData.clone();
            long startTime = System.nanoTime();
            mergeSort(mergeData, 0, mergeData.length - 1);
            long endTime = System.nanoTime();
            String mergeTime = formatTime(endTime - startTime);

            if (!isSorted(mergeData)) {
                System.out.println("ERROR: Merge sort failed!");
            }

            int[] quickData = originalData.clone();
            startTime = System.nanoTime();
            quickSort(quickData, 0, quickData.length - 1);
            endTime = System.nanoTime();
            String quickTime = formatTime(endTime - startTime);

            if (!isSorted(quickData)) {
                System.out.println("ERROR: Quick sort failed!");
            }

            System.out.printf("%-15d %-15s %-15s %-15s%n",
                    size, bubbleTime, mergeTime, quickTime);
        }

        System.out.println("\nAnalysis:");
        System.out.println("- Bubble Sort: O(N²) - Inefficient for large datasets");
        System.out.println("- Merge Sort: O(N log N) - Stable, consistent performance");
        System.out.println("- Quick Sort: O(N log N) average - Fast, but O(N²) worst case");
        System.out.println("- Merge Sort guarantees O(N log N), Quick Sort is faster on average");
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(1, size * 10);
        }
        return arr;
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
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
