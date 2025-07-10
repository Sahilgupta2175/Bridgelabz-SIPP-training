public class FindFirstNegativeNumber {
    public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] testArray1 = { 5, 3, -2, 8, -1, 9 };
        int[] testArray2 = { 1, 2, 3, 4, 5 };
        int[] testArray3 = { -1, -2, -3 };

        System.out.println("Test Array 1: [5, 3, -2, 8, -1, 9]");
        int result1 = findFirstNegative(testArray1);
        if (result1 != -1) {
            System.out.println(
                    "First negative number found at index: " + result1 + " (value: " + testArray1[result1] + ")");
        } else {
            System.out.println("No negative number found");
        }

        System.out.println("\nTest Array 2: [1, 2, 3, 4, 5]");
        int result2 = findFirstNegative(testArray2);
        if (result2 != -1) {
            System.out.println(
                    "First negative number found at index: " + result2 + " (value: " + testArray2[result2] + ")");
        } else {
            System.out.println("No negative number found");
        }

        System.out.println("\nTest Array 3: [-1, -2, -3]");
        int result3 = findFirstNegative(testArray3);
        if (result3 != -1) {
            System.out.println(
                    "First negative number found at index: " + result3 + " (value: " + testArray3[result3] + ")");
        } else {
            System.out.println("No negative number found");
        }
    }
}
