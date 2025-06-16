import java.util.Scanner;

public class Q13_BMI_Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();

        double[][] personData = new double[n][3]; // height, weight, BMI
        String[] status = new String[n];

        for (int i = 0; i < n; i++) {
            double height, weight;
            System.out.println("Person " + (i + 1));

            do {
                System.out.print("Enter height in meters: ");
                height = sc.nextDouble();
            } while (height <= 0);

            do {
                System.out.print("Enter weight in kg: ");
                weight = sc.nextDouble();
            } while (weight <= 0);

            double bmi = weight / (height * height);

            personData[i][0] = height;
            personData[i][1] = weight;
            personData[i][2] = bmi;

            if (bmi < 18.5)
                status[i] = "Underweight";
            else if (bmi < 25)
                status[i] = "Normal";
            else if (bmi < 30)
                status[i] = "Overweight";
            else
                status[i] = "Obese";
        }

        for (int i = 0; i < n; i++) {
            System.out.printf("Person %d - Height: %.2f, Weight: %.2f, BMI: %.2f, Status: %s\n",
                    i + 1, personData[i][0], personData[i][1], personData[i][2], status[i]);
        }
        sc.close();
    }
}
