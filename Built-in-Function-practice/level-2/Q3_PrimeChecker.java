import java.util.Scanner;

public class Q3_PrimeChecker {
    public static boolean isPrime(int num) {
        if (num <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(num); i++)
            if (num % i == 0)
                return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        System.out.println(n + (isPrime(n) ? " is a prime." : " is not a prime."));
        sc.close();
    }
}
