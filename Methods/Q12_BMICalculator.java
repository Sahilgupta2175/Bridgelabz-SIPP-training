import java.util.Scanner;

public class Q12_BMICalculator {

    private static final int TEAM_SIZE = 10;

    // returns BMI for given weight‑kg and height‑cm
    public static double calculateBMI(double weightKg, double heightCm) {
        double heightM = heightCm / 100.0;
        return weightKg / (heightM * heightM);
    }

    public static String bmiStatus(double bmi) {
        if (bmi < 18.5)
            return "Underweight";
        if (bmi < 25.0)
            return "Normal";
        if (bmi < 30.0)
            return "Overweight";
        return "Obese";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] data = new double[TEAM_SIZE][3]; // 0‑wt, 1‑ht, 2‑BMI
        String[] statuses = new String[TEAM_SIZE];

        for (int i = 0; i < TEAM_SIZE; i++) {
            System.out.printf("Person %d ‑ weight (kg): ", i + 1);
            data[i][0] = sc.nextDouble();
            System.out.printf("Person %d ‑ height (cm): ", i + 1);
            data[i][1] = sc.nextDouble();
            data[i][2] = calculateBMI(data[i][0], data[i][1]);
            statuses[i] = bmiStatus(data[i][2]);
        }

        System.out.println("\nIdx\tWeight\tHeight\tBMI\t\tStatus");
        for (int i = 0; i < TEAM_SIZE; i++) {
            System.out.printf("%d\t%.1f\t%.1f\t%.2f\t%s%n", i + 1, data[i][0], data[i][1], data[i][2], statuses[i]);
        }
    }
}
