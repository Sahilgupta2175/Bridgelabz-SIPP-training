import java.util.Scanner;

public class Q17_DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int[] freq = new int[10];
        int[] digits = new int[10];
        int index = 0;

        while (number > 0) {
            int digit = number % 10;
            digits[index++] = digit;
            freq[digit]++;
            number /= 10;
        }

        System.out.println("Digit frequencies:");
        for (int i = 0; i < 10; i++) {
            if (freq[i] > 0) {
                System.out.println("Digit " + i + " = " + freq[i]);
            }
        }
        sc.close();
    }
}
