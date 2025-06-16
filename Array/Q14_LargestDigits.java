import java.util.Scanner;

public class Q14_LargestDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int[] digits = new int[10];
        int index = 0;

        while (number != 0 && index < 10) {
            digits[index++] = number % 10;
            number /= 10;
        }

        int first = 0, second = 0;
        for (int i = 0; i < index; i++) {
            if (digits[i] > first) {
                second = first;
                first = digits[i];
            } else if (digits[i] > second && digits[i] != first) {
                second = digits[i];
            }
        }

        System.out.println("Largest: " + first);
        System.out.println("Second Largest: " + second);
        sc.close();
    }
}
