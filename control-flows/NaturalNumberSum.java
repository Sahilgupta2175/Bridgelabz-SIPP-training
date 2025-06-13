import java.util.Scanner;

public class NaturalNumberSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter natural numbers to sum: ");
        int number = input.nextInt();

        if (number > 0) {
            int sum = (number * (number + 1)) / 2;
            System.out.printf("The sum of %d natural numbers is %d%n.", number, sum);
        } else {
            System.out.printf("The number %d is not a natural number.", number);
        }
        input.close();
    }
}
