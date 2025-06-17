import java.util.Random;

public class Q34_EmployeeBonus {

    public static void main(String[] args) {
        Random rand = new Random();
        double[][] data = new double[10][4]; // [salary, years, bonus, newSalary]
        double totalBonus = 0, totalOldSalary = 0, totalNewSalary = 0;

        for (int i = 0; i < 10; i++) {
            data[i][0] = 10000 + rand.nextInt(90000); // salary
            data[i][1] = 1 + rand.nextInt(10); // years
            double bonusRate = (data[i][1] > 5) ? 0.05 : 0.02;
            data[i][2] = data[i][0] * bonusRate;
            data[i][3] = data[i][0] + data[i][2];

            totalOldSalary += data[i][0];
            totalBonus += data[i][2];
            totalNewSalary += data[i][3];
        }

        System.out.println("ID\tSalary\tYears\tBonus\tNew Salary");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d\t%.0f\t%.0f\t%.0f\t%.0f\n", i + 1,
                    data[i][0], data[i][1], data[i][2], data[i][3]);
        }

        System.out.println("\nTotal Old Salary: " + totalOldSalary);
        System.out.println("Total Bonus Paid: " + totalBonus);
        System.out.println("Total New Salary: " + totalNewSalary);
    }
}
