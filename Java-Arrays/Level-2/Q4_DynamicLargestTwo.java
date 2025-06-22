import java.util.Scanner;

class Q4_DynamicLargestTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = sc.nextInt();
        int maxDigit = 10, index = 0;
        int[] digits = new int[maxDigit];

        while (num != 0) {
            if (index == maxDigit) {
                maxDigit += 10;
                int[] temp = new int[maxDigit];
                System.arraycopy(digits, 0, temp, 0, digits.length);
                digits = temp;
            }
            digits[index++] = num % 10;
            num /= 10;
        }

        int max1 = -1, max2 = -1;
        for (int i = 0; i < index; i++) {
            if (digits[i] > max1) {
                max2 = max1;
                max1 = digits[i];
            } else if (digits[i] > max2 && digits[i] != max1) {
                max2 = digits[i];
            }
        }

        System.out.println("Largest: " + max1);
        System.out.println("Second Largest: " + max2);
        sc.close();
    }
}
