import java.util.Scanner;

class Q1_BMICalculator {

    public static String[] getBMIStatus(double weight, double heightCm) {
        double heightM = heightCm / 100;
        double bmi = weight / (heightM * heightM);
        String status = "";
        if (bmi < 18.5) {
            status = "Underweight";
        } else if (bmi < 24.9) {
            status = "Normal";
        } else if (bmi < 29.9) {
            status = "Overweight";
        } else {
            status = "Obese";
        }
        return new String[] { String.format("%.2f", bmi), status };
    }

    public static String[][] processBMI(double[][] data) {
        String[][] result = new String[data.length][4];
        for (int i = 0; i < data.length; i++) {
            result[i][0] = String.valueOf(data[i][0]); // weight
            result[i][1] = String.valueOf(data[i][1]); // height
            String[] bmiInfo = getBMIStatus(data[i][0], data[i][1]);
            result[i][2] = bmiInfo[0];
            result[i][3] = bmiInfo[1];
        }
        return result;
    }

    public static void displayTable(String[][] data) {
        System.out.println("Weight\tHeight\tBMI\tStatus");
        for (String[] row : data) {
            System.out.printf("%s\t%s\t%s\t%s\n", row[0], row[1], row[2], row[3]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] input = new double[10][2];
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            input[i][0] = sc.nextDouble();
            System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
            input[i][1] = sc.nextDouble();
        }
        String[][] output = processBMI(input);
        displayTable(output);
        sc.close();
    }
}
