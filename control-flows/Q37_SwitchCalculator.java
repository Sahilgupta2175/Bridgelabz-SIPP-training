import java.util.Scanner;
public class Q37_SwitchCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble(), b = sc.nextDouble();
        String op = sc.next();
        switch (op) {
            case "+": System.out.println(a + b); break;
            case "-": System.out.println(a - b); break;
            case "*": System.out.println(a * b); break;
            case "/": System.out.println(b != 0 ? a / b : "Divide by zero"); break;
            default: System.out.println("Invalid Operator");
        }
    }
}
