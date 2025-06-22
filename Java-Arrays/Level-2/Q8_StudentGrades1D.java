import java.util.Scanner;

class Q8_StudentGrades1D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] physics = new int[n];
        int[] chemistry = new int[n];
        int[] maths = new int[n];
        double[] percent = new double[n];
        char[] grade = new char[n];

        for (int i = 0; i < n;) {
            System.out.println("Student " + (i + 1));
            System.out.print("Physics marks: ");
            int p = sc.nextInt();
            System.out.print("Chemistry marks: ");
            int c = sc.nextInt();
            System.out.print("Maths marks: ");
            int m = sc.nextInt();

            if (p < 0 || c < 0 || m < 0) {
                System.out.println("Invalid marks. Try again.");
                continue;
            }

            physics[i] = p;
            chemistry[i] = c;
            maths[i] = m;

            percent[i] = (p + c + m) / 3.0;

            if (percent[i] >= 90) {
                grade[i] = 'A';
            } else if (percent[i] >= 80) {
                grade[i] = 'B';
            } else if (percent[i] >= 70) {
                grade[i] = 'C';
            } else if (percent[i] >= 60) {
                grade[i] = 'D';
            } else {
                grade[i] = 'F';
            }
            i++;
        }

        System.out.println("\nPhysics Chemistry Maths Percentage Grade");
        for (int i = 0; i < n; i++) {
            System.out.printf("%7d %9d %6d %10.2f %6c\n", physics[i], chemistry[i], maths[i], percent[i], grade[i]);
        }
        sc.close();
    }
}
