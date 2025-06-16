import java.util.Scanner;

public class Q19_StudentGrades2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] marks = new int[n][3];
        double[] percent = new double[n];
        String[] grade = new String[n];

        for (int i = 0; i < n;) {
            boolean valid = true;
            System.out.println("Student " + (i + 1));
            for (int j = 0; j < 3; j++) {
                String subject = j == 0 ? "Physics" : j == 1 ? "Chemistry" : "Maths";
                System.out.print("Enter marks in " + subject + ": ");
                marks[i][j] = sc.nextInt();
                if (marks[i][j] < 0) {
                    System.out.println("Invalid marks. Try again.");
                    valid = false;
                    break;
                }
            }
            if (!valid)
                continue;

            int total = marks[i][0] + marks[i][1] + marks[i][2];
            percent[i] = total / 3.0;

            if (percent[i] >= 90)
                grade[i] = "A";
            else if (percent[i] >= 75)
                grade[i] = "B";
            else if (percent[i] >= 60)
                grade[i] = "C";
            else if (percent[i] >= 50)
                grade[i] = "D";
            else
                grade[i] = "F";
            i++;
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + ": Percentage = " + percent[i] + "%, Grade = " + grade[i]);
        }
        sc.close();
    }
}
