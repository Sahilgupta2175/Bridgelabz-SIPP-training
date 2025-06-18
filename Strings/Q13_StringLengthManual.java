import java.util.Scanner;

public class Q13_StringLengthManual {
    public static int manualLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (Exception ignored) {
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.next();

        int manual = manualLength(input);
        int builtin = input.length();

        System.out.println("Manual length: " + manual);
        System.out.println("Built-in length: " + builtin);
        sc.close();
    }
}
