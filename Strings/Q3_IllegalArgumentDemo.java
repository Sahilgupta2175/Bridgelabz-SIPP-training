import java.util.Scanner;

public class Q3_IllegalArgumentDemo {
    public static void generateException(String input) {
        System.out.println(input.substring(5, 2)); // invalid args
    }

    public static void handleException(String input) {
        try {
            System.out.println(input.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("Caught Exception: " + e);
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String input = sc.next();
        try {
            generateException(input);
        } catch (Exception ignored) {
        }
        handleException(input);
        sc.close();
    }
}
