import java.util.Scanner;

class Q6_IllegalArgumentDemo {
    public static void generateException(String text) {
        System.out.println(text.substring(5, 2)); // Invalid start > end
    }

    public static void handleException(String text) {
        try {
            System.out.println(text.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.next();
        // generateException(input); // Will crash
        handleException(input); // Safe
        sc.close();
    }
}
