import java.util.Scanner;

public class Q16_SplitCompare {

    public static int manualLength(String str) {
        int len = 0;
        try {
            while (true) {
                str.charAt(len);
                len++;
            }
        } catch (Exception ignored) {
        }
        return len;
    }

    public static String[] manualSplit(String text) {
        text = text.trim() + " ";
        java.util.ArrayList<String> words = new java.util.ArrayList<>();
        StringBuilder current = new StringBuilder();
        for (int i = 0; i < manualLength(text); i++) {
            char ch = text.charAt(i);
            if (ch != ' ') {
                current.append(ch);
            } else if (current.length() > 0) {
                words.add(current.toString());
                current.setLength(0);
            }
        }
        return words.toArray(new String[0]);
    }

    public static boolean compareStringArrays(String[] a, String[] b) {
        if (a.length != b.length)
            return false;
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        String[] manual = manualSplit(input);
        String[] builtin = input.trim().split("\\s+");

        System.out.println("Match: " + compareStringArrays(manual, builtin));
        sc.close();
    }
}
