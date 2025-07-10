import java.util.Arrays;

public class SearchChallenge {

    public static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    public static int binarySearchForTarget(int[] arr, int target) {
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

    public static void main(String[] args) {
        System.out.println("=== Challenge Problem: Linear and Binary Search ===\n");

        int[] testArray = { 3, 4, -1, 1, 7, 2, 9 };
        int target = 7;

        System.out.print("Original array: [");
        for (int i = 0; i < testArray.length; i++) {
            System.out.print(testArray[i]);
            if (i < testArray.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");

        int[] arrayForMissing = testArray.clone();
        int firstMissingPositive = findFirstMissingPositive(arrayForMissing);
        System.out.println("First missing positive integer: " + firstMissingPositive);

        int[] sortedArray = testArray.clone();
        Arrays.sort(sortedArray);
        System.out.print("Sorted array: [");
        for (int i = 0; i < sortedArray.length; i++) {
            System.out.print(sortedArray[i]);
            if (i < sortedArray.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");

        int targetIndex = binarySearchForTarget(sortedArray, target);
        if (targetIndex != -1) {
            System.out.println("Target " + target + " found at index: " + targetIndex);
        } else {
            System.out.println("Target " + target + " not found in the array");
        }

        System.out.println("\n=== Testing with different arrays ===");

        int[][] testCases = {
                { 1, 2, 0 },
                { 3, 4, -1, 1 },
                { 7, 8, 9, 11, 12 },
                { 1, 1000 }
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] testCase = testCases[i];
            System.out.print("Test case " + (i + 1) + ": [");
            for (int j = 0; j < testCase.length; j++) {
                System.out.print(testCase[j]);
                if (j < testCase.length - 1)
                    System.out.print(", ");
            }
            System.out.println("]");

            int[] temp = testCase.clone();
            int missing = findFirstMissingPositive(temp);
            System.out.println("First missing positive: " + missing);
            System.out.println();
        }
    }
}
