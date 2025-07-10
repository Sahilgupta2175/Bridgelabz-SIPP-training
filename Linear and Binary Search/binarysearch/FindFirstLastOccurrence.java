public class FindFirstLastOccurrence {
    public static int findFirstOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static int findLastOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static int[] findFirstAndLastOccurrence(int[] arr, int target) {
        int first = findFirstOccurrence(arr, target);
        int last = findLastOccurrence(arr, target);
        return new int[] { first, last };
    }

    public static void main(String[] args) {
        int[] testArray1 = { 5, 7, 7, 8, 8, 10 };
        int[] testArray2 = { 5, 7, 7, 8, 8, 8, 8, 10 };
        int[] testArray3 = { 1, 2, 3, 4, 5 };

        int[][] testArrays = { testArray1, testArray2, testArray3 };
        int[] targets = { 8, 8, 6 };

        for (int i = 0; i < testArrays.length; i++) {
            int[] arr = testArrays[i];
            int target = targets[i];

            System.out.print("Array " + (i + 1) + ": [");
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[j]);
                if (j < arr.length - 1)
                    System.out.print(", ");
            }
            System.out.println("]");
            System.out.println("Target: " + target);

            int[] result = findFirstAndLastOccurrence(arr, target);
            if (result[0] == -1) {
                System.out.println("Element not found");
            } else {
                System.out.println("First occurrence at index: " + result[0]);
                System.out.println("Last occurrence at index: " + result[1]);
            }
            System.out.println();
        }
    }
}
