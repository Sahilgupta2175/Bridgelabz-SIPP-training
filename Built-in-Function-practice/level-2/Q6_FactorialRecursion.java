import java.util.Scanner;

public class Q6_FactorialRecursion {
    public static long factorial(int n) {
        if (n == 0)
            return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        System.out.println("Factorial: " + factorial(n));
        sc.close();
    }
}
