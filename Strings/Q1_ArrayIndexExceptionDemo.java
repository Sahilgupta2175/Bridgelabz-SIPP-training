import java.util.Scanner;

public class Q1_ArrayIndexExceptionDemo {
    public static void generateException(String[] names) {
        System.out.println("Generating ArrayIndexOutOfBoundsException...");
        System.out.println(names[names.length]); // Error: index out of bounds
    }

    public static void handleException(String[] names) {
        try {
            System.out.println("Handling ArrayIndexOutOfBoundsException...");
            System.out.println(names[names.length]); // Error: index out of bounds
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught Exception: " + e);
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = new String[3];
        for (int i = 0; i < names.length; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = sc.next();
        }

        try {
            generateException(names);
        } catch (Exception ignored) {
        }
        handleException(names);
        sc.close();
    }
}
