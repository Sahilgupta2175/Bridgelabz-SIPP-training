import java.util.Scanner;

class Q2_SubstringCompare {
    public static String manualSubstring(String str, int start, int end) {
        String result = "";
        for (int i = start; i < end && i < str.length(); i++) {
            result += str.charAt(i);
        }
        return result;
    }

    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.next();
        System.out.print("Start index: ");
        int start = sc.nextInt();
        System.out.print("End index: ");
        int end = sc.nextInt();

        String manual = manualSubstring(text, start, end);
        String builtin = text.substring(start, end);
        boolean same = compareStrings(manual, builtin);

        System.out.println("Manual Substring: " + manual);
        System.out.println("Built-in Substring: " + builtin);
        System.out.println("Are they same? " + same);
        sc.close();
    }
}
