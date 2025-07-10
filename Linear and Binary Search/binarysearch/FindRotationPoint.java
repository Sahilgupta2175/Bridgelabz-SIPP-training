public class FindRotationPoint {
    public static int findRotationPoint(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[][] testArrays = {
                { 4, 5, 6, 7, 0, 1, 2 },
                { 2, 3, 4, 5, 6, 7, 1 },
                { 1, 2, 3, 4, 5 },
                { 5, 1, 2, 3, 4 }
        };

        for (int i = 0; i < testArrays.length; i++) {
            int[] arr = testArrays[i];
            int rotationPoint = findRotationPoint(arr);

            System.out.print("Array " + (i + 1) + ": [");
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[j]);
                if (j < arr.length - 1)
                    System.out.print(", ");
            }
            System.out.println("]");
            System.out.println(
                    "Rotation point index: " + rotationPoint + " (smallest element: " + arr[rotationPoint] + ")");
            System.out.println();
        }
    }
}
