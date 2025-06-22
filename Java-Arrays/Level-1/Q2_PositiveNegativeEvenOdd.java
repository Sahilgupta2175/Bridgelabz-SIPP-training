import java.util.Scanner;

public class Q2_PositiveNegativeEvenOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];

        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();

            if (numbers[i] > 0) {
                System.out.print(numbers[i] + " is Positive and ");
                System.out.println((numbers[i] % 2 == 0) ? "Even" : "Odd");
            } else if (numbers[i] < 0) {
                System.out.println(numbers[i] + " is Negative");
            } else {
                System.out.println("Zero");
            }
        }

        if (numbers[0] == numbers[4]) {
            System.out.println("First and last are equal.");
        } else if (numbers[0] > numbers[4]) {
            System.out.println("First number is greater than the last.");
        } else {
            System.out.println("First number is less than the last.");
        }

        sc.close();
    }
}
