import java.util.HashMap;
import java.util.Map;

public class FibonacciComparison {

    private static Map<Integer, Long> memoCache = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("=== Problem 5: Fibonacci Computation Comparison ===");
        System.out.println("Recursive O(2ⁿ) vs Iterative O(N) vs Memoized O(N)");
        System.out.println("==================================================\n");

        testFibonacci();
        demonstrateFibonacciGrowth();
    }

    public static void testFibonacci() {
        int[] values = { 10, 20, 30, 35, 40, 45 };

        System.out.printf("%-15s %-20s %-20s %-20s %-15s%n",
                "Fibonacci(N)", "Recursive", "Iterative", "Memoized", "Result");
        System.out.println("------------------------------------------------------------------------------");

        for (int n : values) {
            long result = 0;

            String recursiveTime = "Too slow";
            if (n <= 40) {
                long startTime = System.nanoTime();
                result = fibonacciRecursive(n);
                long endTime = System.nanoTime();
                recursiveTime = formatTime(endTime - startTime);
            }

            long startTime = System.nanoTime();
            long iterativeResult = fibonacciIterative(n);
            long endTime = System.nanoTime();
            String iterativeTime = formatTime(endTime - startTime);

            memoCache.clear();
            startTime = System.nanoTime();
            long memoizedResult = fibonacciMemoized(n);
            endTime = System.nanoTime();
            String memoizedTime = formatTime(endTime - startTime);

            if (result == 0)
                result = iterativeResult;

            System.out.printf("%-15d %-20s %-20s %-20s %-15d%n",
                    n, recursiveTime, iterativeTime, memoizedTime, result);

            if (n <= 40 && (result != iterativeResult || result != memoizedResult)) {
                System.out.println("  ERROR: Results don't match!");
            }
        }

        System.out.println("\nAnalysis:");
        System.out.println("- Recursive: O(2ⁿ) - Exponential time, impractical for large N");
        System.out.println("- Iterative: O(N) - Linear time, memory efficient");
        System.out.println("- Memoized: O(N) - Linear time with caching, trades memory for speed");
        System.out.println("- Recursive approach has exponential growth in function calls");
    }

    public static long fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static long fibonacciIterative(int n) {
        if (n <= 1) {
            return n;
        }

        long a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static long fibonacciMemoized(int n) {
        if (n <= 1) {
            return n;
        }

        if (memoCache.containsKey(n)) {
            return memoCache.get(n);
        }

        long result = fibonacciMemoized(n - 1) + fibonacciMemoized(n - 2);
        memoCache.put(n, result);
        return result;
    }

    public static void demonstrateFibonacciGrowth() {
        System.out.println("\n=== Fibonacci Growth Demonstration ===");

        System.out.println("Fibonacci Sequence:");
        System.out.print("F(0) to F(20): ");
        for (int i = 0; i <= 20; i++) {
            System.out.print(fibonacciIterative(i) + " ");
        }
        System.out.println();

        System.out.println("\nRecursive Call Count Analysis:");
        System.out.printf("%-10s %-20s %-20s%n", "N", "Fibonacci Value", "Recursive Calls");
        System.out.println("------------------------------------------------");

        for (int n = 1; n <= 10; n++) {
            long fibValue = fibonacciIterative(n);
            long callCount = countRecursiveCalls(n);
            System.out.printf("%-10d %-20d %-20d%n", n, fibValue, callCount);
        }

        demonstrateSpaceComplexity();
    }

    public static long countRecursiveCalls(int n) {
        if (n <= 1) {
            return 1;
        }
        return 1 + countRecursiveCalls(n - 1) + countRecursiveCalls(n - 2);
    }

    public static void demonstrateSpaceComplexity() {
        System.out.println("\n=== Space Complexity Analysis ===");

        int n = 30;

        System.out.println("Recursive Approach:");
        System.out.println("- Space Complexity: O(N) - due to call stack depth");
        System.out.println("- Maximum call stack depth: " + n);

        System.out.println("\nIterative Approach:");
        System.out.println("- Space Complexity: O(1) - only uses few variables");
        System.out.println("- Memory usage: Constant regardless of N");

        System.out.println("\nMemoized Approach:");
        System.out.println("- Space Complexity: O(N) - stores all calculated values");
        System.out.println("- Memory usage: Proportional to N");

        demonstrateMatrixApproach();
    }

    public static void demonstrateMatrixApproach() {
        System.out.println("\n=== Matrix Exponentiation Approach ===");
        System.out.println("Time Complexity: O(log N)");

        int[] testValues = { 10, 20, 30, 40, 50 };

        System.out.printf("%-10s %-20s %-20s%n", "N", "Matrix Method", "Iterative Method");
        System.out.println("------------------------------------------");

        for (int n : testValues) {
            long startTime = System.nanoTime();
            long matrixResult = fibonacciMatrix(n);
            long matrixTime = System.nanoTime() - startTime;

            startTime = System.nanoTime();
            long iterativeResult = fibonacciIterative(n);
            long iterativeTime = System.nanoTime() - startTime;

            System.out.printf("%-10d %-20s %-20s%n",
                    n, formatTime(matrixTime), formatTime(iterativeTime));

            if (matrixResult != iterativeResult) {
                System.out.println("  ERROR: Matrix result doesn't match!");
            }
        }

        System.out.println("\nMatrix approach is fastest for very large N values");
    }

    public static long fibonacciMatrix(int n) {
        if (n <= 1)
            return n;

        long[][] result = matrixPower(new long[][] { { 1, 1 }, { 1, 0 } }, n - 1);
        return result[0][0];
    }

    public static long[][] matrixPower(long[][] matrix, int n) {
        if (n == 1)
            return matrix;

        if (n % 2 == 0) {
            long[][] half = matrixPower(matrix, n / 2);
            return matrixMultiply(half, half);
        } else {
            return matrixMultiply(matrix, matrixPower(matrix, n - 1));
        }
    }

    public static long[][] matrixMultiply(long[][] a, long[][] b) {
        return new long[][] {
                { a[0][0] * b[0][0] + a[0][1] * b[1][0], a[0][0] * b[0][1] + a[0][1] * b[1][1] },
                { a[1][0] * b[0][0] + a[1][1] * b[1][0], a[1][0] * b[0][1] + a[1][1] * b[1][1] }
        };
    }

    public static String formatTime(long nanoTime) {
        if (nanoTime < 1_000) {
            return nanoTime + " ns";
        } else if (nanoTime < 1_000_000) {
            return String.format("%.2f μs", nanoTime / 1_000.0);
        } else if (nanoTime < 1_000_000_000) {
            return String.format("%.2f ms", nanoTime / 1_000_000.0);
        } else {
            return String.format("%.2f s", nanoTime / 1_000_000_000.0);
        }
    }
}
