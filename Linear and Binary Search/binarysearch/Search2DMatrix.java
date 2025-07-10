public class Search2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / cols;
            int col = mid % cols;
            int midValue = matrix[row][col];

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.print("[");
            for (int j = 0; j < row.length; j++) {
                System.out.print(row[j]);
                if (j < row.length - 1)
                    System.out.print(", ");
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {
        int[][] matrix1 = {
                { 1, 4, 7, 11 },
                { 2, 5, 8, 12 },
                { 3, 6, 9, 16 },
                { 10, 13, 14, 17 }
        };

        int[][] matrix2 = {
                { 1, 3, 5, 7 },
                { 10, 11, 16, 20 },
                { 23, 30, 34, 60 }
        };

        int[] targets = { 5, 11, 13, 20, 25 };

        System.out.println("Matrix 1:");
        printMatrix(matrix1);
        System.out.println();

        for (int target : targets) {
            boolean found = searchMatrix(matrix1, target);
            System.out.println("Searching for " + target + ": " + found);
        }

        System.out.println("\nMatrix 2:");
        printMatrix(matrix2);
        System.out.println();

        for (int target : targets) {
            boolean found = searchMatrix(matrix2, target);
            System.out.println("Searching for " + target + ": " + found);
        }
    }
}
