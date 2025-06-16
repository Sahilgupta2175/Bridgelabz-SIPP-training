import java.util.Scanner;

public class Q3_2DTo1D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Rows: ");
        int rows = sc.nextInt();
        System.out.print("Columns: ");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];
        int[] flat = new int[rows * cols];
        int index = 0;

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                System.out.print("Enter [" + i + "][" + j + "]: ");
                matrix[i][j] = sc.nextInt();
                flat[index++] = matrix[i][j];
            }

        System.out.print("1D Array: ");
        for (int val : flat) {
            System.out.print(val + " ");
        }
        sc.close();
    }
}