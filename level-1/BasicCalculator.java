import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input two numbers
        System.out.print("Enter first number: ");
        double number1 = input.nextDouble();

        System.out.print("Enter second number: ");
        double number2 = input.nextDouble();

        // Perform operations
        double sum = number1 + number2;
        double diff = number1 - number2;
        double product = number1 * number2;
        double division = number1 / number2;

        // Output
        System.out.println("The addition, subtraction, multiplication and division value of 2 numbers " +
                number1 + " and " + number2 + " is " +
                sum + ", " + diff + ", " + product + ", and " + String.format("%.2f", division));

        input.close();
    }
}
