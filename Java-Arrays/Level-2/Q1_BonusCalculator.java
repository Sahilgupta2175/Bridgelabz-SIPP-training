import java.util.Scanner;

class Q1_BonusCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] salary = new double[10];
        double[] years = new double[10];
        double[] bonus = new double[10];
        double[] newSalary = new double[10];
        double totalBonus = 0, totalOldSalary = 0, totalNewSalary = 0;

        for (int i = 0; i < 10;) {
            System.out.print("Enter salary of employee " + (i + 1) + ": ");
            double sal = sc.nextDouble();
            System.out.print("Enter years of service: ");
            double yr = sc.nextDouble();

            if (sal <= 0 || yr < 0) {
                System.out.println("Invalid input. Try again.");
                continue;
            }

            salary[i] = sal;
            years[i] = yr;
            i++;
        }

        for (int i = 0; i < 10; i++) {
            bonus[i] = (years[i] > 5) ? salary[i] * 0.05 : salary[i] * 0.02;
            newSalary[i] = salary[i] + bonus[i];
            totalBonus += bonus[i];
            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];
        }

        System.out.println("Total Bonus: " + totalBonus);
        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total New Salary: " + totalNewSalary);
        sc.close();
    }
}
