import java.util.Scanner;

class Q1_FactorAnalysis {

    public static int[] findFactors(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
        }

        int[] factors = new int[count];
        int idx = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                factors[idx++] = i;
            }
        }
        return factors;
    }

    public static int sum(int[] arr) {
        int s = 0;
        for (int val : arr) {
            s += val;
        }
        return s;
    }

    public static int sumOfSquares(int[] arr) {
        int sumSq = 0;
        for (int val : arr) {
            sumSq += Math.pow(val, 2);
        }
        return sumSq;
    }

    public static int product(int[] arr) {
        int prod = 1;
        for (int val : arr) {
            prod *= val;
        }
        return prod;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int[] factors = findFactors(num);
        System.out.print("Factors: ");
        for (int f : factors) {
            System.out.print(f + " ");
        }

        System.out.println("\nSum of factors: " + sum(factors));
        System.out.println("Sum of squares: " + sumOfSquares(factors));
        System.out.println("Product of factors: " + product(factors));
        sc.close();
    }
}
