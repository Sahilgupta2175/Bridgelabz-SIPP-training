public class FindPeakElement {
    public static int findPeakElement(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static boolean isPeak(int[] arr, int index) {
        int n = arr.length;

        if (n == 1)
            return true;
        if (index == 0)
            return arr[index] > arr[index + 1];
        if (index == n - 1)
            return arr[index] > arr[index - 1];

        return arr[index] > arr[index - 1] && arr[index] > arr[index + 1];
    }

    public static void main(String[] args) {
        int[][] testArrays = {
                { 1, 2, 3, 1 },
                { 1, 2, 1, 3, 5, 6, 4 },
                { 1, 2, 3, 4, 5 },
                { 5, 4, 3, 2, 1 },
                { 1, 3, 2, 4, 1 }
        };

        for (int i = 0; i < testArrays.length; i++) {
            int[] arr = testArrays[i];
            int peakIndex = findPeakElement(arr);

            System.out.print("Array " + (i + 1) + ": [");
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[j]);
                if (j < arr.length - 1)
                    System.out.print(", ");
            }
            System.out.println("]");
            System.out.println("Peak element found at index: " + peakIndex + " (value: " + arr[peakIndex] + ")");
            System.out.println("Is peak: " + isPeak(arr, peakIndex));
            System.out.println();
        }
    }
}
