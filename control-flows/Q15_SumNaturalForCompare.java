import java.util.Scanner;
public class Q15_SumNaturalForCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), sum = 0;
        if (n > 0) {
            for (int i = 1; i <= n; i++) sum += i;
            int formulaSum = n * (n + 1) / 2;
            System.out.println("Sum using loop: " + sum);
            System.out.println("Sum using formula: " + formulaSum);
        } else {
            System.out.println("Not a natural number");
        }
    }
}