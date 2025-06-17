public class Q38_NumberChecker5 {

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

    public static boolean isDuckNumber(int[] digits) {
        for (int i = 1; i < digits.length; i++)
            if (digits[i] == 0)
                return true;
        return false;
    }

    public static boolean isArmstrong(int n) {
        int[] digits = getDigits(n);
        int power = digits.length;
        int sum = 0;
        for (int d : digits)
            sum += Math.pow(d, power);
        return sum == n;
    }

    public static int[] findTwoLargest(int[] digits) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        for (int d : digits) {
            if (d > max1) {
                max2 = max1;
                max1 = d;
            } else if (d > max2 && d != max1) {
                max2 = d;
            }
        }
        return new int[] { max1, max2 };
    }

    public static int[] findTwoSmallest(int[] digits) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int d : digits) {
            if (d < min1) {
                min2 = min1;
                min1 = d;
            } else if (d < min2 && d != min1) {
                min2 = d;
            }
        }
        return new int[] { min1, min2 };
    }

    public static void main(String[] args) {
        int number = 153;
        int[] digits = getDigits(number);

        System.out.println("Number: " + number);
        System.out.println("Duck Number: " + isDuckNumber(digits));
        System.out.println("Armstrong Number: " + isArmstrong(number));
        int[] largest = findTwoLargest(digits);
        int[] smallest = findTwoSmallest(digits);
        System.out.println("Largest: " + largest[0] + ", Second Largest: " + largest[1]);
        System.out.println("Smallest: " + smallest[0] + ", Second Smallest: " + smallest[1]);
    }
}
