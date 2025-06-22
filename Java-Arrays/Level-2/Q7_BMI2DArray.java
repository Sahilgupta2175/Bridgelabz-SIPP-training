import java.util.Scanner;

class Q7_BMI2DArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();

        double[][] personData = new double[n][3]; // weight, height, BMI
        String[] weightStatus = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            personData[i][0] = sc.nextDouble();
            System.out.print("Enter height (m) for person " + (i + 1) + ": ");
            personData[i][1] = sc.nextDouble();

            personData[i][2] = personData[i][0] / (personData[i][1] * personData[i][1]);

            if (personData[i][2] < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] < 24.9) {
                weightStatus[i] = "Normal";
            } else if (personData[i][2] < 29.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        System.out.println("\nHeight\tWeight\tBMI\tStatus");
        for (int i = 0; i < n; i++) {
            System.out.printf("%.2f\t%.2f\t%.2f\t%s\n", personData[i][1], personData[i][0], personData[i][2],
                    weightStatus[i]);
        }
        sc.close();
    }
}
