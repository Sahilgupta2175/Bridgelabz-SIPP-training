public class Q17_MatrixAdvancedOps {

    public static int[][] transpose(int[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        int[][] transposed = new int[c][r];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }

    public static double[][] inverse2x2(int[][] mat) {
        int a = mat[0][0], b = mat[0][1], c = mat[1][0], d = mat[1][1];
        int det = a * d - b * c;
        if (det == 0) {
            return null;
        }

        double[][] inv = new double[2][2];
        inv[0][0] = d / (double) det;
        inv[0][1] = -b / (double) det;
        inv[1][0] = -c / (double) det;
        inv[1][1] = a / (double) det;
        return inv;
    }

    public static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }

    public static void printMatrix(double[][] mat) {
        for (double[] row : mat) {
            for (double val : row) {
                System.out.printf("%.2f\t", val);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 4, 7 }, { 2, 6 } };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        System.out.println("\nTranspose:");
        printMatrix(transpose(matrix));

        System.out.println("\nInverse (2x2):");
        double[][] inverse = inverse2x2(matrix);
        if (inverse != null) {
            printMatrix(inverse);
        } else {
            System.out.println("Inverse not possible (determinant is zero).");
        }
    }
}
