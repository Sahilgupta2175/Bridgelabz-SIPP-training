import java.util.Scanner;

class Q10_DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = sc.nextInt();

        int[] digits = new int[10]; // frequency array

        while (num != 0) {
            int digit = num % 10;
            digits[digit]++;
            num /= 10;
        }

        System.out.println("Digit Frequencies:");
        for (int i = 0; i < 10; i++) {
            if (digits[i] > 0) {
                System.out.println("Digit " + i + " => " + digits[i] + " times");
            }
        }
        sc.close();
    }
}
