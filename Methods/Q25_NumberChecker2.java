import java.util.Arrays;

public class Q25_NumberChecker2 {

    public static int countDigits(int n) {
        return String.valueOf(n).length();
    }

    public static int[] getDigits(int n) {
        String str = String.valueOf(n);
        int[] digits = new int[str.length()];
        for (int i = 0; i < str.length(); i++)
            digits[i] = str.charAt(i) - '0';
        return digits;
    }

    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int d : digits)
            sum += d;
        return sum;
    }

    public static int sumOfSquares(int[] digits) {
        int sum = 0;
        for (int d : digits)
            sum += d * d;
        return sum;
    }

    public static boolean isHarshad(int n, int[] digits) {
        int sum = sumOfDigits(digits);
        return n % sum == 0;
    }

    public static int[][] digitFrequency(int[] digits) {
        int[] freq = new int[10];
        for (int d : digits)
            freq[d]++;
        int count = 0;
        for (int f : freq)
            if (f > 0)
                count++;

        int[][] result = new int[count][2];
        int index = 0;
        for (int i = 0; i < 10; i++) {
            if (freq[i] > 0) {
                result[index][0] = i;
                result[index][1] = freq[i];
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 1223;
        int[] digits = getDigits(n);

        System.out.println("Count of Digits: " + countDigits(n));
        System.out.println("Digits: " + Arrays.toString(digits));
        System.out.println("Sum of Digits: " + sumOfDigits(digits));
        System.out.println("Sum of Squares: " + sumOfSquares(digits));
        System.out.println("Harshad Number: " + isHarshad(n, digits));

        System.out.println("Digit Frequencies:");
        for (int[] f : digitFrequency(digits)) {
            System.out.println(f[0] + " => " + f[1]);
        }
    }
}
