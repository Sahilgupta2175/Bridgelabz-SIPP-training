import java.util.Random;

public class Q33_MatrixProperties {

    public static int[][] generateMatrix(int size) {
        Random rand = new Random();
        int[][] mat = new int[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                mat[i][j] = rand.nextInt(10);
        return mat;
    }

    public static int[][] transpose(int[][] mat) {
        int[][] trans = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat[0].length; j++)
                trans[j][i] = mat[i][j];
        return trans;
    }

    public static int determinant2x2(int[][] m) {
        return m[0][0] * m[1][1] - m[0][1] * m[1][0];
    }

    public static void printMatrix(int[][] m) {
        for (int[] row : m) {
            for (int val : row)
                System.out.print(val + "\t");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = generateMatrix(2);
        System.out.println("Matrix:");
        printMatrix(matrix);
        System.out.println("Transpose:");
        printMatrix(transpose(matrix));
        System.out.println("Determinant: " + determinant2x2(matrix));
    }
}
