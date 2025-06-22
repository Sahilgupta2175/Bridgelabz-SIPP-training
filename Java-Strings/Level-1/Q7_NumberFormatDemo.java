import java.util.Scanner;

class Q7_NumberFormatDemo {
    public static void generateException(String text) {
        int num = Integer.parseInt(text);
        System.out.println("Parsed number: " + num);
    }

    public static void handleException(String text) {
        try {
            int num = Integer.parseInt(text);
            System.out.println("Parsed number: " + num);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number (as string): ");
        String input = sc.next();
        // generateException(input); // Unsafe
        handleException(input); // Safe
        sc.close();
    }
}
