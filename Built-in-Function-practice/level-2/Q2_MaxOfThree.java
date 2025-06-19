import java.util.Scanner;

public class Q2_MaxOfThree {
    public static int takeInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
        System.out.print(prompt);
        return scanner.nextInt();
    }

    public static int findMax(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        int a = takeInput("Enter first number: ");
        int b = takeInput("Enter second number: ");
        int c = takeInput("Enter third number: ");

        System.out.println("Maximum number: " + findMax(a, b, c));
    }
}
