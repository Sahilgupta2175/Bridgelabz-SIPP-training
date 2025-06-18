import java.util.Scanner;

public class Q6_ConvertToLowercaseCompare {
    public static String toLowerCaseManual(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32);
            }
            result.append(ch);
        }
        return result.toString();
    }

    public static boolean compareStrings(String a, String b) {
        if (a.length() != b.length())
            return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.nextLine();

        String manual = toLowerCaseManual(input);
        String builtin = input.toLowerCase();

        System.out.println("Manual: " + manual);
        System.out.println("Built-in: " + builtin);
        System.out.println("Match: " + compareStrings(manual, builtin));
        sc.close();
    }
}
