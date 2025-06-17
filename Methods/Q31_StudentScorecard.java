import java.util.Random;
import java.util.Scanner;

public class Q31_StudentScorecard {

    public static int[][] generateScores(int n) {
        Random rand = new Random();
        int[][] scores = new int[n][3]; // Physics, Chemistry, Maths
        for (int i = 0; i < n; i++) {
            scores[i][0] = 50 + rand.nextInt(50); // Physics
            scores[i][1] = 50 + rand.nextInt(50); // Chemistry
            scores[i][2] = 50 + rand.nextInt(50); // Maths
        }
        return scores;
    }

    public static double[][] calculateStats(int[][] scores) {
        double[][] result = new double[scores.length][3]; // total, avg, percent
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = total / 3.0;
            double percent = total / 3.0;
            result[i][0] = total;
            result[i][1] = Math.round(avg * 100.0) / 100.0;
            result[i][2] = Math.round(percent * 100.0) / 100.0;
        }
        return result;
    }

    public static void displayScorecard(int[][] scores, double[][] stats) {
        System.out.println("ID\tPhy\tChem\tMath\tTotal\tAvg\tPercent");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%d\t%d\t%d\t%d\t%.0f\t%.2f\t%.2f\n", i + 1,
                    scores[i][0], scores[i][1], scores[i][2],
                    stats[i][0], stats[i][1], stats[i][2]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        int[][] scores = generateScores(n);
        double[][] stats = calculateStats(scores);
        displayScorecard(scores, stats);
        sc.close();
    }
}
