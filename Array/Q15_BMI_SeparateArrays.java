import java.util.Scanner;

public class Q15_BMI_SeparateArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();

        double[] height = new double[n];
        double[] weight = new double[n];
        double[] bmi = new double[n];
        String[] status = new String[n];

        for (int i = 0; i < n; i++) {
            do {
                System.out.print("Enter height (m) for person " + (i + 1) + ": ");
                height[i] = sc.nextDouble();
            } while (height[i] <= 0);

            do {
                System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
                weight[i] = sc.nextDouble();
            } while (weight[i] <= 0);

            bmi[i] = weight[i] / (height[i] * height[i]);

            if (bmi[i] < 18.5)
                status[i] = "Underweight";
            else if (bmi[i] < 25)
                status[i] = "Normal";
            else if (bmi[i] < 30)
                status[i] = "Overweight";
            else
                status[i] = "Obese";
        }

        for (int i = 0; i < n; i++) {
            System.out.printf("Person %d - Height: %.2f, Weight: %.2f, BMI: %.2f, Status: %s\n",
                    i + 1, height[i], weight[i], bmi[i], status[i]);
        }
        sc.close();
    }
}
