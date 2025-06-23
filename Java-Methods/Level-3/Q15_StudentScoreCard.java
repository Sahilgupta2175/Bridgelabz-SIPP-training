public class Q15_StudentScoreCard {
    public static int[][] generateMarks(int students) {
        int[][] scores = new int[students][3];
        for (int i = 0; i < students; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = (int) (Math.random() * 41) + 60;
            }
        }
        return scores;
    }

    public static double[][] computeResults(int[][] marks) {
        double[][] results = new double[marks.length][3];
        for (int i = 0; i < marks.length; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double avg = total / 3.0;
            results[i][0] = total;
            results[i][1] = avg;
            results[i][2] = (total / 300.0) * 100;
        }
        return results;
    }

    public static void main(String[] args) {
        int[][] marks = generateMarks(5);
        double[][] results = computeResults(marks);

        System.out.println("Phy\tChem\tMath\tTotal\tAvg\t%\n");
        for (int i = 0; i < marks.length; i++) {
            System.out.printf("%d\t%d\t%d\t%.0f\t%.2f\t%.2f\n",
                    marks[i][0], marks[i][1], marks[i][2],
                    results[i][0], results[i][1], results[i][2]);
        }
    }
}
