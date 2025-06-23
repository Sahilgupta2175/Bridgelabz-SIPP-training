public class Q1_SumOfDigits {

    public static int get4DigitRandomNumber() {
        return (int) (Math.random() * 9000) + 1000;
    }

    public static int countDigits(int number) {
        int count = 0;
        while (number > 0) {
            count++;
            number /= 10;
        }
        return count;
    }

    public static int[] getDigits(int number, int count) {
        int[] digits = new int[count];
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }

    public static int sumArray(int[] array) {
        int sum = 0;
        for (int n : array) {
            sum += n;
        }
        return sum;
    }

    public static void main(String[] args) {
        int num = get4DigitRandomNumber();
        System.out.println("Random number: " + num);

        int count = countDigits(num);
        int[] digits = getDigits(num, count);

        int sum = sumArray(digits);
        System.out.println("Sum of digits: " + sum);
    }
}
