public class Q9_FactorOperations {

    public static int[] getFactors(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
        }
        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                factors[index++] = i;
            }
        }
        return factors;
    }

    public static int sum(int[] arr) {
        int s = 0;
        for (int x : arr) {
            s += x;
        }
        return s;
    }

    public static int product(int[] arr) {
        int p = 1;
        for (int x : arr) {
            p *= x;
        }
        return p;
    }

    public static double cubeProduct(int[] arr) {
        double p = 1;
        for (int x : arr) {
            p *= Math.pow(x, 3);
        }
        return p;
    }

    public static void main(String[] args) {
        int[] factors = getFactors(12);
        System.out.println("Sum: " + sum(factors));
        System.out.println("Product: " + product(factors));
        System.out.println("Cube Product: " + cubeProduct(factors));
    }
}
