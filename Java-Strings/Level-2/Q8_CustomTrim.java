import java.util.Scanner;

class Q8_CustomTrim {

    public static int[] getTrimIndexes(String str) {
        int start = 0, end = str.length() - 1;

        while (start < str.length() && str.charAt(start) == ' ')
            start++;
        while (end >= 0 && str.charAt(end) == ' ')
            end--;

        return new int[] { start, end + 1 };
    }

    public static String customSubstring(String str, int start, int end) {
        String result = "";
        for (int i = start; i < end && i < str.length(); i++) {
            result += str.charAt(i);
        }
        return result;
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
        System.out.print("Enter text with spaces: ");
        String input = sc.nextLine();

        int[] bounds = getTrimIndexes(input);
        String manualTrim = customSubstring(input, bounds[0], bounds[1]);
        String builtinTrim = input.trim();

        System.out.println("Manual Trim: '" + manualTrim + "'");
        System.out.println("Built-in Trim: '" + builtinTrim + "'");
        System.out.println("Are equal? " + compareStrings(manualTrim, builtinTrim));
        sc.close();
    }
}
