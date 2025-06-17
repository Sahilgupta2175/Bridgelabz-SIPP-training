import java.util.Scanner;
import java.util.Arrays;

public class Q13_FactorAnalysis {

    // returns array of factors
    public static int[] factors(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++)
            if (n % i == 0)
                count++;

        int[] fac = new int[count];
        int idx = 0;
        for (int i = 1; i <= n; i++)
            if (n % i == 0)
                fac[idx++] = i;

        return fac;
    }

    public static long sum(int[] arr) {
        long s = 0;
        for (int x : arr)
            s += x;
        return s;
    }

    public static long sumOfSquares(int[] arr) {
        long s = 0;
        for (int x : arr)
            s += (long) x * x;
        return s;
    }

    public static long product(int[] arr) {
        long p = 1;
        for (int x : arr)
            p *= x;
        return p;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int n = sc.nextInt();

        int[] fac = factors(n);
        System.out.println("Factors: " + Arrays.toString(fac));
        System.out.println("Sum                : " + sum(fac));
        System.out.println("Sum of squares     : " + sumOfSquares(fac));
        System.out.println("Product            : " + product(fac));
        sc.close();
    }
}
