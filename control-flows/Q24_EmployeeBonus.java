import java.util.Scanner;
public class Q24_EmployeeBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double salary = sc.nextDouble();
        int years = sc.nextInt();
        if (years > 5)
            System.out.println("Bonus: " + (0.05 * salary));
        else
            System.out.println("No bonus");
    }
}
