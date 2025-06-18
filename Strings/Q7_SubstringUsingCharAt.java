import java.util.Scanner;

public class Q7_SubstringUsingCharAt {
    public static String manualSubstring(String str, int start, int end) {
        StringBuilder sub = new StringBuilder();
        for (int i = start; i < end && i < str.length(); i++) {
            sub.append(str.charAt(i));
        }
        return sub.toString();
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
        System.out.print("Enter string: ");
        String input = sc.next();
        System.out.print("Start index: ");
        int start = sc.nextInt();
        System.out.print("End index: ");
        int end = sc.nextInt();

        String manual = manualSubstring(input, start, end);
        String builtin = input.substring(start, end);

        System.out.println("Manual: " + manual);
        System.out.println("Built-in: " + builtin);
        System.out.println("Match: " + compareStrings(manual, builtin));
        sc.close();
    }
}
