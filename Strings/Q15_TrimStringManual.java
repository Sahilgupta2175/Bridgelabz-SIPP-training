import java.util.Scanner;

public class Q15_TrimStringManual {
    public static int[] findTrimIndices(String text) {
        int start = 0;
        int end = text.length() - 1;

        while (start <= end && text.charAt(start) == ' ')
            start++;
        while (end >= start && text.charAt(end) == ' ')
            end--;

        return new int[] { start, end + 1 }; // end + 1 because substring is exclusive
    }

    public static String manualSubstring(String text, int start, int end) {
        StringBuilder sub = new StringBuilder();
        for (int i = start; i < end && i < text.length(); i++) {
            sub.append(text.charAt(i));
        }
        return sub.toString();
    }

    public static boolean compare(String a, String b) {
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
        System.out.print("Enter text with spaces: ");
        String input = sc.nextLine();

        int[] indices = findTrimIndices(input);
        String manual = manualSubstring(input, indices[0], indices[1]);
        String builtin = input.trim();

        System.out.println("Manual: [" + manual + "]");
        System.out.println("Built-in: [" + builtin + "]");
        System.out.println("Match: " + compare(manual, builtin));
        sc.close();
    }
}
