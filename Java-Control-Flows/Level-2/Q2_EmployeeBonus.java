import java.util.Scanner;

public class Q2_EmployeeBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double salary = sc.nextDouble();
        int serviceYears = sc.nextInt();
        if (serviceYears > 5) {
            double bonus = 0.05 * salary;
            System.out.println("Bonus: " + bonus);
        } else {
            System.out.println("No bonus.");
        }
        sc.close();
    }
}
