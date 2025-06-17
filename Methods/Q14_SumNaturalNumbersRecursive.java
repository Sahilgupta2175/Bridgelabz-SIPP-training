import java.util.Scanner;

public class Q14_SumNaturalNumbersRecursive {

    // recursive sum
    public static long recursiveSum(long n) {
        if (n <= 1)
            return n;
        return n + recursiveSum(n - 1);
    }

    // formula sum
    public static long formulaSum(long n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        long n = sc.nextLong();
        if (n <= 0) {
            System.out.println("Please enter a positive integer.");
            return;
        }

        long rec = recursiveSum(n);
        long form = formulaSum(n);

        System.out.println("Recursive sum : " + rec);
        System.out.println("Formula sum   : " + form);
        System.out.println(rec == form ? "Both results match" : "Mismatch");
    }
}
