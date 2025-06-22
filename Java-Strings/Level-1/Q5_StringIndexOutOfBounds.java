import java.util.Scanner;

class Q5_StringIndexOutOfBounds {
    public static void generateException(String text) {
        System.out.println(text.charAt(text.length())); // Out of bounds
    }

    public static void handleException(String text) {
        try {
            System.out.println(text.charAt(text.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.next();
        // generateException(input); // Uncomment to crash
        handleException(input); // Safe
        sc.close();
    }
}
