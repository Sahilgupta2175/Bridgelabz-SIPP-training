import java.util.Scanner;

public class SumUntilNegative {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sum = 0;

        while (true) {
            System.out.println("Enter numbers to sum (negative number to stop): ");
            int number = input.nextInt();
            if (number <= 0) {
                break;
            }
            sum += number;
        }

        System.out.println("Sum Until Negative: " + sum);
        input.close();
    }
}