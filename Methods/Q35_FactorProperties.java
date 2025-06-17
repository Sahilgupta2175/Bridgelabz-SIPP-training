public class Q35_FactorProperties {

    public static int[] getFactors(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++)
            if (n % i == 0)
                count++;
        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= n; i++)
            if (n % i == 0)
                factors[index++] = i;
        return factors;
    }

    public static int greatestFactor(int[] factors) {
        return factors[factors.length - 1];
    }

    public static long sum(int[] arr) {
        long s = 0;
        for (int a : arr)
            s += a;
        return s;
    }

    public static long product(int[] arr) {
        long p = 1;
        for (int a : arr)
            p *= a;
        return p;
    }

    public static long productOfCubes(int[] arr) {
        long prod = 1;
        for (int a : arr)
            prod *= Math.pow(a, 3);
        return prod;
    }

    public static void main(String[] args) {
        int n = 12;
        int[] factors = getFactors(n);
        System.out.print("Factors: ");
        for (int f : factors)
            System.out.print(f + " ");
        System.out.println("\nGreatest Factor: " + greatestFactor(factors));
        System.out.println("Sum: " + sum(factors));
        System.out.println("Product: " + product(factors));
        System.out.println("Product of Cubes: " + productOfCubes(factors));
    }
}
