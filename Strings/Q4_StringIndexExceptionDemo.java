import java.util.Scanner;

public class Q4_StringIndexExceptionDemo {
    public static void generateException(String text) {
        System.out.println(text.charAt(text.length())); // out of bounds
    }

    public static void handleException(String text) {
        try {
            System.out.println(text.charAt(text.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught Exception: " + e);
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.next();
        try {
            generateException(text);
        } catch (Exception ignored) {
        }
        handleException(text);
        sc.close();
    }
}
