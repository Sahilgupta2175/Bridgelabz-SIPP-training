import java.util.Scanner;

public class Q11_BonusCalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] salary = new double[10];
        double[] years = new double[10];
        double[] bonus = new double[10];
        double[] newSalary = new double[10];

        double totalBonus = 0, totalOldSalary = 0, totalNewSalary = 0;

        for (int i = 0; i < 10;) {
            System.out.print("Enter salary for employee " + (i + 1) + ": ");
            double s = sc.nextDouble();
            System.out.print("Enter years of service: ");
            double y = sc.nextDouble();

            if (s <= 0 || y < 0) {
                System.out.println("Invalid input! Try again.");
                continue;
            }

            salary[i] = s;
            years[i] = y;

            double bonusPercent = (y > 5) ? 0.05 : 0.02;
            bonus[i] = s * bonusPercent;
            newSalary[i] = s + bonus[i];

            totalBonus += bonus[i];
            totalOldSalary += s;
            totalNewSalary += newSalary[i];
            i++;
        }

        System.out.println("Total Bonus: " + totalBonus);
        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total New Salary: " + totalNewSalary);
        sc.close();
    }
}
