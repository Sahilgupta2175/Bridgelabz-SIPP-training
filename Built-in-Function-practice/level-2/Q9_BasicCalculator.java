import java.util.Scanner;

public class Q9_BasicCalculator {
    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0)
            throw new ArithmeticException("Cannot divide by zero");
        return a / b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter two numbers: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();

        System.out.println("Choose operation (+, -, *, /): ");
        char op = sc.next().charAt(0);

        switch (op) {
            case '+':
                System.out.println("Result: " + add(a, b));
                break;
            case '-':
                System.out.println("Result: " + subtract(a, b));
                break;
            case '*':
                System.out.println("Result: " + multiply(a, b));
                break;
            case '/':
                System.out.println("Result: " + divide(a, b));
                break;
            default:
                System.out.println("Invalid operator");
        }
        sc.close();
    }
}
