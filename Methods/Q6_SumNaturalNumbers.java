import java.util.Scanner;

public class Q6_SumNaturalNumbers {
    public static int sumOfNaturalNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Enter a positive number.");
            return;
        }

        int result = sumOfNaturalNumbers(n);
        System.out.println("Sum of " + n + " natural numbers is: " + result);
        sc.close();
    }
}
