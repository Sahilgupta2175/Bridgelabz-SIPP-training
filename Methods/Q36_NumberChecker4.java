public class Q36_NumberChecker4 {

    public static boolean isPerfect(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++)
            if (n % i == 0)
                sum += i;
        return sum == n;
    }

    public static boolean isAbundant(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++)
            if (n % i == 0)
                sum += i;
        return sum > n;
    }

    public static boolean isDeficient(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++)
            if (n % i == 0)
                sum += i;
        return sum < n;
    }

    public static boolean isStrong(int n) {
        int original = n;
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += factorial(digit);
            n /= 10;
        }
        return sum == original;
    }

    public static int factorial(int n) {
        int f = 1;
        for (int i = 2; i <= n; i++)
            f *= i;
        return f;
    }

    public static void main(String[] args) {
        int number = 145;
        System.out.println("Perfect Number: " + isPerfect(number));
        System.out.println("Abundant Number: " + isAbundant(number));
        System.out.println("Deficient Number: " + isDeficient(number));
        System.out.println("Strong Number: " + isStrong(number));
    }
}
