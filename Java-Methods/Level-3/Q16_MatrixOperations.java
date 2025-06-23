import java.util.Scanner;

public class Q16_MatrixOperations {

    public static int[][] inputMatrix(int rows, int cols, Scanner sc) {
        int[][] mat = new int[rows][cols];
        System.out.println("Enter elements (" + rows + "x" + cols + "):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        return mat;
    }

    public static int[][] addMatrices(int[][] A, int[][] B) {
        int rows = A.length, cols = A[0].length;
        int[][] res = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res[i][j] = A[i][j] + B[i][j];
            }
        }
        return res;
    }

    public static int[][] subtractMatrices(int[][] A, int[][] B) {
        int rows = A.length, cols = A[0].length;
        int[][] res = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res[i][j] = A[i][j] - B[i][j];
            }
        }
        return res;
    }

    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int rows = A.length, cols = B[0].length, common = A[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < common; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

    public static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows and cols of matrices: ");
        int r = sc.nextInt(), c = sc.nextInt();

        int[][] A = inputMatrix(r, c, sc);
        int[][] B = inputMatrix(r, c, sc);

        System.out.println("\nAddition:");
        printMatrix(addMatrices(A, B));

        System.out.println("\nSubtraction:");
        printMatrix(subtractMatrices(A, B));

        System.out.println("\nMultiplication:");
        printMatrix(multiplyMatrices(A, B));

        sc.close();
    }
}
