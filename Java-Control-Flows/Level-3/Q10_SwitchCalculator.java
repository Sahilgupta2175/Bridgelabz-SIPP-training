public class Q10_SwitchCalculator {
    public static void main(String[] args) {
        double first = 10, second = 5;
        char op = '*';

        switch (op) {
            case '+':
                System.out.println("Result: " + (first + second));
                break;
            case '-':
                System.out.println("Result: " + (first - second));
                break;
            case '*':
                System.out.println("Result: " + (first * second));
                break;
            case '/':
                System.out.println("Result: " + (first / second));
                break;
            default:
                System.out.println("Invalid Operator");
        }
    }
}
