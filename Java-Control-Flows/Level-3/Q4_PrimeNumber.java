public class Q4_PrimeNumber {
    public static void main(String[] args) {
        int number = 29;
        boolean isPrime = true;

        if (number <= 1)
            isPrime = false;
        else {
            for (int i = 2; i <= number / 2; i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        System.out.println(number + (isPrime ? " is a Prime Number" : " is not a Prime Number"));
    }
}
