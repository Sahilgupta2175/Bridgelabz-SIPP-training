public class Q13_BonusCalculator {

    public static void main(String[] args) {
        int[][] employees = new int[10][2]; // [salary, years]
        double[][] result = new double[10][2]; // [newSalary, bonus]
        double totalOld = 0, totalNew = 0, totalBonus = 0;

        for (int i = 0; i < 10; i++) {
            employees[i][0] = (int) (Math.random() * 90000) + 10000; // salary
            employees[i][1] = (int) (Math.random() * 10) + 1; // years
            double bonusRate = employees[i][1] > 5 ? 0.05 : 0.02;
            double bonus = employees[i][0] * bonusRate;
            result[i][0] = employees[i][0] + bonus;
            result[i][1] = bonus;

            totalOld += employees[i][0];
            totalNew += result[i][0];
            totalBonus += bonus;
        }

        System.out.println("Emp\tOld\tYears\tNew\tBonus");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d\t%d\t%d\t%.2f\t%.2f\n", i + 1, employees[i][0], employees[i][1], result[i][0],
                    result[i][1]);
        }

        System.out.printf("TOTALS\t%.2f\t%.2f\t%.2f\n", totalOld, totalNew, totalBonus);
    }
}
