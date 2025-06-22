import java.util.Scanner;

public class Q9_2Dto1D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter cols: ");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];
        int[] array = new int[rows * cols];
        int index = 0;

        System.out.println("Enter matrix elements:");
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = sc.nextInt();

        for (int[] row : matrix)
            for (int val : row)
                array[index++] = val;

        System.out.print("1D Array: ");
        for (int val : array)
            System.out.print(val + " ");
        sc.close();
    }
}
