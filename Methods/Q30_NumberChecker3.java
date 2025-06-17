import java.util.Arrays;

public class Q30_NumberChecker3 {

    public static int countDigits(int n) {
        return String.valueOf(n).length();
    }

    public static int[] getDigits(int n) {
        String s = String.valueOf(n);
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++)
            digits[i] = s.charAt(i) - '0';
        return digits;
    }

    public static int[] reverseDigits(int[] arr) {
        int[] rev = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            rev[i] = arr[arr.length - 1 - i];
        return rev;
    }

    public static boolean isPalindrome(int[] digits) {
        return Arrays.equals(digits, reverseDigits(digits));
    }

    public static boolean isDuck(int[] digits) {
        for (int i = 1; i < digits.length; i++) {
            if (digits[i] == 0)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int number = 12021;
        int[] digits = getDigits(number);

        System.out.println("Number: " + number);
        System.out.println("Digits: " + Arrays.toString(digits));
        System.out.println("Reversed: " + Arrays.toString(reverseDigits(digits)));
        System.out.println("Palindrome: " + isPalindrome(digits));
        System.out.println("Duck Number: " + isDuck(digits));
    }
}
