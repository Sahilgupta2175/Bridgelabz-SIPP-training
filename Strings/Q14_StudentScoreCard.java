public class Q14_StudentScoreCard {
    public static int[][] generateMarks(int students) {
        int[][] scores = new int[students][3];
        for (int i = 0; i < students; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = 50 + (int) (Math.random() * 51);
            }
        }
        return scores;
    }

    public static double[][] computeStats(int[][] scores) {
        int students = scores.length;
        double[][] stats = new double[students][3]; // total, avg, percent
        for (int i = 0; i < students; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = total / 3.0;
            double percent = (total / 300.0) * 100;
            stats[i][0] = total;
            stats[i][1] = Math.round(avg * 100.0) / 100.0;
            stats[i][2] = Math.round(percent * 100.0) / 100.0;
        }
        return stats;
    }

    public static char[] assignGrades(double[][] stats) {
        char[] grades = new char[stats.length];
        for (int i = 0; i < stats.length; i++) {
            double p = stats[i][2];
            if (p >= 90)
                grades[i] = 'A';
            else if (p >= 80)
                grades[i] = 'B';
            else if (p >= 70)
                grades[i] = 'C';
            else if (p >= 60)
                grades[i] = 'D';
            else
                grades[i] = 'F';
        }
        return grades;
    }

    public static void displayScoreCard(int[][] scores, double[][] stats, char[] grades) {
        System.out.println("Phy Chem Math | Total  Avg   %     Grade");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%3d  %3d  %3d  | %5.0f  %.2f  %.2f  %c\n",
                    scores[i][0], scores[i][1], scores[i][2],
                    stats[i][0], stats[i][1], stats[i][2], grades[i]);
        }
    }

    public static void main(String[] args) {
        int[][] marks = generateMarks(5);
        double[][] stats = computeStats(marks);
        char[] grades = assignGrades(stats);
        displayScoreCard(marks, stats, grades);
    }
}
