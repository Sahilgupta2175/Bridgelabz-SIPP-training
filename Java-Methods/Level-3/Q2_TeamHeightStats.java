import java.util.Scanner;

public class Q2_TeamHeightStats {

    public static double findMean(double[] heights) {
        double sum = 0;
        for (double h : heights) {
            sum += h;
        }
        return sum / heights.length;
    }

    public static double findMin(double[] heights) {
        double min = heights[0];
        for (double h : heights) {
            if (h < min) {
                min = h;
            }
        }
        return min;
    }

    public static double findMax(double[] heights) {
        double max = heights[0];
        for (double h : heights) {
            if (h > max) {
                max = h;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] heights = new double[11];

        for (int i = 0; i < heights.length; i++) {
            System.out.print("Enter height (cm) of player " + (i + 1) + ": ");
            heights[i] = sc.nextDouble();
        }

        double mean = findMean(heights);
        double min = findMin(heights);
        double max = findMax(heights);

        System.out.printf("Average Height: %.2f cm\n", mean);
        System.out.printf("Shortest Player: %.2f cm\n", min);
        System.out.printf("Tallest Player : %.2f cm\n", max);

        sc.close();
    }
}
